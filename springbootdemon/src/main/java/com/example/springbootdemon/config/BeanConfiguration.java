package com.example.springbootdemon.config;

import com.example.springbootdemon.entity.Pet;
import com.example.springbootdemon.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HP
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public User getUser(){
        return new User("xxb", 24);
    }

    @Bean("Pet")
    public Pet pet(){
        return new Pet();
    }
}
