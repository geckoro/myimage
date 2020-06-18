package imageProcessor;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyImage test = new MyImage(120, 80);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter either R, G or B for removing it: ");
        char attribute = input.next().charAt(0);

        test.transformgray();
        test.remove(attribute);
        Window fereastra = new Window(test, attribute);
    }
}
