package com.arksh.mapper;

import java.util.List;
import java.util.Map;


/**
 * @author ShenHuaJie
 * @version 2016年6月3日 下午2:30:14
 */
public interface BaseExpandMapper {
    /** 条件分页查询 */
	List<String> query(Map<String, Object> params);
}
