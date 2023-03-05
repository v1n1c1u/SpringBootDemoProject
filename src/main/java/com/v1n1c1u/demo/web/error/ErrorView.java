package com.v1n1c1u.demo.web.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Component
public class ErrorView implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("/error");

        modelAndView.addObject("status", status.value());
        switch (status.value()){
            case 404:
                modelAndView.addObject("error", "Page Not Found");
                modelAndView.addObject("message", "URL for page '"+model.get("path")+"' doesn't exist");
                break;
            case 500:
                modelAndView.addObject("error", "An internal server error ocurred");
                modelAndView.addObject("message", "Try again later");
                break;
            default:
                modelAndView.addObject("error", model.get("error"));
                modelAndView.addObject("message", model.get("message"));
                break;
        }
        return modelAndView;
    }
}
