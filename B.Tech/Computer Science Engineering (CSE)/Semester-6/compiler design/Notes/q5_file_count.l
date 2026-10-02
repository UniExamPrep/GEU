%{
int chars=0, words=0, spaces=0;
%}

%%
[a-zA-Z0-9]+   { words++; chars += yyleng; }
" "            { spaces++; chars++; }
\t             { spaces++; chars++; }
\n             { chars++; }
.              { chars++; }
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
    yyin = fp;
    yylex();
    fclose(fp);
    printf("Characters: %d\n", chars);
    printf("Words: %d\n", words);
    printf("White Spaces: %d\n", spaces);
    return 0;
}
