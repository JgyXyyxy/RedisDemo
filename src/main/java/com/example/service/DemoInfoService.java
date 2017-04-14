package com.example.service;

import com.example.bean.DemoInfo;

/**
 * Created by J on 2017/3/1.
 */
public interface DemoInfoService {
    public DemoInfo findById(long id);
    public void deleteFromCache(long id);
    void test();
}
