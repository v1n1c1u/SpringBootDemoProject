package com.v1n1c1u.demo.web.validator;


import com.v1n1c1u.demo.domain.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        LocalDate start = employee.getStartDate();
        LocalDate finish = employee.getFinishDate();

        if(finish != null){
            if(finish.isBefore(start)){
                errors.rejectValue("finishDate", "PosteriorStartDate.employee.finishDate");
            }
        }
    }
}
