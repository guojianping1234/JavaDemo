package com.myspringbt.demo.dao.secondDataSource;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

@Mapper
public interface SecondJobdbMapper {
    List<Map<String, Object>> getJob();
}
