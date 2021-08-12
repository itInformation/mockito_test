package com.learn.mockito.dto;

import lombok.Data;

/**
 * description:
 *
 * @author minghuiZhang
 * @date created in 4:02 下午 2021/8/11
 * modified by
 */
@Data
public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
