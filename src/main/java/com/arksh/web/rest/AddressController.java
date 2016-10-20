package com.arksh.web.rest;

import com.arksh.domain.Address;
import com.arksh.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
@RestController
@RequestMapping("/api/persons")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public Page<Address> getAddressList(@RequestParam Integer page, @RequestParam Integer size) {
        return addressService.findAll(new PageRequest(page,size));
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Integer id) {
        return addressService.getOne(id);
    }


    @PostMapping
    public String postAddress(@RequestBody Address user){
        addressService.save(user);
        return "success";
    }

    @PutMapping("/{id}")
    public String putAddress(@PathVariable Integer id,@RequestBody Address address){
        Address a = addressService.getOne(id);
        a.setPersonId(address.getPersonId());
        a.setCity(address.getCity());
        a.setPersonId(address.getPersonId());
        a.setProvince(address.getProvince());
        a.setCountry(address.getCountry());
        addressService.save(a);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Integer id) {
        addressService.delete(id);
        return "success";
    }
}
