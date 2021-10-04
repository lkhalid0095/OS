#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <iostream>
#include <ctime>
#include <string.h>

int main(){

  using namespace std;

    int i=fork();

    if(i == 0){

          time_t now = time(0);
          char*  date = ctime(&now);
          char* day = strtok(date," ");

        printf ("Current Day of the Week is: %sday\nChild PID: %d\n",day, getpid());
    }
     
    else if (i> 0){
      printf("Parent PID: %d\n",getpid());
    }
}