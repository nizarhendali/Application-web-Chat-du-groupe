public class Main {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            Threadsing t=new Threadsing("T"+i);
            t.start();
        }


    }
}