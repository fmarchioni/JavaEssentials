package java17;

public class PatternMatchingExample {

    public static void main(String[] args) {
        // Example 1
        Object obj = "hello";

        String message = switch (obj) {
            case Integer i -> String.format("int %d", i);
            case String s -> String.format("string %s", s);
            case Long l -> String.format("long %d", l);
            case null -> "null =s";
            // required to be exhaustive
            default -> obj.toString();
        };

        System.out.println(message);

        // Example 2
        Object obj2 = 142;

        String message2 = switch (obj2) {
            case Integer i when i < 0 -> "negative number";
            case Integer i when i == 0 -> "zero";
            case Integer i when i > 0 && i <= 100 -> "positive number between 0 and 100";
            case Integer i -> "number over 100";
            // required to be exhaustive
            default -> obj2.toString();
        };

        System.out.println(message2);

        // Example 3
        try {
            System.out.println(getPerimeter(new Rectangle(5, 10))); // Change to the desired shape
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double getPerimeter(Shape shape) throws IllegalArgumentException {
        return switch (shape) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }
}

// Dummy Shape classes for demonstration
class Rectangle implements Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double length() {
        return length;
    }

    public double width() {
        return width;
    }
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double radius() {
        return radius;
    }
}

interface Shape {
}
