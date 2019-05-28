package com.cdream.springstudy.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by cdream_zs
 * 2016-11-01 23:35
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "dog")
public class DogProperties {

    private String dogName;

    private Integer age;

}
