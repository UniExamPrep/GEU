#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to compress the input string using RLE
void compress(const char *input, const char *output) {
    FILE *inFile = fopen(input, "r");
    FILE *outFile = fopen(output, "w");

    if (!inFile || !outFile) {
        printf("Error: Unable to open files.\n");
        exit(1);
    }

    char ch, prev;
    int count = 0;

    prev = fgetc(inFile);
    count = 1;

    while ((ch = fgetc(inFile)) != EOF) {
        if (ch == prev) {
            count++;
        } else {
            fprintf(outFile, "%c%d", prev, count);
            prev = ch;
            count = 1;
        }
    }

    if (count > 0) {
        fprintf(outFile, "%c%d", prev, count);
    }

    fclose(inFile);
    fclose(outFile);
}

// Function to decompress the RLE compressed file
void decompress(const char *input, const char *output) {
    FILE *inFile = fopen(input, "r");
    FILE *outFile = fopen(output, "w");

    if (!inFile || !outFile) {
        printf("Error: Unable to open files.\n");
        exit(1);
    }

    char ch;
    int count;

    while (fscanf(inFile, "%c%d", &ch, &count) != EOF) {
        for (int i = 0; i < count; i++) {
            fputc(ch, outFile);
        }
    }

    fclose(inFile);
    fclose(outFile);
}

int main() {
    char inputFile[100], compressedFile[100], decompressedFile[100];

    printf("Enter the name of the input file: ");
    scanf("%s", inputFile);

    printf("Enter the name of the compressed file: ");
    scanf("%s", compressedFile);

    printf("Enter the name of the decompressed file: ");
    scanf("%s", decompressedFile);

    // Compress the input file
    compress(inputFile, compressedFile);
    printf("File compressed successfully to %s\n", compressedFile);

    // Decompress the file
    decompress(compressedFile, decompressedFile);
    printf("File decompressed successfully to %s\n", decompressedFile);

    return 0;
}