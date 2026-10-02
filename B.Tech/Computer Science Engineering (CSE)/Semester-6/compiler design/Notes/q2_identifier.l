%{
#include <stdio.h>
%}

%%
[a-zA-Z_][a-zA-Z0-9_]*   { printf("Valid Identifier: %s\n", yytext); }
[0-9][a-zA-Z0-9_]*       { printf("Invalid Identifier: %s\n", yytext); }
\n                        { }
.                         { }
%%

int yywrap() {
    return 1;
}

int main() {
    printf("Enter input (Ctrl+D to end):\n");
    yylex();
    return 0;
}
