package com.shubham.controllers;

import com.shubham.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        return genericExceptionMethod(exception, "404error");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadRequest(Exception exc) {
        return genericExceptionMethod(exc, "400error");
    }

    private ModelAndView genericExceptionMethod(Exception exc, String viewName) {

        log.error("Handling not found exception");
        log.error(exc.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        modelAndView.addObject("exception", exc);

        return modelAndView;
    }
}
