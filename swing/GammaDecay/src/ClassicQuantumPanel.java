//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ClassicQuantumPanel extends JPanel {
    static final int panelW = 600;
    static final int panelH = 300;
    SettingsContainer sc = new SettingsContainer();
    FlagShip fS = new FlagShip();
    Vector<Particle> particles = new Vector();
    Vector<Absorbent> absorbents = new Vector();
    Particle p;
    Absorbent a;
    int killedParticles = 0;
    double activity;
    double tmpLol2 = 0.0D;
    String engSubs = "The Gamma Radioation have been stopped after ";
    String polSubs = "Promieniowanie gamma zostało zatrzymane po ";
    String usedSubs;

    public ClassicQuantumPanel(FlagShip flagShip, SettingsContainer ps) {
        this.sc = ps;
        this.fS = flagShip;
        if(this.fS.isEngLanguage().booleanValue()) {
            this.usedSubs = this.engSubs;
        } else {
            this.usedSubs = this.polSubs;
        }

        this.setPreferredSize(new Dimension(600, 300));
        this.activity = this.sc.getActivity();

        for(int x = 0; x < 40; ++x) {
            this.p = new Particle(0, 30 + 5 * x, this.activity, x);
            this.particles.add(this.p);
            this.sc.setPow(this.activity);
            this.tmpLol2 = this.activity / 40.0D;
        }

        Timer timer = new Timer(50, (ActionListener)null);
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(ClassicQuantumPanel.this.fS.getAnim()) {
                    Iterator var3 = ClassicQuantumPanel.this.particles.iterator();

                    Particle w;
                    while(var3.hasNext()) {
                        w = (Particle)var3.next();
                        w.setX(w.getX() + 1);
                    }

                    ClassicQuantumPanel.this.repaint();
                    ClassicQuantumPanel.this.checkBG();
                    ClassicQuantumPanel.this.sc.setSeries((double)ClassicQuantumPanel.this.p.getX(), ClassicQuantumPanel.this.p.getPower());
                    ClassicQuantumPanel.this.sc.addSeriesToChart();
                    if(ClassicQuantumPanel.this.p.getX() > 600 || ClassicQuantumPanel.this.p.getPower() <= 1.0D || ClassicQuantumPanel.this.fS.stopAnim()) {
                        if(ClassicQuantumPanel.this.p.getX() > 600 || ClassicQuantumPanel.this.p.getPower() <= 1.0D) {
                            JOptionPane.showMessageDialog((Component)null, ClassicQuantumPanel.this.usedSubs + String.valueOf(ClassicQuantumPanel.this.p.getX() - 20) + " cm");
                        }

                        ClassicQuantumPanel.this.fS.setStopped(true);
                        ClassicQuantumPanel.this.fS.setStopAnim(true);
                        ClassicQuantumPanel.this.fS.setStopAnim(false);
                        ClassicQuantumPanel.this.fS.setAnim(false);
                        ClassicQuantumPanel.this.killedParticles = 0;
                        var3 = ClassicQuantumPanel.this.particles.iterator();

                        while(var3.hasNext()) {
                            w = (Particle)var3.next();
                            w.setX(0);
                            w.setKill(false);
                            w.repaint();
                        }
                    }
                }

                if(ClassicQuantumPanel.this.fS.addedAbsorbent() || ClassicQuantumPanel.this.fS.isClearAbs()) {
                    ClassicQuantumPanel.this.absorbents = ClassicQuantumPanel.this.sc.getAbsorbents();
                    ClassicQuantumPanel.this.fS.setAddedAbsorbent(false);
                    ClassicQuantumPanel.this.fS.setClearAbs(false);
                    ClassicQuantumPanel.this.repaint();
                }

            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 300);
        Iterator var3 = this.absorbents.iterator();

        while(var3.hasNext()) {
            Absorbent abs = (Absorbent)var3.next();
            abs.paint(g);
        }

        var3 = this.particles.iterator();

        while(var3.hasNext()) {
            Particle w = (Particle)var3.next();
            w.paint(g);
        }

    }

    public void setActivity(double a) {
        this.activity = a;
        this.p.setPower(a);
    }

    public void checkBG() {
        Iterator var2 = this.absorbents.iterator();

        while(true) {
            Absorbent o;
            do {
                do {
                    if(!var2.hasNext()) {
                        return;
                    }

                    o = (Absorbent)var2.next();
                } while(this.p.getX() < o.getX());
            } while((double)this.p.getX() > (double)o.getX() + o.getLenght());

            this.p.setPower(this.p.getPower() * Math.exp(-o.getMi()));

            for(int a = 0; a < 40; ++a) {
                if(this.activity / 40.0D * (double)a > this.p.getPower()) {
                    this.killedParticles = 40 - a;
                    System.out.println(a);
                    break;
                }
            }

            Iterator var4 = this.particles.iterator();

            while(var4.hasNext()) {
                Particle w = (Particle)var4.next();

                for(int j = 0; j <= this.killedParticles; ++j) {
                    if(w.getQNumber() < this.killedParticles) {
                        w.setKill(true);
                        w.repaint();
                        this.repaint();
                    }
                }
            }
        }
    }
}
