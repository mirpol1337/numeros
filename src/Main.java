import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int count=21;
        Fibonacci leonardo = new Fibonacci(count);
        System.out.println(Arrays.toString(leonardo.getFibonacciSequence()));
        System.out.println(leonardo.getMean());
        System.out.println(leonardo.getMedian());
    }
}
class Fibonacci {
    public Fibonacci(int size) {
        this.size = size;
        this.fibonacciSequence = this.calculateSequence(size);
        this.mean = this.calculateMean();
        this.median = this.calculateMedian();
    }

    int size;
    int[] fibonacciSequence;
    double median;
    double mean;

    public int[] getFibonacciSequence() {
        return fibonacciSequence;
    }

    public double getMedian() {
        return median;
    }

    public double getMean() {
        return mean;
    }

    private int[] calculateSequence(int size) {
        int[] result = new int[size];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i < size; i++) {
           result[i] = result[i-1] + result[i-2];
        }
        return result;
    }

    private double calculateMean() {
        int sum = 0;
        for(int i = 0; i < this.size; i++) {
            sum += this.fibonacciSequence[i];
        }
        return sum / this.size;
    }

    private double calculateMedian() {
        return this.fibonacciSequence.length % 2 == 1?
            this.fibonacciSequence[this.size/2] :
            (this.fibonacciSequence[this.size/2] + this.fibonacciSequence[this.size/2 + 1]) /2;
    }
}