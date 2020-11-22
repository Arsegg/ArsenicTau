package com.github.arsegg.engine;

import com.github.arsegg.ExpressionBaseVisitor;
import com.github.arsegg.ExpressionLexer;
import com.github.arsegg.ExpressionParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

@Component
public final class EvaluatorImpl implements Evaluator {
    @Override
    public Number evaluate(String expression) {
        final var input = CharStreams.fromString(expression);
        final var expressionLexer = new ExpressionLexer(input);
        final var commonTokenStream = new CommonTokenStream(expressionLexer);
        final var expressionParser = new ExpressionParser(commonTokenStream);
        final var evaluateVisitor = new EvaluateVisitor();
        final var program = expressionParser.program();
        final var tree = program.expression();
        return evaluateVisitor.visit(tree);
    }

    private static final class EvaluateVisitor extends ExpressionBaseVisitor<Integer> {
        @Override
        public Integer visitToInt(ExpressionParser.ToIntContext ctx) {
            return Integer.parseInt(ctx.number.getText());
        }

        @Override
        public Integer visitAdditionAndSubtraction(ExpressionParser.AdditionAndSubtractionContext ctx) {
            return get(ctx.operator.getText()).apply(visit(ctx.left), visit(ctx.right));
        }

        private static BinaryOperator<Integer> get(String operator) {
            return switch (operator) {
                case "+" -> (left, right) -> left + left;
                case "-" -> (left, right) -> left - right;
                default -> throw new UnsupportedOperationException(operator + " is not supported");
            };
        }
    }
}
