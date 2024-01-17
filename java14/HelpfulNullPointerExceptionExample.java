package java14;

public class HelpfulNullPointerExceptionExample {
    static String[] names = null;

    public static void main(String[] args) {

        try {
            String firstName = names[0].substring(0, 5).toUpperCase();
            System.out.println("First Name: " + firstName);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
