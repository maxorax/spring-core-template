package com.epam.edu.spring.core.template.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Абстрактный класс для хранения сущностей.
 * ID сущности генерируется, исходя из initialSequence
 * @param <T>
 */
@Component
public abstract class AbstractRepository<T> {

    protected long initialSequence = 0;

    protected List<T> holder;

    abstract void setInitialSequence(int val);

    abstract void setHolder();

}
