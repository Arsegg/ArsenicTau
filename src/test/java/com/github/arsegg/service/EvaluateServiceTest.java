package com.github.arsegg.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class EvaluateServiceTest {
    @Autowired
    private EvaluateService evaluateService;

    @Test
    void when2Plus2Then4() {
        final var actual = evaluateService.evaluate("2 + 2");
        final var expected = 4;
        assertThat(actual, is(expected));
    }
}