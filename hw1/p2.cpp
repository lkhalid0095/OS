#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <ctime>
#include <string.h>
#include <stdlib.h> 
// Author: Lubna Khalid 
//HW-1 PART TWO

//creates an array that will contain pid for each child process
int childArr[4];

//this method will take an int parameter
//@param takes the # child process created so far
void printChild(int idx){
    printf("\nCurrent Child Processes \n");
    //prints the current child process 
   for(int i = 1; i<=idx; i++)
       printf("%d: %d\n", i,childArr[i-1]);
}
int main(){ 
    //loops through to create 4 child processes
    for(int i=1;i<=4;i++){ 
        //fork returns process id to parent
        //fork returns 0 to child process
        int pid = fork();
        //enter the parent process
        if(pid > 0){
            //stores the child processes current pid in array
            childArr[i-1] = pid;
            //prints the child processes (updates as more processes are created)
            printChild(i);
            continue;
        }
        //child process
        else if(pid == 0){
            //wait for 4 seconds
            sleep(4);
            //terminate program
            exit(1);
        }
  }
}