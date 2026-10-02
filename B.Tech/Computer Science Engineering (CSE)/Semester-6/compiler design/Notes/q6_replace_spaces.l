%{
#include <stdio.h>
FILE *out;
%}

%%
[ \t]+    { fprintf(out, " "); }
\n        { fprintf(out, "\n"); }
.         { fprintf(out, "%s", yytext); }
%%

int yywrap() {
    return 1;
}

int main() {
    FILE *fp = fopen("Input.txt", "r");
    if(fp == NULL) {
        printf("Cannot open Input.txt\n");
        return 1;
    }
    out = fopen("Output.txt", "w");
    if(out == NULL) {
        printf("Cannot create Output.txt\n");
        fclose(fp);
        return 1;
    }
    yyin = fp;
    yylex();
    fclose(fp);
    fclose(out);
    printf("Done! Check Output.txt\n");
    return 0;
}
