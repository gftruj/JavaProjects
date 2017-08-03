//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainProgramContainer extends JFrame {
    SettingsPanel settingsPanel;
    MainPanel mainPanel;
    String[] englishSubs = new String[]{"Gamma Decay"};
    String[] polishSubs = new String[]{"Osłabienie Gamma"};
    String[] usedSubs;
    String lang;

    public MainProgramContainer(FlagShip flagShip, SettingsContainer settingsContainer) {
        if(flagShip.isEngLanguage().booleanValue()) {
            this.usedSubs = this.englishSubs;
            this.lang = "English";
        } else {
            this.usedSubs = this.polishSubs;
            this.lang = "Polski";
        }


        this.setLayout(new BorderLayout());
        new CreateMenu(this.lang, this);
        this.mainPanel = new MainPanel(flagShip, settingsContainer);
        this.settingsPanel = new SettingsPanel(flagShip, settingsContainer, this.mainPanel);

        this.add(this.mainPanel, "Center");
        this.add(this.settingsPanel, "East");
        this.setDefaultCloseOperation(3);
        this.setSize(800, 600);
        this.setTitle(this.usedSubs[0]);
        this.setResizable(true);
        this.setVisible(true);
        this.revalidate();
    }
}
