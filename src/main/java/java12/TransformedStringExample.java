package java12;
import java.util.List;
import java.util.function.Function;
import java.util.Arrays;

public class TransformedStringExample {

    public static void main(String[] args)   {

        String str = "Apple,Pear,Banana";
 
        // using Function implementation
        List<String> list1 = str.transform(new Function<String, List<String>>() {
            @Override
            public List<String> apply(String t) {
                return Arrays.asList(t.split(","));
            }
        });
        System.out.println(list1);
        // using lambda expressions
        list1 = str.transform(s1 -> Arrays.asList(s1.split(",")));
        System.out.println(list1);

    }
}
