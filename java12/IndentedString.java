package java12;

public class IndentedString {

    public static void main(String[] args)   {

        //All the lines are suffixed with ‘\n’, concatenated and returned.

       // 2 spaces are added at the beginning of each line.
        System.out.println("One\nTwo\rThree\n\rFour".indent(2));
        // 2 spaces are removed at the beginning of each line. 
        System.out.println("   Hi\nHello\r\t\t\tThere".indent(-2));
        // lines remain unchanged.
        System.out.println("Apple\n Pear\r \tOrange".indent(0));
    }
}
