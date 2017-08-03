//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Particle extends JComponent {
    int x;
    int y;
    int quantumNumber = 0;
    double power;
    final int promien = 2;
    boolean kill = false;
    Color kolor;

    public Particle(int x_, int y_, double Power, int x2) {
        this.kolor = Color.cyan;
        this.x = x_;
        this.y = y_;
        this.power = Power;
        this.quantumNumber = x2;
    }

    public void paint(Graphics g) {
        if(!this.kill) {
            g.setColor(Color.cyan);
            g.fillOval(this.x - 1, this.y - 1, 5, 5);
        } else {
            g.fillOval(0, 0, 0, 0);
            this.setVisible(false);
        }

    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getPower() {
        return this.power;
    }

    public void setPower(double power_) {
        this.power = power_;
    }

    public void setKill(boolean b) {
        this.kill = b;
    }

    public void setQNumber(int i_) {
        this.quantumNumber = i_;
    }

    public int getQNumber() {
        return this.quantumNumber;
    }
}
