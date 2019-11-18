package com.myspringbt.demo.dao.priDataSource;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface JobDbMapper {

    List<Map<String, Object>> getAllJob();
}
