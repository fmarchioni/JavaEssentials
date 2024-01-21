package java16;
record Person(String name, int age) {  }


        
public class RecordExample {

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        String name = person.name();
        int age = person.age();

        //person.name = "Bob"; // Compilation error

    }


}
