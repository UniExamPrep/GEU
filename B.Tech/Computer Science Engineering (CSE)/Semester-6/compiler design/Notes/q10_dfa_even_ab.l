%{
#include<stdio.h>
int a=0,b=0;
%}
%%
a {a++;}
b {b++;}
\n {
if(a%2==0 && b%2==0)
printf("String Accepted\n");
else
printf("String Rejected\n");
a=0;
b=0;
}
%%
int yywrap() {
    return 1;
}
int main() {
    printf("Enter String: ");
    yylex();
    return 0;
}
