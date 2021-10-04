#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <ctime>
#include <string.h>
#include <stdlib.h> 

// Author: Lubna Khalid 
//HW-1 PART ONE
int main(){

       //gets the current day, date and time from the system
          time_t now = time(0);
          char*  date = ctime(&now);
          //returns the string that came before the first space
    int i=fork();
    
    //condition if it's a child process
    if(i == 0){

         
          // to get the substring of the day from string
          char* day = strtok(date," ");

          //prints the current day and the PID 
        printf ("Current Day of the Week is: %sday\nChild PID: %d\n",day, getpid());
    }
     
    else if (i> 0){
      //Parent process
      //prints the shared date & parent pid
        printf("Date: %s \nParent PID: %d\n", date, getpid());
    }
    //terminate program
    exit(1);
}