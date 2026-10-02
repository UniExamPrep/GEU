%{
int lines=0, spaces=0, tabs=0, others=0;
%}

%%
\n      { lines++; }
" "    { spaces++; }
\t     { tabs++; }
.      { others++; }
%%

int yywrap() {
    return 1;
}

int main() {
    printf("Enter input (Ctrl+D to end):\n");
    yylex();
    printf("Lines: %d\n", lines);
    printf("Spaces: %d\n", spaces);
    printf("Tabs: %d\n", tabs);
    printf("Other characters: %d\n", others);
    return 0;
}
