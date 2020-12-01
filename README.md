# ArsenicTau
Simple REST Arithmetic Engine.
# Motivation
I wanted to make my own Wolfram|Alpha.
# Used technologies
- ANTLR
- Spring Boot
- Spring Boot Test
- Hamcrest
# Features
- An arithmetic processor:
    - Integer computation;
    - Addition;
    - Subtraction;
    - Multiplication;
    - Division;
    - Power;
    - Root;
    - Parenthesis.
# Usage
```
curl -G --data-urlencode "expression=2 + 2" localhost:8080/evaluate
4
curl -G --data-urlencode "expression=125 + 375" localhost:8080/evaluate
500
curl -G --data-urlencode "expression=1200 - 450" localhost:8080/evaluate
750
curl -G --data-urlencode "expression=10 - 9 + 8 - 7 + 6 - 5 + 4 - 3 + 2 - 1" localhost:8080/evaluate
5
curl -G --data-urlencode "expression=125 * 216 * 343" localhost:8080/evaluate
9261000
curl -G --data-urlencode "expression=1000 / 65" localhost:8080/evaluate
15
curl -G --data-urlencode "expression=7 ^ 3" localhost:8080/evaluate
343
curl -G --data-urlencode "expression=sqrt 1801" localhost:8080/evaluate
42
curl -G --data-urlencode "expression=(2 * 3 + 3 * 4 + 4 * 5) / (10 - 5)" localhost:8080/evaluate
7
curl -G --data-urlencode "expression=sqrt (3 ^ 2 + 4 ^ 2)" localhost:8080/evaluate
5
```
# Installation
```./mvnw spring-boot:run```