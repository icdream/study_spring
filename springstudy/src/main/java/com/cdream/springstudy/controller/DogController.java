package com.cdream.springstudy.controller;

import com.cdream.springstudy.domain.Dog;
import com.cdream.springstudy.domain.Result;
import com.cdream.springstudy.repository.DogRepository;
import com.cdream.springstudy.service.DogService;
import com.cdream.springstudy.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by cdream_zs
 * 2016-11-03 23:15
 */
@RestController
public class DogController {

    private final static Logger logger = LoggerFactory.getLogger(DogController.class);

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogService dogService;

    /**
     * 查询所有Dog列表
     *
     * @return
     */
    @GetMapping(value = "/dogs")
    public List<Dog> dogList() {
        logger.info("DogList");

        return dogRepository.findAll();
    }

    /**
     * 添加一个dog
     *
     * @return
     */
    @PostMapping(value = "/dogs")
    public Result<Dog> dogAdd(@Valid Dog dog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }


        return ResultUtil.success(dogRepository.save(dog));
    }

    //查询一个Dog
    @GetMapping(value = "/dogs/{id}")
    public Dog dogFindOne(@PathVariable("id") Integer id) {

        Dog one = dogRepository.findById(id).orElse(null);
        return one;
    }

    //更新
    @PutMapping(value = "/dogs/{id}")
    public Dog DogUpdate(@PathVariable("id") Integer id,
                         @RequestParam("dogName") String dogName,
                         @RequestParam("age") Integer age) {
        Dog dog = new Dog();
        dog.setId(id);
        dog.setDogName(dogName);
        dog.setAge(age);
        dog.setPrice(12.3);
        return dogRepository.save(dog);
    }

    //删除
    @DeleteMapping(value = "/dogs/{id}")
    public void dogDelete(@PathVariable("id") Integer id) {
        dogRepository.deleteById(id);
    }

    //通过年龄查询Dog列表
    @GetMapping(value = "/dogs/age/{age}")
    public List<Dog> dogListByAge(@PathVariable("age") Integer age) {
        return dogRepository.findByAge(age);
    }

    @PostMapping(value = "/dogs/two")
    public void dogTwo() {
        dogService.insertTwo();
    }

    @GetMapping(value = "dogs/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        dogService.getAge(id);
    }
}
