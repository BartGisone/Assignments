#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//sets max word and line lengths
#define MAX_WORD_LENGTH 100
#define MAX_LINE_LENGTH 1024

//defines two states, FILE_READING and WORD_PROCESSING
typedef enum {
    FILE_READING,
    WORD_PROCESSING
} State;

// Function to extract nth word from a string
void getNthWord(const char* line, int n, char* output) {
    const char* temp = line;
    int spaceCount = 0;
    int wordLength;



    // Iterate through the line until we reach the nth space (word separator)
    while (spaceCount < n - 1 && *temp) {
        if (*temp == ' ') {
            spaceCount++;
        }
        temp++;
    }
    // Check if we found less than n spaces, which means there are fewer than n words
    if (spaceCount < n - 1) {
        *output = '\0'; // Set output to empty string if nth word doesn't exist
    } else {
        // Read the nth word into the output
        sscanf(temp, "%s%n", output, &wordLength);
        // Add a null terminator in case the word length is shorter than MAX_WORD_LENGTH
        output[wordLength] = '\0';
    }
}

int main(){
    //define initial state, and maximum line and word values
    //get memmory for n
    State currentState = FILE_READING;
    char line[MAX_LINE_LENGTH];
    char word[MAX_WORD_LENGTH];
    int n;

    // Initial State: FILE_READING
        printf("Please enter an integer number: ");
        scanf("%d", &n);

        FILE *file = fopen("text.txt", "r");

      //if no file, close file
        if (file == NULL) {
            perror("Error opening file");
            fclose(file);
      }
        if(n<0){
            perror("Invalid value of n");
            fclose(file);
      }
    /*
    The following code demonstrates a finite state machine.
    while the .txt file is being parsed line by line, it changes from the
    FILE_READING state to the WORD_PROCESSING state to ensure that the computations
    can be done without being interuppted.

    First: the initial FILE_READING state gets a single line from txt file.
    The state changes to the WORD_PROCESSING state.
    After the nth word is found and displayed, the program switches back to FILE_READING state.
    This continues until while loop finishes and program ends
    */
    while (fgets(line, sizeof(line), file) != NULL && currentState == FILE_READING) {
        currentState = WORD_PROCESSING;

        getNthWord(line, n, word);
        if (strlen(word) > 0) {

            printf("%s\n", strtok(word, " \\EOF "));
        }

        currentState = FILE_READING;
    }
    // End program
    fclose(file);
}
