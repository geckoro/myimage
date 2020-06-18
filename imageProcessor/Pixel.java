package imageProcessor;

public class Pixel {
    private int R, G, B;
    public Pixel(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getR() {
        return this.R;
    }

    public int getG() {
        return this.G;
    }

    public int getB() {
        return this.B;
    }

    public void setR(int R) {
        this.R = R;
    }

    public void setG(int G) {
        this.G = G;
    }

    public void setB(int B) {
        this.B = B;
    }
}
