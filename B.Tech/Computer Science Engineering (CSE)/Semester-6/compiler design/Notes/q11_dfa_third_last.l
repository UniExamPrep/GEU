%{
#include<stdio.h>
%}
%%
(a|b)*a(a|b)(a|b) {printf("String Accepted\n");}
(a|b)+ {printf("String Rejected\n");}
%%
int yywrap() {
    return 1;
}
int main() {
    printf("Enter String: ");
    yylex();
    return 0;
}
