import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        int count=21;
        ArrayList<Integer> fibonacci = new ArrayList<>();
        for (Integer integer : Fibonacci.FibonacciGeneration(count - 2, fibonacci)) {
            System.out.print(integer+" ");
        }
        System.out.println();
        System.out.println("Mean of the sequence is " +df.format(Fibonacci.FibonacciMean(count,fibonacci)));
        System.out.println("Median of the sequence is "+Fibonacci.FibonacciMedian(fibonacci) );

    }
}
class Fibonacci {
    public static int number1 = 0;
    public static int number2 = 1;
    public static int number3 = 0;
    static ArrayList<Integer> FibonacciGeneration(int count,ArrayList<Integer> sequence) {

        if (count > 0) {
            number3 = number1 + number2;
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
    static double FibonacciMean(int count,ArrayList<Integer> sequence){
        double sum = 0;
        for (int i = 0; i < sequence.size(); i++) {
            sum+= sequence.get(i);
        }
        return sum/count;
    }
    static int FibonacciMedian(ArrayList<Integer> sequence){
            if (sequence.size()%2==0){
                return (sequence.get(sequence.size()/2)+sequence.get((sequence.size()/2)-1))/2;
            } else {
            return sequence.get(sequence.size() / 2);
        }
    }
}