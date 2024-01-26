package java17;

import java.util.HexFormat;

public class HexFormatExample {

    public static void main(String[] args) {
        // Create a HexFormat instance
        HexFormat hexFormat = HexFormat.of();

        // From String to byte[]
        System.out.println(hexFormat.parseHex("abcd"));

        byte[] data = new byte[]{4, 5, 61, 127, -5};
        // From byte[] to hexadecimal string
        System.out.println(hexFormat.formatHex(data));

        System.out.println(hexFormat.toHexDigits((byte) 0xF));
        System.out.println(hexFormat.toHexDigits(0xFFFF));
        // Use Uppercase in Hex Format
        var hexUpperCase = HexFormat.of().withUpperCase();
        // Use Lowercase in Hex Format
        var hexLowerCase = HexFormat.of().withLowerCase();
        // Extra options
        var hexOptions = HexFormat.of().withPrefix("[").withSuffix("]").withDelimiter(", ");

        System.out.println(hexOptions.formatHex(new byte[] {12, 35, 56, 119}));



    }
}
