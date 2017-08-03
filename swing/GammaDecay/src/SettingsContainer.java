//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Vector;
import org.jfree.data.xy.XYSeries;

public class SettingsContainer {
    private String language = "Polski";
    private String I;
    private String x;
    int stringIterator = 0;
    XYSeries series = new XYSeries("Seria");
    XYSeries series1 = new XYSeries("1cm");
    XYSeries series2 = new XYSeries("2cm");
    XYSeries series5 = new XYSeries("5cm");
    XYSeries series10 = new XYSeries("10cm");
    XYSeries series15 = new XYSeries("15cm");
    Vector<Absorbent> absorbents = new Vector();
    Vector<Particle> particles = new Vector();
    Charts tmpChart;
    String[] polozenie;
    String[] natezenie;
    Absorbent labAbsorbent = new Absorbent(20, 190, 1.0D, 10, "Beton");
    double activity = 8000.0D;
    double tmpAbsorbtion;
    double tmpPower;
    Particle p;

    public SettingsContainer() {
    }

    public SettingsContainer(Charts chart) {
        this.tmpChart = chart;
    }

    public void setLang(String S) {
        this.language = S;
    }

    public String getLang() {
        return this.language;
    }

    public Vector<Absorbent> getAbsorbents() {
        return this.absorbents;
    }

    public void setAbsorbents(Absorbent a) {
        this.absorbents.add(a);
    }

    public Vector<Particle> getParticles() {
        return this.particles;
    }

    public void setParticles(Particle p) {
        this.particles.add(p);
    }

    public void clearAbsorbents() {
        this.absorbents.clear();
        this.series.clear();
    }

    public void setSeries(double a, double b) {
        this.series.addOrUpdate(a, b);
    }

    public void addSeriesToChart() {
        this.tmpChart.addSeries(this.series);
    }

    public XYSeries getSeries() {
        return this.series;
    }

    public void resetSeries() {
        this.series.clear();
    }

    public void setWykres(Charts wykresiatka) {
        this.tmpChart = wykresiatka;
    }

    public Absorbent getLabAbsorbent() {
        return this.labAbsorbent;
    }

    public void setLabAbsorbent(Absorbent a) {
        this.absorbents.clear();
        this.absorbents.add(a);
        this.labAbsorbent = a;
    }

    public void setSeries(XYSeries s) {
        this.series.clear();
        this.series = s;
    }

    public void setLabSeries(int l, double a, double b) {
        switch(l) {
            case 1:
                this.series1.clear();
                this.series1.add(b, a);
                this.tmpChart.addSeries(this.series1);
                break;
            case 2:
                this.series2.clear();
                this.series2.add(b, a);
                this.tmpChart.addSeries(this.series2);
                break;
            case 5:
                this.series5.clear();
                this.series5.add(b, a);
                this.tmpChart.addSeries(this.series5);
                break;
            case 10:
                this.series10.clear();
                this.series10.add(b, a);
                this.tmpChart.addSeries(this.series10);
                break;
            case 15:
                this.series15.clear();
                this.series15.add(b, a);
                this.tmpChart.addSeries(this.series15);
        }

    }

    public void setActivity(double d) {
        this.activity = d;
        System.out.println(this.activity);
    }

    public double getActivity() {
        return this.activity;
    }

    public void setTmpAbs(double d) {
        this.tmpAbsorbtion = d;
    }

    public double getTmpAbs() {
        return this.tmpAbsorbtion;
    }

    public void clearChart() {
        this.series.clear();
    }

    public Particle getp() {
        return this.p;
    }

    public double getpow() {
        return this.tmpPower;
    }

    public void setPow(double activity2) {
        this.tmpPower = activity2;
    }
}
