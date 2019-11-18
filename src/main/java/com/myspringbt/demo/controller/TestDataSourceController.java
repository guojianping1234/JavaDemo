package com.myspringbt.demo.controller;

import com.myspringbt.demo.model.JsonResult;
import com.myspringbt.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("v1/source")
public class TestDataSourceController {
    @Autowired
    private JobService userService;


    @GetMapping("/getAllUser")
    public JsonResult getAllUser(@RequestParam(name = "type", required = false) String type) {
        List<Map<String, Object>> result = userService.getAllUser(type);
        JsonResult j = new JsonResult();
        j.setData(result);
        return j;
    }


}
