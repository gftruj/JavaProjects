//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
    ClassicQuantumPanel quantumPanel;
    Charts charts;

    public MainPanel(FlagShip flagShip, SettingsContainer sc) {
        this.setLayout(new BorderLayout());
        if(flagShip.isClassicGtype().booleanValue()) {
            this.quantumPanel = new ClassicQuantumPanel(flagShip, sc);
            this.add(this.quantumPanel, "Center");
        }

        this.charts = new Charts(flagShip, sc);
        this.add(this.charts, "South");
        sc.setWykres(this.charts);
    }
    public ClassicQuantumPanel getQcp() {
        return this.quantumPanel;
    }
}
