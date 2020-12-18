package com.lzq.dispose_exception.controller;

import com.lzq.dispose_exception.vo.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

/**
 * @author lzq
 * @version 1.0
 * @date 2020/12/18 9:58
 */
@RestController
public class TestController {
    @GetMapping(value = "user")
    public BaseResult findUser(@RequestParam(value = "id",required = false) Integer id) {
        int i =  id- 1;
        String [] arr = {"1"};
        System.out.println(arr[2]);
        return new BaseResult(200, "暂未实现用户查询功能",id);
    }
}
