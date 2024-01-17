package java17;

import java.io.*;

public class DeserializationUtil   {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var filename = "file.ser";
        var clazz = new Banned1();


        var filter1 = ObjectInputFilter.allowFilter(cl -> cl.getPackageName().contentEquals("java17"), ObjectInputFilter.Status.REJECTED);
        ObjectInputFilter.Config.setSerialFilter(filter1);
        ObjectInputFilter.Config.setSerialFilterFactory((f1, f2) -> ObjectInputFilter.merge(f2,f1));

        serialize(clazz, filename);
        deserialize(filename);
    }

    public static void serialize(Object value, String filename) throws IOException {
        System.out.println("---serialize");
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(value);
        out.close();
        fileOut.close();
    }

    public static void deserialize(String filename) throws IOException, ClassNotFoundException {
        System.out.println("---deserialize");
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ObjectInputFilter intFilter = ObjectInputFilter.rejectFilter(cl -> cl.equals(Banned2.class), ObjectInputFilter.Status.UNDECIDED);
        in.setObjectInputFilter(intFilter);
        TwoValue tv = (TwoValue) in.readObject();
        System.out.println(tv);
}
}

class Banned1 {
    String a;
}
class Banned2 {
    String a;
}