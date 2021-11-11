package com.company.validation;

import com.company.annotation.Length;
import com.company.dto.CustomerDTO;

import java.lang.reflect.Field;

public class LengthValidation {

    public static void checkLength(CustomerDTO customerDTO) throws IllegalAccessException {

        Field[] fields = customerDTO.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Length.class)) {
                Length annotation = field.getAnnotation(Length.class);
                String name = (String) field.get(customerDTO);
                if (name.length() < annotation.min() || name.length() > annotation.max()) {
                    System.out.println("Either you have less word than needed" +
                            "or you have exceeded the word count.");
                }
            }
        }

    }
}
