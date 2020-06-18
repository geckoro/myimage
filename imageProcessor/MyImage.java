package imageProcessor;
import java.util.*;

public class MyImage {
    Random rand = new Random();
    public ArrayList<ArrayList<Pixel>> matrix = new ArrayList<ArrayList<Pixel>>();
    public ArrayList<ArrayList<Pixel>> matrixBW = new ArrayList<ArrayList<Pixel>>();
    public ArrayList<ArrayList<Pixel>> matrixREM = new ArrayList<ArrayList<Pixel>>();
    private int m, n;

    public MyImage(int m, int n) {
        this.m = m;
        this.n = n;
        for(int i = 0; i < m; i++) {
            ArrayList<Pixel> temparray = new ArrayList<Pixel>();
            for(int j = 0; j < n; j++) {
                Pixel temp = new Pixel(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                temparray.add(temp);
            }
            this.matrix.add(temparray);
        }
    }

    public void printmatrix() {
        for (ArrayList<Pixel> pixels : this.matrix) {
            for (Pixel pixel : pixels) {
                System.out.printf("(%d, %d, %d)  ", pixel.getR(), pixel.getG(),
                        pixel.getB());
            }
            System.out.println("");
        }
    }

    public void modifymatrix() {
        for (ArrayList<Pixel> pixels : this.matrix) {
            for (Pixel pixel : pixels) {
                pixel.setR(rand.nextInt(256));
                pixel.setG(rand.nextInt(256));
                pixel.setB(rand.nextInt(256));
            }
        }
    }

    public void deletepixels(int R, int G, int B) {
        for (ArrayList<Pixel> pixels : this.matrix) {
            for (Pixel pixel : pixels) {
                if(pixel.getR() < R && pixel.getG() < G && pixel.getB() < B) {
                    pixel.setR(-1);
                    pixel.setG(-1);
                    pixel.setB(-1);
                }
            }
        }
    }

    public void remove(char attribute) {
        for (ArrayList<Pixel> pixels : this.matrix) {
            ArrayList<Pixel> temparray = new ArrayList<Pixel>();
            for (Pixel pixel : pixels) {
                Pixel temp;
                switch (attribute) {
                    case 'R' -> {
                        temp = new Pixel(0, pixel.getG(), pixel.getB());
                        temparray.add(temp);
                    }
                    case 'G' -> {
                        temp = new Pixel(pixel.getR(), 0, pixel.getB());
                        temparray.add(temp);
                    }
                    case 'B' -> {
                        temp = new Pixel(pixel.getR(), pixel.getG(), 0);
                        temparray.add(temp);
                    }
                }
            }
            matrixREM.add(temparray);
        }
    }

    protected void transformgray() {
        for (ArrayList<Pixel> pixels : this.matrix) {
            ArrayList<Pixel> temparray = new ArrayList<Pixel>();
            for (Pixel pixel : pixels) {
                int graycolor = (int)(0.21*pixel.getR() + 0.71*pixel.getG() + 0.07*pixel.getB());
                Pixel temp = new Pixel(graycolor, graycolor, graycolor);
                temparray.add(temp);
            }
            matrixBW.add(temparray);
        }
    }
}
