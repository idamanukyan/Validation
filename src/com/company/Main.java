package com.company;

import com.company.dto.CustomerDTO;
import com.company.validation.AdulthoodValidation;
import com.company.validation.EmailValidation;
import com.company.validation.LengthValidation;
import com.company.validation.MaxMinValidation;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Poxos");
        customerDTO.setEmail("poxos@gmail.com");
        customerDTO.setBirthDay(LocalDate.of(2000, 11, 11));
        customerDTO.setDiscountRate(2);

        AdulthoodValidation.checkAge(customerDTO);
        EmailValidation.checkEmail(customerDTO);
        LengthValidation.checkLength(customerDTO);
        MaxMinValidation.checkMinAndMax(customerDTO);
    }
}
