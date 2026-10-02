%{
#include<stdio.h>
FILE *fp;
%}
%%
"//".* ;
"/*"([^*]|\n|(\*+([^*/]|\n)))*"*"+"/" ;
.|\n { fprintf(fp,"%s",yytext); }
%%
int yywrap() {
    return 1;
}
int main() {
    fp=fopen("out.c","w");
    if(fp==NULL) {
        printf("File cannot be opened\n");
        return 1;
    }
    printf("Enter C code (Ctrl+D to end):\n");
    yylex();
    fclose(fp);
    printf("Comments removed and stored in out.c\n");
    return 0;
}
