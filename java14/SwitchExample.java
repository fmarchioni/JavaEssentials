package java14;

public class SwitchExample {

    public static void main(String[] args) {
        switchWithString();
        switchWithYield();
        switchWithVar();
    }

    private static void switchWithString() {
        int day = 3;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println("Day type: " + dayType);
    }

    private static void switchWithYield() {

        String fruit = "Apple";
        int rating = switch (fruit) {
            case "Apple" -> {
                yield 5;
            }
            case "Banana" -> {
                yield 4;
            }
            case "Orange" -> {
                yield 3;
            }
            default -> {
                yield 0;
            }
        };
        System.out.println("Rating for " + fruit + " is " + rating);
    }

    private static void switchWithVar() {
        int day = 3;
        var dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> new IllegalArgumentException("Not right");
        };

        System.out.println("Day type: " + dayType);
    }
}
