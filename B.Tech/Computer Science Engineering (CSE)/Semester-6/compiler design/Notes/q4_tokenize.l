%{
#include <stdio.h>
%}

%%
"int"|"float"|"char"|"double"|"if"|"else"|"while"|"for"|"do"|"return"|"void"|"main"|"include"|"printf"|"scanf"   { printf("Keyword: %s\n", yytext); }

"+"|"-"|"*"|"/"|"%"|"="|"=="|"!="|"<"|">"|"<="|">="|"&&"|"||"|"!"   { printf("Operator: %s\n", yytext); }

";"|","|"("|")"|"{"|"}"|"["|"]"|"#"   { printf("Separator: %s\n", yytext); }

[a-zA-Z_][a-zA-Z0-9_]*   { printf("Identifier: %s\n", yytext); }

[0-9]+(\.[0-9]+)?         { printf("Number: %s\n", yytext); }

\"[^\"]*\"                { printf("String: %s\n", yytext); }

\n                        { }
[ \t]+                    { }
.                         { }

%%

int yywrap() {
    return 1;
}

int main() {
    printf("Enter C code (Ctrl+D to end):\n");
    yylex();
    return 0;
}
