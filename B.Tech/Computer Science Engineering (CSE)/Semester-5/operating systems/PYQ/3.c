#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> // Required for wait() system call
int main() {// Creating a new process using fork()
pid_t pid = fork();
// Check if fork() failed
if (pid < 0) {
printf("Fork failed!\n");
return 1;
}
// Child process
else if (pid == 0) {
printf("Child Process (PID: %d) is running...\n", getpid());
sleep(2); // Simulating child process work by sleeping for 2 seconds
printf("Child Process (PID: %d) has finished execution.\n", getpid());
}
// Parent process
else {
printf("Parent Process (PID: %d) is waiting for the child process to finish...\n", getpid());
int a=wait(NULL); // Parent process waits for the child process to finish
printf("Child  process after wait returing process id %d\n",a);
printf("Parent Process (PID: %d) resumes after the child process has finished.\n", getpid());
}
return 0;
}