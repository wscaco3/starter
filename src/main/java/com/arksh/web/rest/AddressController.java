package com.arksh.web.rest;

import com.arksh.model.Address;
import com.arksh.service.AddressService;
import com.arksh.service.LogicService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2016/8/4 0004.
 */
@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    LogicService logicService;

//    @GetMapping
//    public PageInfo<Address> getAddressList(@RequestParam(defaultValue = "1") Integer page,
//                                            @RequestParam(defaultValue = "10") Integer size,
//                                            @RequestParam(required = false) Integer personId,
//                                            @RequestParam(required = false) String keyword) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("person_id",personId);
//        map.put("keyword",keyword);
//        List<String> idList = addressService.getAll(page,size,map);
//        List<Address> list = idList.stream().map(addressService::getOne).collect(Collectors.toList());
//        return new PageInfo(list);
//    }
    @GetMapping
    public PageInfo<Map<String,Object>> getAddressList(@RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "10") Integer size,
                                            @RequestParam(required = false) String keyword) {
        return addressService.queryByPersonName(page,size,keyword);
    }
    @GetMapping("/{id}")
    public Address getAddress(@PathVariable String id) {
        Address address = addressService.getOne(id);
        return address;
    }


    @PostMapping
    public String postAddress(@RequestBody Address address){
        address.setId(logicService.createId(address));
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
