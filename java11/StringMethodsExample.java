package java11;

public class StringMethodsExample {
    public static void main(String[] args) {
        // Example string with leading and trailing whitespaces
        String inputString = "   Java is amazing!   ";

        // String.strip(), stripLeading(), stripTrailing()
        String strippedString = inputString.strip();
        String leadingStrippedString = inputString.stripLeading();
        String trailingStrippedString = inputString.stripTrailing();

        // String.isBlank()
        boolean isBlank = inputString.isBlank();

        // String.repeat()
        String repeatedString = "Repeat me. ".repeat(3);

        // String.lines()
        String multiLineString = "Line 1\nLine 2\nLine 3";
        multiLineString.lines().forEach(System.out::println);

        // Print results
        System.out.println("Original String: '" + inputString + "'");
        System.out.println("Stripped String: '" + strippedString + "'");
        System.out.println("Leading Stripped String: '" + leadingStrippedString + "'");
        System.out.println("Trailing Stripped String: '" + trailingStrippedString + "'");
        System.out.println("Is Blank? " + isBlank);
        System.out.println("Repeated String: '" + repeatedString + "'");
    }
}
