//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainProgramContainer extends JFrame {
    SettingsPanel settingsPanel;
    MainPanel mainPanel;
    String[] englishSubs = new String[]{"Gamma Decay", "File", "Close", "Help", "About", "Contribute", "Made by Piotr Milewski & Jack Sikorski \n Made For: \n mgr. Jacek Bzdak", "Likd the Program? \nContribute by sending 1$ at\n 24 1140 2004 0000 3102 5087 5347"};
    String[] polishSubs = new String[]{"Osłabienie Gamma", "Plik", "Zamknij", "Pomoc", "O Programie", "Przyczyń sie", "Autorzy: Piotr Milewski i Jacek Sikorski \n Wyprodukowano Dla: \n mgr. Jacek Bzdak", "Fajny Pr0gram? \nPrzyczayń sie do niego stawiajac nam Cole(1$) na \n 24 1140 2004 0000 3102 5087 5347"};
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
