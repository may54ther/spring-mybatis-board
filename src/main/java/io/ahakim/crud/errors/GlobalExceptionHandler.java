package io.ahakim.crud.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({PostNotFoundException.class})
    public String handlePostNotFoundException(PostNotFoundException e, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute("msg", e.getMessage());
        return "redirect:/posts";
    }
}
