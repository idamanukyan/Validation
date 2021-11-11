package com.company.validation;

import com.company.annotation.Max;
import com.company.annotation.Min;
import com.company.dto.CustomerDTO;

import java.lang.reflect.Field;

public class MaxMinValidation {

    public static void checkMinAndMax(CustomerDTO customerDTO) throws IllegalAccessException {

        Field[] fields = customerDTO.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Min.class) && field.isAnnotationPresent(Max.class)) {
                int count = (int) field.get(customerDTO);

                if (count > field.getAnnotation(Max.class).value()) {
                    System.out.println("You have exceeded the maximum value.");
                }

                if (count < field.getAnnotation(Min.class).value()) {
                    System.out.println("You have inputted not enough count.");
                }
            }
        }

    }
}
