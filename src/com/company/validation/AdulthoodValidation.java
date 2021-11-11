package com.company.validation;

import com.company.annotation.Adulthood;
import com.company.dto.CustomerDTO;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class AdulthoodValidation {

    public static void checkAge(CustomerDTO customerDTO) throws IllegalAccessException {
        Field[] fields = customerDTO.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Adulthood.class)) {
                LocalDate localDate = (LocalDate) field.get(customerDTO);
                if (LocalDate.now().getYear() - localDate.getYear() < 18) {
                    System.out.println("You are under 18.");
                }
            }
        }


    }
}
