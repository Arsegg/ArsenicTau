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

    @Test
    void when2Minus2Then0() {
        final var actual = evaluateService.evaluate("2 - 2");
        final var expected = 0;
        assertThat(actual, is(expected));
    }

    @Test
    void when2Times2Then4() {
        final var actual = evaluateService.evaluate("2 * 2");
        final var expected = 4;
        assertThat(actual, is(expected));
    }

    @Test
    void when2Divide2Then1() {
        final var actual = evaluateService.evaluate("2 / 2");
        final var expected = 1;
        assertThat(actual, is(expected));
    }

    @Test
    void when2Power2Then4() {
        final var actual = evaluateService.evaluate("2 ^ 2");
        final var expected = 4;
        assertThat(actual, is(expected));
    }

    @Test
    void whenSqrt2Then1() {
        final var actual = evaluateService.evaluate("sqrt 2");
        final var expected = 1;
        assertThat(actual, is(expected));
    }

    @Test
    void when2Plus2Times2Then8() {
        final var actual = evaluateService.evaluate("(2 + 2) * 2");
        final var expected = 8;
        assertThat(actual, is(expected));
    }

    @Test
    void whenMinus2ThenMinus2() {
        final var actual = evaluateService.evaluate("-2");
        final var expected = -2;
        assertThat(actual, is(expected));
    }

    @Test
    void whenPlus2Then2() {
        final var actual = evaluateService.evaluate("+2");
        final var expected = 2;
        assertThat(actual, is(expected));
    }

    @Test
    void when2Power2Power3Then256() {
        final var actual = evaluateService.evaluate("2 ^ 2 ^ 3");
        final var expected = 256;
        assertThat(actual, is(expected));
    }
}