package com.example.repository;

import com.example.bean.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by J on 2017/3/1.
 */
public interface DemoInfoRepository extends CrudRepository<DemoInfo,Long> {
}
