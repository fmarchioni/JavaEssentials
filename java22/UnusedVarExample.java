package java22;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnusedVarExample {
    public static void main(String args[]) {
        System.out.println(formatDate("2024-01-01"));
    }
    static String formatDate(String unformattedDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(unformattedDate);
            return sdf.format(date);
        } catch (Exception _) {
            // log error without using exception
            System.out.println("Error parsing date");
        }
        return null;
    }
}
