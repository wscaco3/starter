package com.arksh.service;

import com.arksh.mapper.AddressMapper;
import com.arksh.model.Address;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qq on 2016/10/21.
 */
@Service
@CacheConfig(cacheNames = "addresses")
public class AddressService {
    @Autowired
    AddressMapper mapper;

    public PageInfo<Address> getAll(Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        List<Address> list = mapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public Address getOne(String id){
        return mapper.selectByPrimaryKey(id);
    }

    public int save(Address t){
        return mapper.insert(t);
    }

    public int update(Address t){
        return mapper.updateByPrimaryKey(t);
    }

    public int delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }
}
