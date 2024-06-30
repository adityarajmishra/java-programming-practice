package evaluations.level1;

public class OverridingThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running!");
        super.run();
    }

    @Override
    public synchronized void start() {
        System.out.println("Starting!");
        super.start();
    }
}
