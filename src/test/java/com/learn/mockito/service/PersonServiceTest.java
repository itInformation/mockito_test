package com.learn.mockito.service;

import com.learn.mockito.dao.PersonDao;
import com.learn.mockito.dto.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * description:
 *
 * @author minghuiZhang
 * @date created in 4:14 下午 2021/8/11
 * modified by
 */
public class PersonServiceTest {
    @Mock
    private PersonDao personDao;
    private PersonService personService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        personService = new PersonService(personDao);
    }


    @Test
    public void shouldUpdatePersonName() {
        Person person = new Person(1, "Phillip");
        //设置模拟对象的返回预期值
        when(personDao.fetchPerson(1)).thenReturn(person);
        //执行测试
        boolean update = personService.update(1, "David");
        //验证更新是否成功
        assertTrue(update);
        //验证模拟对象的fetchPerson(1)方法是否被调用了一次
        verify(personDao).fetchPerson(1);
        //得到一个抓取器


        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);

        //验证模拟对象的update是否被调用的一次，并抓取调用时传入的参数
        verify(personDao).update(personCaptor.capture());


        //获取抓取到的参数值

        Person updatePerson = personCaptor.getValue();
        //验证调用时的参数值
        assertEquals("David", updatePerson.getName());
        //检查模拟对象是否还有未验证的交互
        verifyNoMoreInteractions(personDao);
        validateMockitoUsage();
    }
}