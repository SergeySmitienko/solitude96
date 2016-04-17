
public class Costumer implements Runnable{
    //private Integer elem;
    private final SingleBuffer buffer;

    public Costumer(SingleBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    while(true){
        try {
            Integer elem = buffer.get();
            System.out.println(elem + "consumed");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    }
}
