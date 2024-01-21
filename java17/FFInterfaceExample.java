package java17;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class FFInterfaceExample {


    static long invokeCFunction(String text) throws Throwable {
        // Acquire a linker – the central element for accessing foreign functions
        Linker linker = Linker.nativeLinker();

        // Obtain a lookup object for commonly used libraries
        SymbolLookup stdlib = linker.defaultLookup();

        // Retrieve the address of the "strlen" function in the C standard library
        MemorySegment strlenAddress = stdlib.find("strlen").orElseThrow();

        // Specify the input and output parameters of the "strlen" function
        FunctionDescriptor descriptor =
                FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);

        // Obtain a handle to the "strlen" function
        MethodHandle strlen = linker.downcallHandle(strlenAddress, descriptor);

        // Acquire a confined memory area (one that we can close explicitly)
        try (Arena offHeap = Arena.ofConfined()) {

            // Convert the Java String to a C string and store it in off-heap memory
            MemorySegment str = offHeap.allocateUtf8String(text);

            // Invoke the "strlen" function
            long len = (long) strlen.invoke(str);
            return len;
        }
    }

    public static void main(String[] args) throws Throwable {
        System.out.println(invokeCFunction("Hello World!"));
    }
}
