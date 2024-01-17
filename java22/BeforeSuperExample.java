package java22;

class MyBaseClass {
    MyBaseClass(int i) {
        System.out.println("Created MyBaseClass with "+i);
    }
    MyBaseClass() {
    }
}
public class BeforeSuperExample extends MyBaseClass {
    public BeforeSuperExample(long value) {

        if (value <= 0)
            throw new IllegalArgumentException("Wrong attribute!");
       // super(value);
    }
}
