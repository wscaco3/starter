package com.arksh.web.rest;

import com.arksh.mapper.AddressMapper;
import com.arksh.model.Address;
import com.arksh.service.AddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public PageInfo<Address> getAddressList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return addressService.getAll(page,size);
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable String id) {
        return addressService.getOne(id);
    }


    @PostMapping
    public String postAddress(@RequestBody Address address){
        addressService.save(address);
        return "success";
    }

    @PutMapping("/{id}")
    public String putAddress(@RequestBody Address address){
        addressService.update(address);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable String id) {
        addressService.delete(id);
        return "success";
    }
}
