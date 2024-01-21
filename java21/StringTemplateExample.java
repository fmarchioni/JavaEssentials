package java21;

import static java.lang.StringTemplate.STR;

public class StringTemplateExample {
    public record Person(int customerId, String firstName, String lastName, String email, String phone) { }

    public static void main(String args[]) {
        // Basic usage
        String name = "John";
        String info = STR."My name is \{name}";
        System.out.println(info);

        // Calling expressions
        Person myperson = new Person(12345678, "John", "Smith", "john.smith@example.com", "+1234567890");
        String jsonString = STR."""
    {
        "customerId": "\{myperson.customerId()}",
        "firstName": "\{myperson.firstName()}",
        "lastName": "\{myperson.lastName()}",
        "email": "\{myperson.email()}",
        "phone": "\{myperson.phone()}"
    }
    """;
        System.out.println(jsonString);


    }

}



