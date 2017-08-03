//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Charts extends JPanel {
    JFreeChart chart;
    ChartPanel chartPanel;
    XYSeriesCollection dataset;
    String[] englishSubs = new String[]{"Chart", "Position[cm]", "Intensity[I]"};
    String[] polishSubs = new String[]{"Wykres", "Położenie[cm]", "Natężenie[I]"};
    String[] usedSubs;
    SettingsContainer sc;
    FlagShip flagship;

    public Charts(FlagShip flagShip, SettingsContainer ps) {
        if(flagShip.isEngLanguage().booleanValue()) {
            this.usedSubs = this.englishSubs;
        } else {
            this.usedSubs = this.polishSubs;
        }

        this.sc = ps;
        this.setPreferredSize(new Dimension(600, 300));
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        this.dataset = new XYSeriesCollection();
        this.dataset.removeAllSeries();
        this.chart = ChartFactory.createXYLineChart("", this.usedSubs[1], this.usedSubs[2], this.dataset, PlotOrientation.VERTICAL, false, false, false);
        this.chartPanel = new ChartPanel(this.chart);
        this.add(this.chartPanel, "Center");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 600, 300);
    }

    public List getSeries() {
        return this.dataset.getSeries();
    }

    public void addSeries(XYSeries series_) {
        this.dataset.removeAllSeries();
        this.dataset.addSeries(series_);
    }
}
