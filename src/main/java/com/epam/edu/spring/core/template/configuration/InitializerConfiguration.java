package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;


@Configuration
public class InitializerConfiguration{

    @Component
    @Lazy
    @Scope("prototype")
    public class ColorFactory  {
        public Color getColor(){
            Color[] colors = Color.values();
            return colors[new Random().nextInt(colors.length)];
        }
    }

}
