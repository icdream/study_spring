package com.cdream.springstudy.repository;

import com.cdream.springstudy.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cdream_zs
 * 2016-11-03 23:17
 */
public interface DogRepository extends JpaRepository<Dog, Integer> {

    /**
     * 通过狗龄来查询狗
     * @param age 年龄
     * @return 返回狗的列表
     */
    List<Dog> findByAge(Integer age);
}
