import java.util.*;

class MultiThread extends Thread {
    private static int THREADCOUNT = 50;

    //runs when thread is started
    public void run() {
        try {
            //allocate a pid
            int myPid = PidManager.allocatePID();
            //checks if pid is null
            if (myPid == -1) {
                System.out.print("Failed at requesting PID");
            }
            //randomly generates a time for thread to sleep
            Random rand = new Random();
            Thread.sleep(rand.nextInt(5000));
            PidManager.releasePID(myPid); // releases pid
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        PidManager.allocateMap(); //allocates array for pid
        System.out.println("Creating 50 asynchronous threads");
        //calls method
        //@param sends the threadcount
        createThread(THREADCOUNT);
    }

    public static void createThread(int count) {
        try {
            // creates multiple threads in the for loops
            for (int i = 0; i < count; i++) {
                Thread t1 = new Thread(new MultiThread());
                t1.start();
                //for terminal output
                Random rand = new Random();
                Thread.sleep(rand.nextInt(500));
                
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

}
/** OUTPUT OF THE PROGRAM
 * Memory allocated successfully.
Creating 50 asynchronous threads
Allocate PID :310
Allocate PID :304
Allocate PID :306
Allocate PID :315
Allocate PID :314
Allocate PID :302
Allocate PID :311
Allocate PID :300
Allocate PID :317
Allocate PID :313
Allocate PID :308
Allocate PID :318
Allocate PID :319
Allocate PID :301
Allocate PID :307
Allocate PID :316
Allocate PID :312
Allocate PID :309
Allocate PID :305
Allocate PID :303
Allocate PID :320
Allocate PID :321
Allocate PID :322
Allocate PID :323
Allocate PID :324
Allocate PID :325
Allocate PID :326
Allocate PID :327
Allocate PID :328
Releasing PID :315
Allocate PID :315
Allocate PID :329
Allocate PID :330
Allocate PID :331
Allocate PID :332
Allocate PID :333
Releasing PID :331
Allocate PID :331
Releasing PID :309
Allocate PID :309
Releasing PID :333
Releasing PID :328
Allocate PID :328
Allocate PID :333
Releasing PID :323
Releasing PID :312
Allocate PID :312
Releasing PID :313
Allocate PID :313
Releasing PID :326
Allocate PID :323
Allocate PID :326
Releasing PID :319
Releasing PID :301
Releasing PID :314
Allocate PID :301
Allocate PID :314
Releasing PID :321
Releasing PID :332
Allocate PID :319
Allocate PID :321
Allocate PID :332
Allocate PID :334
Releasing PID :329
Allocate PID :329
Releasing PID :333
Releasing PID :314
Releasing PID :324
Releasing PID :303
Releasing PID :311
Releasing PID :304
Releasing PID :308
Releasing PID :310
Releasing PID :319
Releasing PID :309
Releasing PID :300
Releasing PID :326
Releasing PID :328
Releasing PID :320
Releasing PID :322
Releasing PID :332
Releasing PID :318
Releasing PID :306
Releasing PID :313
Releasing PID :307
Releasing PID :317
Releasing PID :315
Releasing PID :327
Releasing PID :325
Releasing PID :316
Releasing PID :305
Releasing PID :330
Releasing PID :334
Releasing PID :302
Releasing PID :331
Releasing PID :301
Releasing PID :312
Releasing PID :321
Releasing PID :323
Releasing PID :329
 */