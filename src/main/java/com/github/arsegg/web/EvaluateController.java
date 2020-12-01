package com.github.arsegg.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/evaluate")
public interface EvaluateController {
    @GetMapping
    Number evaluate(@RequestParam("expression") String expression);
}
