%{
#include<stdio.h>
%}
%%
[0-9]+ {printf("%s is Integer Constant\n",yytext);}
[0-9]+"."[0-9]+ {printf("%s is Float Constant\n",yytext);}
[a-zA-Z_][a-zA-Z0-9_]* {printf("%s is Identifier\n",yytext);}
[ \t\n]+ ;
. ;
%%
int yywrap() {
    return 1;
}
int main() {
    printf("Enter Input: ");
    yylex();
    return 0;
}
