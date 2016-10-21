package com.arksh.service;

import com.arksh.mapper.AddressExpendMapper;
import com.arksh.mapper.AddressMapper;
import com.arksh.model.Address;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by qq on 2016/10/21.
 */
@Service
@CacheConfig(cacheNames = "address")
public class AddressService {
    @Autowired
    AddressMapper mapper;
    @Autowired
    AddressExpendMapper expendMapper;

    public List<String> getAll(Integer page,Integer rows,Map<String,Object> params){
        PageHelper.startPage(page, rows);
        List<String> list = expendMapper.query(params);
        return list;
    }

    public PageInfo<Map<String,Object>> queryByPersonName(Integer page,Integer rows,String keyword){
        PageHelper.startPage(page, rows);
        List<Map<String,Object>> list = expendMapper.queryByPersonName(keyword);
        return new PageInfo(list);
    }

    @Cacheable
    public Address getOne(String id){
        return mapper.selectByPrimaryKey(id);
    }

    @CachePut
    public Address save(Address t){
        if(mapper.insert(t)>0){
            return t;
        }
        else return null;
    }

    @CachePut
    public Address update(Address t){
        if(mapper.updateByPrimaryKey(t)>0){
            return t;
        }
        else return null;
    }

    @CacheEvict
    public int delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }
}
