package com.learn.mockito.dao;

import com.learn.mockito.dto.Person;

/**
 * description:
 *
 * @author minghuiZhang
 * @date created in 4:10 下午 2021/8/11
 * modified by
 */
public interface PersonDao {
    Person fetchPerson(Integer id);

    int update(Person updatedPerson);

}
