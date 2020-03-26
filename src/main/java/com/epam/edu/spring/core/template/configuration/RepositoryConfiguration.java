package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class RepositoryConfiguration {

    @Value("${item.repository.implementation}")
    String itemRepositoryImplementation;

    @Bean
    public ItemRepository itemRepository(){
        if(itemRepositoryImplementation.equals("") || itemRepositoryImplementation.equals("array"))
            return new ArrayListItemRepository();
        else if (itemRepositoryImplementation.equals("linked"))
            return new LinkedListItemRepository();
        else return null;
    }

}
