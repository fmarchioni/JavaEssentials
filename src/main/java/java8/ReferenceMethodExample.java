package java8;
// Example: Reference to a static method
class MathOperations {
    public static int add(int a, int b) {
        return a + b;
    }
}
interface Operation {
    int perform(int a, int b);
}
class Printer {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
interface MessagePrinter {
    void print(String message);
}
class StringUtils {
    public static  boolean startsWithUpperCase(String s) {
        return Character.isUpperCase(s.charAt(0));
    }
}
interface StringChecker {
    boolean check(String s);
}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
interface PersonFactory {
    Person create(String name);
}

public class ReferenceMethodExample {
    public static void main(String[] args) {
        // Using lambda expression
        Operation addLambda = (a, b) -> MathOperations.add(a, b);
        System.out.println(addLambda.perform(2, 3));

        // Using method reference to static method
        Operation addReference = MathOperations::add;
        System.out.println(addReference.perform(5, 7));


        // Using lambda expression
        MessagePrinter lambdaPrinter = message -> new Printer().printMessage(message);
        lambdaPrinter.print("Hello, Lambda!");

        // Using method reference to instance method on an object
        MessagePrinter referencePrinter = new Printer()::printMessage;
        referencePrinter.print("Hello, Method Reference!");


        // Using lambda expression
        StringChecker lambdaChecker = s -> new StringUtils().startsWithUpperCase(s);
        System.out.println(lambdaChecker.check("Java"));

        // Using method reference to instance method on a type
        StringChecker referenceChecker = StringUtils::startsWithUpperCase;
        System.out.println(referenceChecker.check("python"));


        // Using lambda expression
        PersonFactory lambdaFactory = name -> new Person(name);
        Person person1 = lambdaFactory.create("John");

        // Using method reference to constructor
        PersonFactory referenceFactory = Person::new;
        Person person2 = referenceFactory.create("Jane");

        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
