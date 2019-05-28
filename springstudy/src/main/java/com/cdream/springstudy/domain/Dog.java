package com.cdream.springstudy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by cdream_zs
 * 2016-11-03 23:07
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String dogName;

    @Min(value = 2, message = "小狗不能吃骨头")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double price;

}
