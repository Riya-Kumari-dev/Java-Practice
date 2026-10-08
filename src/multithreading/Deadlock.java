package multithreading;

class Library implements Runnable{
    // These three objects act as locks.
    String res1 = new String(("Java"));
    String res2 = new String("DSA");
    String res3 = new String(("SpringBoot"));
    @Override
    public void run(){
        String name = Thread.currentThread().getName();

        // Riya acquires resources in this order: res1 -> res2 -> res3
        if (name.equals("Riya")) {
            try{
                Thread.sleep(3000); // Time taken to search for resources
                synchronized(res1){
                    System.out.println("Riya has acquired " + res1);
                    Thread.sleep(4000); // reading Java
                    synchronized(res2){
                        System.out.println("Riya has acquired " + res2);
                        Thread.sleep(4000); // reading DSA
                        synchronized(res3){
                            System.out.println("Riya has acquired " + res3);
                            Thread.sleep(5000); // reading SpringBoot


                        }
                    }
                }
            }
            catch(InterruptedException e){
                // Restore the interrupted status.
                Thread.currentThread().interrupt();
                System.out.println("Riya was interrupted.");
            }
        }
        else{
            //Rohit acquires resources in the opposite order: res3 -> res2 -> res1
            try{
                Thread.sleep(3000); // Time taken to search for resources
                synchronized(res3){
                    System.out.println("Rohit has acquired " + res3);
                    Thread.sleep(4000); // reading SpringBoot
                    synchronized(res2){
                        System.out.println("Rohit has acquired " + res2);
                        Thread.sleep(4000); // reading DSA
                        synchronized(res1){
                            System.out.println("Rohit has acquired " + res1);
                            Thread.sleep(5000); // reading Java


                        }
                    }
                }
            }
            catch(InterruptedException e){
                // Restore the interrupted status.
                Thread.currentThread().interrupt();
                System.out.println("Rohit was interrupted.");
            }
        }
    }
}
/* possible situation :
    Riya  → holds res1
    Rohit → holds res3

    Riya  → waiting for res2
    Rohit → waiting for res2*/

public class Deadlock {
    static void main(String[] args) {
        Library lib = new Library();

        // Both threads share the same Library object, so they also share the same resource objects.
        Thread thread1 = new Thread(lib);
        Thread thread2 = new Thread(lib);

        thread1.setName("Riya");
        thread2.setName("Rohit");

        thread1.start();
        thread2.start();
    }
}