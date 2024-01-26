package java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface MyTypeAnnotation {
    String value() default "";
}
        
public class TypeAnnotationExample {
        
    public void process(@MyTypeAnnotation("Custom Annotation") String data) {
        System.out.println("Data: " + data);
    }
            
    public static void main(String[] args) {
        TypeAnnotationExample example = new TypeAnnotationExample();
        example.process("Sample Data");
    }
}

        