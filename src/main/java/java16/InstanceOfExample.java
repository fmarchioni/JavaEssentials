package java16;

public class InstanceOfExample {

    public static void main(String[] args) {
        Object obj = "Hello, Java!";

        if (obj instanceof String str) {
            System.out.println("Length of the string: " + str.length());
        } else {
            System.out.println("The object is not a string");
        }
    }
}
