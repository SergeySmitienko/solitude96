
public class BBBuffer {
    public static void main(String[] args) {
        SingleBuffer buffer = new SingleBuffer();
    Runnable prod = new Producer(buffer,1000,0);
    Runnable cost = new Costumer(buffer);
        new Thread(prod).start();
        new Thread(cost).start();

    }
}
