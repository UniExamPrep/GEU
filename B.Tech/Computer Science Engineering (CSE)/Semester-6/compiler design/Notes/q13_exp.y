%{
#include<stdio.h>
#include<stdlib.h>
int yylex(void);
void yyerror(const char *s);
%}
%token NUM
%%
S: E '\n' {printf("Valid Expression\n");}
;
E: E '+' T
 | E '-' T
 | T
;
T: T '*' F
 | T '/' F
 | F
;
F: '(' E ')'
 | NUM
;
%%
void yyerror(const char *s) {
    printf("Invalid Expression\n");
}
int main() {
    printf("Enter Expression: ");
    yyparse();
    return 0;
}
