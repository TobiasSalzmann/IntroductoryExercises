import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by tsalzman on 1/5/16.
 */
public class IntroductoryExercises {

    static final char c = '*';
    static final String name = "Tobi";

    public static void main(String[] args) {
        generate(100).forEach(System.out::println);
    }

    public static void easiestExerciseEver() {
        System.out.println(c);
    }

    public static void drawHorizontalLine(int n) {
        System.out.println(line(n,0,c));
    }

    public static void drawVerticalLine(int n) {
        IntStream.rangeClosed(1,n)
                .forEach(k -> System.out.println(c));
    }

    public static void drawRightTriangle(int n) {
        IntStream.rangeClosed(1,n)
                .forEach(k -> System.out.println(line(k,0,c)));
    }

    public static void drawIsoTriangle(int n) {
        IntStream.rangeClosed(1,n)
                .forEach(k -> System.out.println(line(2*k-1,n-k,c)));
    }

    public static void drawDiamond(int n) {
        IntStream.concat(IntStream.rangeClosed(1,n),IntStream.range(1,n).map(k -> n-k))
                .forEach(k -> System.out.println(line(2*k-1,n-k,c)));
    }

    public static void drawDiamondWithName(int n) {
        IntStream.concat(IntStream.rangeClosed(1,n),IntStream.range(1,n).map(k -> n-k))
                .forEach(k -> System.out.println(k == n ? name : line(2*k-1,n-k,c)));
    }


    private static String line(int length, int offset, char c){
        String acc = "";
        for (int i = 0; i < offset; i++)
            acc += " ";
        for (int i = 0; i < length; i++)
            acc += c;
        return acc;
    }

    public static void fizzBuzzExercise(int n){
        IntStream.rangeClosed(1,n).forEach(k -> {
            boolean fizz = k % 3 == 0;
            boolean buzz = k % 5 == 0;
            if(fizz)
                System.out.print("Fizz");
            if(buzz)
                System.out.print("Buzz");
            if(!fizz && !buzz)
                System.out.print(k);
            System.out.println();
        });
    }

    public static List<Integer> generate(int n){
        return primeList(n,2);
    }

    public static List<Integer> primeList(int n, int lowerBound){
        if(lowerBound > n)
            return new LinkedList<>();
        else{
            int factor = smallestFactor(n, lowerBound);
            List<Integer> list = primeList(n / factor, factor);
            list.add(0,factor);
            return list;

        }

    }

    private static int smallestFactor(int n, int lowerBound){
        for (int i = lowerBound; i*i <= n; i++) {
            if(n % i == 0)
                return i;
        }
        return n;
    }



}
