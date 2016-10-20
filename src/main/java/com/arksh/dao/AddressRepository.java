package com.arksh.dao;

import com.arksh.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
