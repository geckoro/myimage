package imageProcessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
    public Window(MyImage pixelmap, char attribute) {
        super("MyImage");
        Canvas c = new Canvas() {
            public void paint (Graphics g) {
                int x, y;
                // pixelmap colorata
                x = y = 0;
                for (ArrayList<Pixel> pixels : pixelmap.matrix) {
                    for (Pixel pixel : pixels) {
                        Color myColor = new Color(pixel.getR(), pixel.getG(), pixel.getB());
                        g.setColor(myColor);
                        g.fillRect(x, y, 5, 5);
                        x += 5;
                    }
                    y += 5; x = 0;
                }
                // pixelmap alb-negru
                x = 405; y = 0;
                for (ArrayList<Pixel> pixels : pixelmap.matrixBW) {
                    for (Pixel pixel : pixels) {
                        Color myColor = new Color(pixel.getR(), pixel.getG(), pixel.getB());
                        g.setColor(myColor);
                        g.fillRect(x, y, 5, 5);
                        x += 5;
                    }
                    y += 5; x = 405;
                }
                // pixelmap cu componenta modificata
                x = 815; y = 0;
                for (ArrayList<Pixel> pixels : pixelmap.matrixREM) {
                    for (Pixel pixel : pixels) {
                        Color myColor = new Color(pixel.getR(), pixel.getG(), pixel.getB());
                        g.setColor(myColor);
                        g.fillRect(x, y, 5, 5);
                        x += 5;
                    }
                    y += 5; x = 810;
                }
            }
        };
        Label l1, l2, l3;
        l1 = new Label("Default");
        l1.setBounds(160, 610, 45, 15);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);
        add(l1);
        l2 = new Label("Black&White");
        l2.setBounds(565, 610, 95, 15);
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.BLACK);
        add(l2);
        String message = String.format("Removed (%s)", attribute);
        l3 = new Label(message);
        l3.setBounds(970, 610, 135, 15);
        l3.setForeground(Color.WHITE);
        l3.setBackground(Color.BLACK);
        add(l3);
        c.setBackground(Color.black);
        add(c);
        setSize(1210, 700);
        show();
    }

}

