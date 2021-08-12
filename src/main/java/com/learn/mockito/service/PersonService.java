package com.learn.mockito.service;

import com.learn.mockito.dao.PersonDao;
import com.learn.mockito.dto.Person;

/**
 * description:
 *
 * @author minghuiZhang
 * @date created in 4:12 下午 2021/8/11
 * modified by
 */
public class PersonService {
    private final PersonDao personDao;
    public PersonService( PersonDao personDao )
    {
        this.personDao = personDao;
    }
    public boolean update( Integer personId, String name )
    {
        Person person = personDao.fetchPerson(personId);
        if( person != null )
        {
            Person updatedPerson = new Person( person.getId(), name);
            personDao.update( updatedPerson );
            return true;
        }
        else
        {
            return false;
        }
    }

}
