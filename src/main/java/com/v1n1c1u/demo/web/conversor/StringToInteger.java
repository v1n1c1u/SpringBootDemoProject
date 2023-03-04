package com.v1n1c1u.demo.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class StringToInteger implements Converter<String,Integer> {

    @Override
    public Integer convert(String text) {
        text = text.trim();
        if(text.matches("[0-9]+")){
            return Integer.valueOf(text);
        }
        return null;
    }
}
