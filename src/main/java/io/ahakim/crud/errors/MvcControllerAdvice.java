package io.ahakim.crud.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Slf4j
@ControllerAdvice("io.ahakim.crud.controller")
public class MvcControllerAdvice {

    @ExceptionHandler({PostNotFoundException.class})
    public String handlePostNotFoundException(PostNotFoundException e, RedirectAttributes redirect) {
        redirect.addFlashAttribute("msg", e.getMessage());
        return "redirect:/posts";
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public void handleException(Exception e) {
        log.info("MvcControllerAdvice.handleException");
        log.info("e={} ", Arrays.toString(e.getStackTrace()));
    }
}
