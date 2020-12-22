package com.lzq.dispose_exception.controller;

import com.lzq.dispose_exception.vo.BaseResult;
import com.lzq.dispose_exception.vo.RangeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author lzq
 * @version 1.0
 * @date 2020/12/18 9:58
 */
@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "user")
    public BaseResult findUser(@RequestParam(value = "id",required = false) Integer id) {
        int i =  id- 1;
        String [] arr = {"1"};
        System.out.println(arr[2]);
        return new BaseResult(200, "暂未实现用户查询功能",id);
    }

    /**
     * 使用redis-zset实现排行榜
     */
    @GetMapping(value = "redisZset")
    public void getRedisZset(){
        RangeVo rangeVo = new RangeVo();
        for (int i = 1; i <= 10 ; i++) {
            String ss = "shop"+i;
            rangeVo.setProductId(i);
            rangeVo.setProductName(ss);
            rangeVo.setScore(0.0);
            redisTemplate.opsForZSet().add("shop",i,0);
        }
    }
    @GetMapping("/getList")
    public void getList(){
        String key = "shop";
        List<RangeVo> list = new ArrayList<>();
        /** 从小到大排序 返回value 和 score* 参数注释 key 为有序集合的key，1，50 是分数范围 1-50，0 是偏移量即从哪条数据开始排序， 5是取5条满足条件的数据*/
        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().rangeByScoreWithScores(key,1,50,0,5);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = set.iterator();
        while (iterator.hasNext()){
            ZSetOperations.TypedTuple<Object> next = iterator.next();
            RangeVo rangeVo = new RangeVo() ;
            rangeVo.setProductId((Integer) next.getValue());
            rangeVo.setScore(next.getScore());
            list.add(rangeVo);
        }

        System.out.println(list);
    }
    @GetMapping("/setOneValue")
    public void setOneValue(Integer id){
        String keyModel = "shop";
        //score值加1
        Double aDouble = redisTemplate.opsForZSet().incrementScore(keyModel, id, 1);
        System.out.println(aDouble);
    }
}
