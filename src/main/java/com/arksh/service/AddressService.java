package com.arksh.service;

import com.arksh.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public interface AddressService {
    Address save(Address address);
    void delete(Integer id);
    Address getOne(Integer id);
    Page<Address> findAll(Pageable pageable);
}
