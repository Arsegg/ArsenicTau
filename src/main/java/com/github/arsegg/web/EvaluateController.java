package com.github.arsegg.web;

import com.github.arsegg.service.EvaluateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class EvaluateController {
    private final EvaluateService evaluateService;

    private EvaluateController(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    @GetMapping("/evaluate")
    public Number evaluate(@RequestParam("expression") String expression) {
        return evaluateService.evaluate(expression);
    }
}
