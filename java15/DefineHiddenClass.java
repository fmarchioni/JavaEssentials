package java15;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Base64;

public class DefineHiddenClass {
   /* Original Class
   public class Hello {

	public static String greet() {
	   return "hello";
	}

}
    */
    static final String CLASS_IN_BASE64 = "yv66vgAAAEEAEQoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAFaGVsbG8HAAoBAAVIZWxsbwEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVncmVldAEAFCgpTGphdmEvbGFuZy9TdHJpbmc7AQAKU291cmNlRmlsZQEACkhlbGxvLmphdmEAIQAJAAIAAAAAAAIAAQAFAAYAAQALAAAAHQABAAEAAAAFKrcAAbEAAAABAAwAAAAGAAEAAAABAAkADQAOAAEACwAAABsAAQAAAAAAAxIHsAAAAAEADAAAAAYAAQAAAAQAAQAPAAAAAgAQ";



    public static void main(String[] args) throws Throwable {



        testHiddenClass();


    }



    // create a hidden class and run its static method
    public static void testHiddenClass() throws Throwable {

        byte[] classInBytes = Base64.getDecoder().decode(CLASS_IN_BASE64);

        Class<?> proxy = MethodHandles.lookup()
                .defineHiddenClass(classInBytes,
                        true, MethodHandles.Lookup.ClassOption.NESTMATE)
                .lookupClass();


        System.out.println(proxy.getName());

        MethodHandle mh = MethodHandles.lookup().findStatic(proxy,
                "greet",
                MethodType.methodType(String.class));

        String status = (String) mh.invokeExact();
        System.out.println(status);

    }

}