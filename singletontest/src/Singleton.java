public class Singleton {
    private static final Singleton singleton;
    private int comp;


    static {
        singleton= new Singleton();
    }
    private Singleton(){
System.out.println("Instance");
    }
    public static Singleton getInstance(){
        return singleton;
    }



    public synchronized void traiter(String name){
        System.out.println("Traitement de la tache "+name);
         for (int i=1;i<=5;i++){
             ++comp;
             System.out.println(""+comp);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }

         }
        System.out.println("fin du traitement de la tache "+name+" compteur"+comp);
    }
}
