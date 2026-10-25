package chapter_12;

public class _07_StatePrintThread extends Thread{
    private Thread targetThread;

    public _07_StatePrintThread(Thread targetThread){
        this.targetThread = targetThread;
    }

    public void run(){
        while (true){
            State state = targetThread.getState();
            System.out.println("Target thread state : " + state);

            if (state == State.NEW){
                targetThread.start();
            }

            if (state == State.TERMINATED){
                break;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e){}
        }
    }
}
