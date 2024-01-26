package java16;


import jdk.incubator.vector.FloatVector;

public class VectorAPIExample {
    public static void main(String[] args) {
        float[] a = new float[] {2f, 4f, 6f, 8f};
        float[] b = new float[] {1.5f, 2.5f, 3.5f, 4.5f};

        FloatVector vectorA = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
        FloatVector vectorB = FloatVector.fromArray(FloatVector.SPECIES_128, b, 0);

        // Element-wise multiplication
        FloatVector result = vectorA.mul(vectorB);

        // Calculate the square root of the result
        FloatVector sqrtResult = result.sqrt();

        // Print the original vectors and the final result
        System.out.println("Vector A: " + vectorA);
        System.out.println("Vector B: " + vectorB);
        System.out.println("Element-wise Multiplication Result: " + result);
        System.out.println("Square Root of Result: " + sqrtResult);
    }
}

