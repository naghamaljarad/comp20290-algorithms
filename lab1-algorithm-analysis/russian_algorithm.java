// PRACTICAL 1 //
public class russian_algorithm {

 static void RussianMultiply(long a, long b){
  long accumulator = 0;
  while (a!= 0){
   if(a%2 == 1)
    accumulator += b;

   a = (int) a/2;
   b = b*2;
  }
  System.out.println("Answer: " + accumulator);
 }

 public static void main(String[] args) {
  final long startTime = System.currentTimeMillis();
  RussianMultiply(8, 4);
  final long finishedTime =  System.currentTimeMillis();
  final long elapsedTime = finishedTime - startTime;
  System.out.println("Time taken " + elapsedTime);
 }
}
