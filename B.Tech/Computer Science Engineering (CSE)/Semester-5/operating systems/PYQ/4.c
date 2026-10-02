#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int status;
    pid_t pid = fork();

    if (pid < 0) {
        perror("fork failed");
        return 1;
    }

    if (pid == 0) {
        // Child process
        printf("Child: PID = %d, Parent PID = %d\n", getpid(), getppid());
        exit(25);  // Exit with status 5
    } else {
        // Parent process
        printf("Parent: PID = %d, Child PID = %d\n", getpid(), pid);
        wait(&status);
        printf("I am after wait hi");
        

        if (WIFEXITED(status)) {
            int exit_code = WEXITSTATUS(status);
            printf("Child exited with code: %d\n", exit_code);
            return exit_code;  // This will be captured by `echo $?` in shell
        } else {
            printf("Child did not exit normally.\n");
            return 1;
        }
    }
}

