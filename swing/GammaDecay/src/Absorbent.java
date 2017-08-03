

import java.awt.Color;
import java.awt.Graphics;

public class Absorbent {
    int x;
    int y;
    double mi;
    int dlugosc = 100;
    String material;

    public Absorbent(int x_, int y_, double mi_, int dlugosc_, String material_) {
        this.x = x_;
        this.y = y_;
        this.mi = mi_;
        this.dlugosc = dlugosc_;
        this.material = material_;
    }

    public void paint(Graphics g) {
        if(this.material == "Beton") {
            g.setColor(Color.gray);
        } else if(this.material == "Pb") {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(Color.WHITE);
        }

        g.fillRect(this.x, this.y, this.dlugosc, 300);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getLenght() {
        return (double)this.dlugosc;
    }

    public void setLength(int dlugosc_) {
        this.dlugosc = dlugosc_;
    }

    public double getMi() {
        return this.mi;
    }

    public void setMaterial(String S) {
        this.material = S;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMi(double mi_) {
        this.mi = mi_;
    }
}


