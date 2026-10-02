%{
#include<stdio.h>
FILE *fp;
%}
%%
\<[^>]*\> {fprintf(fp,"%s\n",yytext);}
.|\n ;
%%
int yywrap() {
    return 1;
}
int main() {
    fp=fopen("tags.txt","w");
    if(fp==NULL) {
        printf("File error\n");
        return 1;
    }
    printf("Enter HTML code (Ctrl+D to end):\n");
    yylex();
    fclose(fp);
    printf("HTML tags extracted into tags.txt\n");
    return 0;
}
