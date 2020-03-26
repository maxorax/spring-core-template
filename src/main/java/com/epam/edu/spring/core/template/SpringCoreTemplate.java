package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.InitializerConfiguration;
import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreTemplate {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);

		ItemRepository itemRepository = ctx.getBean("itemRepository",ItemRepository.class);

		InitializerConfiguration.ColorFactory colorFactory = ctx.getBean(InitializerConfiguration.ColorFactory.class);

		System.out.println(colorFactory.getColor());


		Item item = new Item();
		itemRepository.createItem(item);
		System.out.println(item.getId());


	}

}
