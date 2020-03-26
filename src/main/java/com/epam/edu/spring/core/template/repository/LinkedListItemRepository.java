package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Component
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    List<Item> linkedListItem = new LinkedList<>();

    @Override
    public Item getById(long id) {

        for (Item element: linkedListItem) {
            if(element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        setInitialSequence(new Random().nextInt(100));
        item.setId(initialSequence);
        if( getById(item.getId()) == null) {
            linkedListItem.add(item);
            setHolder();
            return true;
        }
        return false;
    }

    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = linkedListItem;
    }
}
