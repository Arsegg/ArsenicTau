package com.github.arsegg.engine;

import com.github.arsegg.ExpressionBaseVisitor;
import com.github.arsegg.ExpressionLexer;
import com.github.arsegg.ExpressionParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.BinaryOperator;

@Component
public final class EvaluatorImpl implements Evaluator {
    private static final Logger log = LoggerFactory.getLogger(EvaluatorImpl.class);

    @Override
    public Number evaluate(String expression) {
        log.info("Processing: " + expression);
        final var input = CharStreams.fromString(expression);
        final var expressionLexer = new ExpressionLexer(input);
        final var commonTokenStream = new CommonTokenStream(expressionLexer);
        final var expressionParser = new ExpressionParser(commonTokenStream);
        final var evaluateVisitor = new EvaluateVisitor();
        final var program = expressionParser.program();
        final var tree = program.expression();
        final var result = evaluateVisitor.visit(tree);
        log.info("Processed: " + result);
        return result;
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
                case "+" -> Integer::sum;
                case "-" -> (left, right) -> left - right;
                default -> throw new UnsupportedOperationException(operator + " is not supported");
            };
        }
    }
}
