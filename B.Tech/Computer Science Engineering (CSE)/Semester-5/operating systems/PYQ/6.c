#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("fork");
        return 1;
    }

    if (pid == 0) {
        // Child process: exits immediately
        printf("Child: PID = %d\n", getpid());
        exit(0);
    } else {
        // Parent process: does NOT call wait()
        printf("Parent: PID = %d, sleeping to keep zombie child...\n", getpid());
        sleep(30);  // Sleep so you can observe the zombie
        printf("Parent exiting.\n");
    }

    return 0;
}