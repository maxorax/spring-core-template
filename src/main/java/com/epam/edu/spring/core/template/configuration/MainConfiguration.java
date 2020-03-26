package com.epam.edu.spring.core.template.configuration;


import com.epam.edu.spring.core.template.service.ItemService;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import com.epam.edu.spring.core.template.validator.SimpleItemValidator;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.epam.edu.spring.core.template")
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {

    @Bean
    public ItemValidator itemValidator(){
        ItemValidator itemValidator = new SimpleItemValidator();
        return itemValidator;
    }

    @Bean
    public ItemService itemService(){
        ItemService itemService = new SimpleItemService();
        return itemService;
    }

}
