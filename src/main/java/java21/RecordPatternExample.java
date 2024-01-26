package java21;

public class RecordPatternExample {
    record Building(String type, int floors){}
    record User<T>(T t) { }
            
            
    static void printBoxContents(User<String> user) {
        if (user instanceof User<String>(String s)) {
            System.out.println("User is: " + s);
        }
    }
            
    static void inferTypes(Object obj) {
        if (obj instanceof Building(var type, var floors)) {
            System.out.println("Building is " + type + " with floors : " + floors);
        }
    }

            
    public static void main(String[] args) {
        Building building = new Building("House", 10);

        if (building instanceof Building(String type, int floors)) {

            System.out.println("Building is " + type + " with floors : " + floors);
        }
    }

            

}
