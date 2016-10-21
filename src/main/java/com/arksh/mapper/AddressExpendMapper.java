package com.arksh.mapper;

import java.util.List;
import java.util.Map;

public interface AddressExpendMapper extends BaseExpandMapper {
    List<Map<String,Object>> queryByPersonName(String kerword);
}