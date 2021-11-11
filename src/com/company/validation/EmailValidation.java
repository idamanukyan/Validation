package com.company.validation;

import com.company.annotation.Email;
import com.company.dto.CustomerDTO;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class EmailValidation {

    private static final String REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9]" +
            "(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-tttt9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";


    public static void checkEmail(CustomerDTO customerDTO) throws IllegalAccessException {

        Field[] fields = customerDTO.getClass().getDeclaredFields();
        for (Field field :
                fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Email.class)) {
                String email = (String) field.get(customerDTO);
                Pattern pattern = Pattern.compile(REGEX);
                if (!pattern.matcher(email).matches()) {
                    System.out.println("Invalid input for email. Please follow the format " +
                            "alex@gmail.com");
                }
            }


        }
    }


}
