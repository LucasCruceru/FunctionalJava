package ro.lucas.chapter7.factorial;

import static ro.lucas.chapter7.factorial.TailCalls.*;


public class Factorial {

    public static void main(String[] args) {

        System.out.println(factorial(5));

    }

    private static int factorial(final int number){
        return  factorialTailRec(1,number).invoke();
    }


    private static TailCall<Integer> factorialTailRec(final int factorial,
                                                      final int number){
        if(number == 1)
            return done(factorial);
        else
            return call(()-> factorialTailRec(factorial * number, number -1));
    }
}
