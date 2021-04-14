package com.example.springbootdemon;

import com.example.springbootdemon.entity.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootdemonApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootdemonApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }

        Pet pet1 = run.getBean(Pet.class);
        Pet pet2 = run.getBean(Pet.class);
        System.out.println(pet1 == pet2);

    }

}
