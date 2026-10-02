#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h> // For wait() function
// Function to calculate sum of even numbers
int sumOfEven(int n) {
int sum = 0;
for (int i = 2; i <= n; i += 2) {
sum += i;
}
return sum;
}
// Function to calculate sum of odd numbers
int sumOfOdd(int n) {
int sum = 0;
for (int i = 1; i <= n; i += 2) {
sum += i;
}
return sum;
}
int main() {
int n;

// Input for upper limit
printf("Enter the upper limit (n): ");
scanf("%d", &n);
pid_t pid = fork();
// Creating a new process using fork()
// Check if fork() failed
if (pid < 0) {
printf("Fork failed!\n");
return 1;
}
// Child process (computes sum of odd numbers)
else if (pid == 0) {
int oddSum = sumOfOdd(n);
printf("Child Process (PID: %d) - Sum of odd numbers: %d\n",getpid(), oddSum);
}
// Parent process (computes sum of even numbers)
else {
// Wait for the child process to 
wait(NULL);
int evenSum = sumOfEven(n);
printf("Parent Process (PID: %d) - Sum of even numbers: %d\n",getpid(), evenSum);
}
return 0;
}
