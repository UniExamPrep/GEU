%{
#include<stdio.h>
%}
%%
(aa|bb|(ab|ba)(aa|bb)*(ab|ba))* {printf("String Accepted\n");}
[a|b]+ {printf("String Rejected\n");}
%%
int yywrap() {
    return 1;
}
int main() {
    printf("Enter String: ");
    yylex();
    return 0;
}
