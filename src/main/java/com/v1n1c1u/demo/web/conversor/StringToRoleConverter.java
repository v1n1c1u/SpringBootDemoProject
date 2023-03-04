package com.v1n1c1u.demo.web.conversor;

import com.v1n1c1u.demo.domain.Role;
import com.v1n1c1u.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleService service;

    public RoleService getService() {
        return service;
    }
    public void setService(RoleService service) {
        this.service = service;
    }

    @Override
    @Nullable
    public Role convert(String text) {
        if(text == null || text.isEmpty()){
            return null;
        }
        return service.findByID(Long.valueOf(text));
    }

}
