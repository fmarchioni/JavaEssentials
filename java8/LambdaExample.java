package java8;

interface SumFunction {
    int sum(int a, int b);
}
        
public class LambdaExample {
        
    public static void main(String[] args) {
        SumFunction sumFunction = (a, b) -> a + b;

        int result = sumFunction.sum(5, 3);
        System.out.println("Sum using lambda: " + result);
    }
            
}