package com.github.arsegg.web;

import com.github.arsegg.service.EvaluateService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluateControllerImpl implements EvaluateController {
    private final EvaluateService evaluateService;

    private EvaluateControllerImpl(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    @Override
    public Number evaluate(String expression) {
        return evaluateService.evaluate(expression);
    }
}
