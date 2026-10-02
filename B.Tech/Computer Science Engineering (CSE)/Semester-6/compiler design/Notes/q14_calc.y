%{
#include<stdio.h>
#include<stdlib.h>
int yylex(void);
int yyerror(const char *s);
%}
%token NUM
%left '+' '-'
%left '*' '/'
%%
S: E '\n' {printf("Result = %d\n",$1);}
;
E: E'+'E {$$=$1+$3;}
 | E'-'E {$$=$1-$3;}
 | E'*'E {$$=$1*$3;}
 | E'/'E {$$=$1/$3;}
 | NUM {$$=$1;}
;
%%
int yyerror(const char *s) {
    return 1;
}
int main() {
    printf("Enter Expression: ");
    yyparse();
    return 0;
}
