package com.example.service;

import com.example.bean.DemoInfo;
import com.example.repository.DemoInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by J on 2017/3/1.
 */
@Service
@CacheConfig(cacheNames = "demo")
public class DemoServiceImpl implements DemoInfoService {
    @Autowired
    private DemoInfoRepository demoInfoRepository;
    @Resource
    private RedisTemplate<String,String> redisTemplate;




    @Cacheable(keyGenerator ="MykeyGenerator")
    @Override
    public DemoInfo findById(long id) {
        DemoInfo demoInfo = demoInfoRepository.findOne(id);
//        redisUtils.set(this.getClass().getName()+id,demoInfo);
        System.out.println("cached: "+id);
        return demoInfo;
    }

    @CacheEvict(keyGenerator = "MykeyGenerator")
    @Override
    public void deleteFromCache(long id) {
//        redisUtils.remove(this.getClass().getName()+id);
        System.out.println("deleted:"+id);
    }

    @Override
    public void test() {

        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));

    }
}
