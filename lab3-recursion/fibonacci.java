// PRACTICAL 3 //
public class fibonacci {

    public static long RecursiveFibonacci(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return RecursiveFibonacci(n - 1) + RecursiveFibonacci(n - 2);
    }


    static long IterativeFibonacci(long n){
        if (n<=1)
            return 1 ;

        long fib = 1;
        long prevFib =  1;

        for (int i = 2; i < n; i++) {
            long temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main (String args[])
    {
        long n = 35;
        for(long i = 12; i<=44; i = i+4) {
            System.out.println("Term "+i);
            final long startTime = System.currentTimeMillis();
            RecursiveFibonacci(i);
            final long finishedTime = System.currentTimeMillis();
            final long elapsedTime = finishedTime - startTime;
            System.out.println("Time Taken, Recursive: " + elapsedTime);

            final long startTime2 = System.currentTimeMillis();
            IterativeFibonacci(i);
            final long finishedTime2 = System.currentTimeMillis();
            final long elapsedTime2 = finishedTime2 - startTime2;
            System.out.println("Time Taken, Iterative: " + elapsedTime2 + "\n");
        }
    }



}

