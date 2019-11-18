package com.myspringbt.demo.service;

import com.myspringbt.demo.dao.priDataSource.JobDbMapper;
import com.myspringbt.demo.dao.secondDataSource.SecondJobdbMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JobService {

    @Autowired
    private JobDbMapper job;
    @Autowired
    private SecondJobdbMapper job2;

    public List<Map<String, Object>> getAllUser(String type) {
        List<Map<String, Object>> result = new ArrayList<>();
        if (StringUtils.isNotBlank(type)) {
            result = job.getAllJob();
            return result;
        }
        return job2.getJob();
    }
}
