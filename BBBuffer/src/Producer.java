
public class Producer implements Runnable {
    private int startPoint;
    private int period;
    private final SingleBuffer buffer;

    public Producer(SingleBuffer buffer, int period, int startPoint) {
        this.buffer = buffer;
        this.period = period;
        this.startPoint = startPoint;
    }

    @Override
    public void run() {
        while (true){
            try{
            System.out.println(startPoint + "produced");
            buffer.put(startPoint++);

                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
