class Application {
    
    static int i;
    int j;
    static {
        i=20;
        System.out.println("S1");
    }

    Application() {
        System.out.println("c1");
    }
}
public class Form{
    public static void main(String[] args) {
        Application a1=new Application();
        Application a2=new Application();
    }
}

    
    

