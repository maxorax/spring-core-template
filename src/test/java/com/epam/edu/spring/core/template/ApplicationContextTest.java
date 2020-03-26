package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest(classes = MainConfiguration.class)
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testSimpleItemService(){
        SimpleItemService simpleItemService = (SimpleItemService) ctx.getBean("simpleItemService");
        assertNotNull(simpleItemService);
    }

    @Test
    public void testRepositoryConfiguration(){
        ItemRepository itemRepository = ctx.getBean("itemRepository",ItemRepository.class);
        Item item = new Item();
        itemRepository.createItem(item);
        assertEquals(42,item.getId());
    }

    @Test
    public void testGetColor(){
        InitializerConfiguration.ColorFactory colorFactory = ctx.getBean(InitializerConfiguration.ColorFactory.class);
        assertNotNull(colorFactory.getColor());
    }

    @Test
    public void testColorFactoryScope(){
        InitializerConfiguration.ColorFactory colorFactory1 = ctx.getBean(InitializerConfiguration.ColorFactory.class);
        InitializerConfiguration.ColorFactory colorFactory2 = ctx.getBean(InitializerConfiguration.ColorFactory.class);
        assertNotEquals(colorFactory1.hashCode(),colorFactory2.hashCode());

    }

}
