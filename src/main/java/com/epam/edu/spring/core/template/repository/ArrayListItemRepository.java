package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Component
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

     List<Item> itemArrayList = new ArrayList();

    @Value("${initial.sequence}")
    String initialSequenceFromProperties;

    @Override
    public Item getById(long id) {
        for (Item element: itemArrayList) {
            if(element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        setInitialSequence(Integer.valueOf(initialSequenceFromProperties));
        item.setId(initialSequence);
        if( getById(item.getId()) == null){
            itemArrayList.add(item);
            setHolder();
            return true;
        } else { return false;}
    }

    void setInitialSequence(int val) {
        this.initialSequence=(long)val;
    }




    void setHolder() {
        this.holder = itemArrayList;
    }
}
