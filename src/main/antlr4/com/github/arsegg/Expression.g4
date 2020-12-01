grammar Expression;

program: expression EOF;
expression: <assoc=right> left=expression operator=POWER right=expression # BinaryOperator
    | left=expression operator=(TIMES | SLASH) right=expression # BinaryOperator
    | left=expression operator=(PLUS | MINUS) right=expression # BinaryOperator
    | LEFT_PAREN expression RIGHT_PAREN # Parenthesis
    | operator=SQRT right=expression # UnaryOperator
    | prefix=(PLUS | MINUS)* number=INT # ToInt
    ;

LEFT_PAREN: '(';
RIGHT_PAREN: ')';
PLUS: '+';
MINUS: '-';
TIMES: '*';
SLASH: '/';
POWER: '^';
SQRT: 'sqrt';

INT: DIGIT+;
WHITESPACE: [ \t\r\n] -> skip;

fragment DIGIT: '0'..'9';
