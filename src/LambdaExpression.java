import java.util.function.BiFunction;
import java.util.function.Consumer;

class LambdaExpression {

    interface IntegerMath {
         int operation(int a, int b);
    }

    public void operateBinary(int a, int b, IntegerMath m) {
         System.out.println(m.operation(a, b));
    }

    public static void main(String[] args) {

        LambdaExpression l = new LambdaExpression();

        IntegerMath addition = Integer::sum;
        IntegerMath subtraction = (a, b) -> a - b;

        l.operateBinary(4, 5, addition);
        l.operateBinary(4, 5, subtraction);

    }

}

class LambdaScopeTest {

    private static void demo(){
        System.out.println("demo");
    }

    public int x = 0;

    class Firstlevel {


        public int x = 1;

        void methodInFirstlevel(int x) {
            int z = 2;

            Consumer<Integer> myConsumer = (y) -> {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " + LambdaScopeTest.this.x);
            };
            myConsumer.accept(x);

        }


        public interface Runnable {
            void run();

        }

        public interface Callable<V> {
            V call();

        }

        void invoke(Runnable r) {
            r.run();
        }

        <T> T invoke(Callable<T> c) {
            return c.call();
        }

    }

    public static void main(String[] args) {
       LambdaScopeTest l = new LambdaScopeTest();
       LambdaScopeTest.Firstlevel f1 = l.new Firstlevel();
       f1.methodInFirstlevel(23);

       String s = f1.invoke(()->"ketan");

       System.out.println(s);

        Firstlevel.Runnable demo = LambdaScopeTest::demo;

        System.out.println(demo);
    }
}

/*
However, like local and anonymous classes,
a lambda expression can only access local variables
and parameters of the enclosing block that are final
or effectively final.
 */

class MethodReferencesExample {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> mergeFunction) {
        return mergeFunction.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + " " + b;
    }

    public String appendStrings2(String a, String b) {
        return a + " " + b;
    }

    public  static void main(String[] args) {

        MethodReferencesExample example = new MethodReferencesExample();

        System.out.println(
             MethodReferencesExample.mergeThings("Ketan","Khunti",(a,b) -> a+b )
        );
        System.out.println();
        System.out.println(
                MethodReferencesExample.mergeThings(
                        "Ketan","Khunti",MethodReferencesExample::appendStrings
                )
        );
        System.out.println(
                MethodReferencesExample.mergeThings(
                        "Ketan","Khunti",example::appendStrings2
                )
        );

        System.out.println(
                MethodReferencesExample.mergeThings(
                        "Ketan","Khunti",String::concat
                )
        );

    }

}