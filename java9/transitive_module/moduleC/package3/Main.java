package package3;


import package1.Func1;
import package2.Func2;

public class Main{

    public static void main(String args[]){
        Func1 f1 = new Func1();
        f1.greeting();
        Func2 f2 = new Func2();
        f2.greeting();
	System.err.println("Hello from ModuleC");
    }
}