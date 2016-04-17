public class SingleBuffer{
    Integer buffer=null;

//    public SingleBuffer(Integer buffer) {
//        this.buffer = buffer;
//    }

    public synchronized void put(int buff) throws InterruptedException {
        while(buffer != null){
            this.wait();
        }
        buffer=buff;
        this.notifyAll();
    }
    public synchronized int get() throws InterruptedException {
        while(buffer == null){
            this.wait();
        }
        Integer result = this.buffer;
        this.buffer = null;
        this.notifyAll();
        return result;
    }
}
