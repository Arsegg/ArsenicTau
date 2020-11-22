grammar Expression;

program: expression EOF;
expression: left=expression operator=(PLUS | MINUS) right=expression # AdditionAndSubtraction
    | number=INT # ToInt
    ;

PLUS: '+';
MINUS: '-';

INT: DIGIT+;
WHITESPACE: [ \t\r\n] -> skip;

fragment DIGIT: '0'..'9';
