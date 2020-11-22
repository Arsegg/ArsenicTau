package com.github.arsegg.service;

import com.github.arsegg.engine.Evaluator;
import org.springframework.stereotype.Service;

@Service
public final class EvaluateServiceImpl implements EvaluateService {
    private final Evaluator evaluator;

    private EvaluateServiceImpl(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public Number evaluate(String expression) {
        return evaluator.evaluate(expression);
    }
}
