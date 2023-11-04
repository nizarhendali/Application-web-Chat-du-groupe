public class Threadsing extends Thread{
    private String name;
    public Threadsing(String s){
        this.name=s;
    }
    public void run(){
        Singleton sing=Singleton.getInstance();
        sing.traiter(this.name);
        System.out.println(sing.hashCode());
    }
}
