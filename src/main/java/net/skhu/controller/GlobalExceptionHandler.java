package net.skhu.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception exception) {
        log.error("전역 에러", exception);
        model.addAttribute("message", "작업 도중 에러가 발생했습니다.");
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String exceptionHandler(Model model, AccessDeniedException exception) {
        log.error("권한 에러", exception);
        model.addAttribute("message", "접근 권한이 없습니다.");
        return "error";
    }

}
