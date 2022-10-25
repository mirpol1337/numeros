import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        int count=21;
        List<Integer> fibonacci = new ArrayList<>();
        for (int integer : Fibonacci.FibonacciGeneration(count - 2, fibonacci)) {
            System.out.print(integer+" ");
        }
        System.out.println();
        System.out.println("Mean of the sequence is " +df.format(Fibonacci.FibonacciMean(count,fibonacci)));
        System.out.println("Median of the sequence is "+Fibonacci.FibonacciMedian(fibonacci) );

    }
}
class Fibonacci {
    private static int number1 = 0;
    private static int number2 = 1;

    static List<Integer> FibonacciGeneration(int count,List<Integer> sequence) {

        if (count > 0) {
            int number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
            if(sequence.size()==0){
                sequence.add(0);
                sequence.add(1);
            }
            sequence.add(number3);
            FibonacciGeneration(count-1,sequence);
        }
        return sequence;
    }
    static double FibonacciMean(int count,List<Integer> sequence){
        double sum = 0;
        for (Integer integer : sequence) {
            sum += integer;
        }
        return sum/count;
    }
    static int FibonacciMedian(List<Integer> sequence){
        int middleIndex = sequence.size()/2;
        if (sequence.size()%2==0){
            return (sequence.get(middleIndex)+sequence.get(middleIndex-1))/2;
        } else {
            return sequence.get(middleIndex);
        }
    }
}