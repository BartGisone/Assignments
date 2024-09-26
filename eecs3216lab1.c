#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_WORD_LENGTH 100
#define MAX_LINE_LENGTH 1024

typedef enum {
    INITIAL,
    FILE_READING,
    WORD_PROCESSING,
    END
} State;

// Function to extract nth word from a string
void extractNthWord(char* line, int n, char* output) {
    int count = 0;
    char* token = strtok(line, " ");

    while (token != NULL) {
        if (++count == n) {
            strcpy(output, token);
            return;
        }
        token = strtok(NULL, " ");
    }

    strcpy(output, ""); // Empty string if nth word doesn't exist
}

int main() {
    State currentState = INITIAL;
    char line[MAX_LINE_LENGTH];
    char word[MAX_WORD_LENGTH];
    int n;

    // Initial State: Get user input
    printf("Please enter an integer number: ");
    scanf("%d", &n);

    FILE *file = fopen("text.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    currentState = FILE_READING;

    // File Reading and Word Processing States
    while (fgets(line, sizeof(line), file) != NULL && currentState == FILE_READING) {
        currentState = WORD_PROCESSING;

        extractNthWord(line, n, word);
        if (strlen(word) > 0) {
            printf("%s\n", word);
        }

        currentState = FILE_READING;
    }

    // End State
    fclose(file);
    currentState = END;

    return EXIT_SUCCESS;
}
