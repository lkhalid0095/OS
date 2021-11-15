import java.util.*;

class MultiThread extends Thread {
    private static int THREADCOUNT = 50;

    public void run() {
        try {
            
            int myPid = PidManager.allocatePID();
            if (myPid == -1) {
                System.out.print("Failed at requesting PID");
            }
            Random rand = new Random();
            Thread.sleep(rand.nextInt((100 - 49) + 50) + 1);
            PidManager.releasePID(myPid);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        PidManager.allocateMap();
        System.out.println("Creating 50 asynchronous threads");

        createThread(THREADCOUNT);
    }

    public static void createThread(int count) {
        try {

            for (int i = 0; i < count; i++) {
                Thread t1 = new Thread(new MultiThread());
                t1.start();
               
                
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

}
