#!/bin/bash

DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$DIR"

# Use homebrew bison if available (macOS system yacc may require Xcode)
export PATH="/opt/homebrew/opt/bison/bin:$PATH"

echo "========================================="
echo "  Compiler Design Lab - LEX/YACC Tests"
echo "========================================="

# ---- Q1: Count lines, spaces, tabs, other chars ----
echo ""
echo "----- Q1: Count Lines, Spaces, Tabs, Others -----"
lex q1_count.l
gcc lex.yy.c -o q1 -ll 2>/dev/null || gcc lex.yy.c -o q1
echo -e "Hello World\n\tTab here\nThird line" | ./q1

# ---- Q2: Valid C/C++ Identifiers ----
echo ""
echo "----- Q2: Valid C/C++ Identifiers -----"
lex q2_identifier.l
gcc lex.yy.c -o q2 -ll 2>/dev/null || gcc lex.yy.c -o q2
echo -e "myVar\n_count\n2ndValue\nname1\n_temp\n123abc\nint\nhello_world" | ./q2

# ---- Q3: Integer and Float ----
echo ""
echo "----- Q3: Integer and Float Values -----"
lex q3_int_float.l
gcc lex.yy.c -o q3 -ll 2>/dev/null || gcc lex.yy.c -o q3
echo -e "42\n3.14\n100\n0.5\n7\n99.99\nabc\n12.0" | ./q3

# ---- Q4: Tokenizing C Code ----
echo ""
echo "----- Q4: Tokenizing C Code Fragment -----"
lex q4_tokenize.l
gcc lex.yy.c -o q4 -ll 2>/dev/null || gcc lex.yy.c -o q4
echo '#include
int main() {
    int x = 10;
    float y = 3.14;
    if(x > 5) {
        printf("hello");
    }
    return 0;
}' | ./q4

# ---- Q5: Count chars, words, spaces in Input.txt ----
echo ""
echo "----- Q5: Count Characters, Words, Spaces in Input.txt -----"
echo "Input.txt content:"
cat Input.txt
echo ""
lex q5_file_count.l
gcc lex.yy.c -o q5 -ll 2>/dev/null || gcc lex.yy.c -o q5
./q5

# ---- Q6: Replace whitespaces in Input.txt -> Output.txt ----
echo ""
echo "----- Q6: Replace Whitespaces -> Output.txt -----"
lex q6_replace_spaces.l
gcc lex.yy.c -o q6 -ll 2>/dev/null || gcc lex.yy.c -o q6
./q6
echo "Output.txt content:"
cat Output.txt

# ---- Q7: Remove comments from C program ----
echo ""
echo "----- Q7: Remove Comments from C Program -> out.c -----"
lex q7_remove_comments.l
gcc lex.yy.c -o q7 -ll 2>/dev/null || gcc lex.yy.c -o q7
cat input.c | ./q7
echo "out.c content:"
cat out.c

# ---- Q8: Extract HTML tags ----
echo ""
echo "----- Q8: Extract HTML Tags -> tags.txt -----"
lex q8_extract_html_tags.l
gcc lex.yy.c -o q8 -ll 2>/dev/null || gcc lex.yy.c -o q8
cat input.html | ./q8
echo "tags.txt content:"
cat tags.txt

# ---- Q9: DFA string pattern matching ----
echo ""
echo "----- Q9: DFA String Pattern Match -----"
lex q9_dfa_string_match.l
gcc lex.yy.c -o q9 -ll 2>/dev/null || gcc lex.yy.c -o q9
echo -e "aabb\nabab\naab\nbb" | ./q9

# ---- Q10: DFA even number of a and b ----
echo ""
echo "----- Q10: DFA Even Number of a and b -----"
lex q10_dfa_even_ab.l
gcc lex.yy.c -o q10 -ll 2>/dev/null || gcc lex.yy.c -o q10
echo -e "aabb\naab\nab\nbbaa\naabbab" | ./q10

# ---- Q11: DFA third last element 'a' ----
echo ""
echo "----- Q11: DFA Third Last Element 'a' -----"
lex q11_dfa_third_last.l
gcc lex.yy.c -o q11 -ll 2>/dev/null || gcc lex.yy.c -o q11
echo -e "abb\nbba\naab\nbbb\naaa" | ./q11

# ---- Q12: Identify Integer, Float Constants and Identifier ----
echo ""
echo "----- Q12: Integer/Float Constants & Identifiers -----"
lex q12_token_identify.l
gcc lex.yy.c -o q12 -ll 2>/dev/null || gcc lex.yy.c -o q12
echo -e "42 3.14 hello _var 100 99.9" | ./q12

# ---- Q13: YACC/LEX Valid Arithmetic Expression ----
echo ""
echo "----- Q13: YACC Recognize Valid Arithmetic Expression -----"
lex q13_exp.l
bison -d -o y.tab.c q13_exp.y
gcc lex.yy.c y.tab.c -o q13 2>/dev/null
echo "3+5*2" | ./q13
echo "3++5" | ./q13 2>/dev/null

# ---- Q14: YACC/LEX Evaluate Arithmetic Expression ----
echo ""
echo "----- Q14a: YACC Evaluate Expression (With Precedence) -----"
lex q14_calc.l
bison -d -o y.tab.c q14_calc.y
gcc lex.yy.c y.tab.c -o q14a 2>/dev/null
echo "3+5*2" | ./q14a
echo "10-2*3" | ./q14a

echo ""
echo "----- Q14b: YACC Evaluate Expression (Without Precedence) -----"
lex q14_calc.l
bison -d -o y.tab.c q14_calc_no_prec.y
gcc lex.yy.c y.tab.c -o q14b 2>/dev/null
echo "3+5*2" | ./q14b
echo "10-2*3" | ./q14b

echo ""
echo "========================================="
echo "  All tests completed!"
echo "========================================="

rm -f lex.yy.c y.tab.c y.tab.h q1 q2 q3 q4 q5 q6 q7 q8 q9 q10 q11 q12 q13 q14a q14b out.c tags.txt
