package hw3;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class Mediator {

   public Semaphore printer, plotter, scanner;
  
  
   private void initSemaphores() {
       printer = new Semaphore(5);
       plotter = new Semaphore(6);
       scanner = new Semaphore(4);
   }

   public static void main(String[] args) throws Exception {
       Mediator rm = new Mediator();
       //initialize values
       rm.initSemaphores();
       //Loops through a sequence of 100 times
       for(int i=1; i<=100; i++) {
           //child process creaeted
           new Resource(rm).start();  
           //Sleep for 2 to 5 seconds
           Thread.sleep(ThreadLocalRandom.current().nextInt(2, 5 + 1)*1000);
       }
      
   }

}

class Resource extends Thread{
  
   Mediator rm;
  
   public Resource(Mediator rm) {
       this.rm = rm;
   }
  
   @Override
   public void run() {
       //number generated randomly to request resource
       int r = ThreadLocalRandom.current().nextInt(1, 3 + 1);
       
       //Echos the requested semaphore
       Semaphore s=null;
       //use switch for each case
       switch (r) {
         //Printer case
           case 1: {
               System.out.println("Requested: Printer");
               s = rm.printer;
               break;
           }
           //plotter request
           case 2: {
               System.out.println("Requested: Plotter");
               s = rm.plotter;
               break;
           }
           //scanner is requested
           case 3: {
               System.out.println("Requested: Scanner");
               s = rm.scanner;
               break;
           }
       }
       //value of the corresponding semaphore
       System.out.println("Value of the semaphore = "+s.availablePermits());
       boolean done = false;
       while(!done) {  
           if(s.tryAcquire()) {
             //Resource is there
               System.out.println("Request is successful");
               try {
                   //Sleep for 1 to 5 seconds randomly
                   Thread.sleep(ThreadLocalRandom.current().nextInt(1, 5 + 1)*1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               s.release();
               done=true;  
           }else {
             //if the resource isn't availabe
               System.out.println("Request failed");
               try {
                   //Sleep for random time between 2 to 5 seconds
                   Thread.sleep(ThreadLocalRandom.current().nextInt(2, 5 + 1)*1000);
               } catch (InterruptedException e) {
                   System.out.println(e);
               }
           }
       }
   }
  
}



