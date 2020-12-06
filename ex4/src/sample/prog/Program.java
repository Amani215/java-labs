package sample.prog;
import sample.calc.*;
public class Program {
    public static void main(String[] args) {
        int x = 5;
        int y = 8;
        int z = Calculator.add(x, y);
        System.out.println(z);
    }
}
