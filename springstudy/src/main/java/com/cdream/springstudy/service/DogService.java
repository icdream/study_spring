package com.cdream.springstudy.service;

import com.cdream.springstudy.domain.Dog;
import com.cdream.springstudy.enums.ResultEnum;
import com.cdream.springstudy.exception.DogException;
import com.cdream.springstudy.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cdream_zs
 * 2016-11-04 00:08
 */
@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    @Transactional
    public void insertTwo() {
        Dog dog1 = new Dog();
        dog1.setAge(2);
        dog1.setDogName("小黑");
        dog1.setPrice(12.0);
        dogRepository.save(dog1);
    }

    public void getAge(Integer id) throws Exception{
        Dog dog = dogRepository.getOne(id);
        Integer age = dog.getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new DogException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new DogException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    /**
     * 通过Id查询一个Dog的信息
     * @param id
     * @return
     */
    public Dog findOne(Integer id) {
        return dogRepository.getOne(id);
    }
}
