package com.v1n1c1u.demo.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.service.DepartmentService;

@Component
public class StringToDepartmentConverter implements Converter<String, Department>{

    @Autowired
    private DepartmentService service;

    public DepartmentService getService() {
        return service;
    }
    public void setService(DepartmentService service) {
        this.service = service;
    }

    @Override
    @Nullable
    public Department convert(String text) {
        if(text == null || text.isEmpty()){
            return null;
        }
        return service.findByID(Long.valueOf(text));
    }
    
}
