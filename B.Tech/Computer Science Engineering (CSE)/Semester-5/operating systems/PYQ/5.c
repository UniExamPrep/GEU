#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("fork failed");
        exit(1);
    }
    else if (pid == 0) {
        // Child process
        printf("Child: PID = %d, parent PID = %d\n", getpid(), getppid());
        sleep(3);  // Child sleeps to stay alive after parent exits
        printf("Child after sleep: PID = %d, parent PID = %d\n", getpid(), getppid());
        
    }
    else {
        // Parent process
        printf("Parent: PID = %d, exiting immediately\n", getpid());
        exit(0);  // Parent exits immediately, orphaning child
    }

    return 0;
}
