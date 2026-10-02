%{
#include "y.tab.h"
%}
%%
[0-9]+ { return NUM; }
"+" { return '+'; }
"-" { return '-'; }
"*" { return '*'; }
"/" { return '/'; }
"(" { return '('; }
")" { return ')'; }
\n { return '\n'; }
[ \t] ;
%%
int yywrap() {
    return 1;
}
