#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <ctime>
#include <string.h>
#include <stdlib.h> 
// Author: Lubna Khalid 
//HW-1 PART THREE
int main(){
    int pid = fork();
    //child process
    if(pid==0){
         printf("My PID: %d. I am the parent process.\n",getpid());
         //creates another child process inside this child process(GC)
         pid = fork();
         //prints insdie
         if(pid ==0){
              printf("My PID: %d. I am the grandchild process.\n",getpid());
         }
         exit(0);
    }
    //parent process
    else if(pid > 0){
        printf("My PID: %d. I am the grandparent process.\n",getpid());
        //terminates program
        exit(0);
    }
    exit(0);
}