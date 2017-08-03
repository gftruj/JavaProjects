//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ProgramSettingsChooser extends JFrame {
    // Flag container, settings container, language tmp's, boxes, labels, and the start button
    private FlagShip            flagShip;
    private SettingsContainer   settingsContainer;
    private String[]            languages = new String[]{"Polski", "English"};
    private JComboBox           languageComboChooser;
    private JButton             start;
    private JLabel              languageLabelChooser;
    private static int          panelW = 50,
                                panelH = 200;
    //The settings chooser box:
    public ProgramSettingsChooser(FlagShip flagShip, SettingsContainer settingsContainer) {
        //JFrame properties
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(3);
        this.setSize(panelW, panelH);
        this.setResizable(true);
        //pass the properties
        this.flagShip = flagShip;
        this.settingsContainer = settingsContainer;

        // Languages label and start button
        this.languageLabelChooser = new JLabel();
        this.languageLabelChooser.setText("Language//Język");
        this.languageComboChooser = new JComboBox(this.languages);
        this.start = new JButton("START");
        this.add(this.languageLabelChooser);
        this.add(this.languageComboChooser);
        this.add(this.start);
        this.setVisible(true);
        // listeners
        this.languageComboChooser.addItemListener(new ProgramSettingsChooser.languageComboChooserListener());
        this.start.addActionListener(new ProgramSettingsChooser.startBtnListener());

    }

//listeners:

    class languageComboChooserListener implements ItemListener {
        languageComboChooserListener() {
        }
        public void itemStateChanged(ItemEvent arg0) {
            if(ProgramSettingsChooser.this.languageComboChooser.getSelectedItem() == "English") {
                ProgramSettingsChooser.this.flagShip.setEngLanguage(Boolean.valueOf(true));
            } else if(ProgramSettingsChooser.this.languageComboChooser.getSelectedItem() == "Polski") {
                ProgramSettingsChooser.this.flagShip.setEngLanguage(Boolean.valueOf(false));
            }

        }
    }
    class startBtnListener implements ActionListener {
        startBtnListener() {
        }
        public void actionPerformed(ActionEvent arg0) {
            new MainProgramContainer(ProgramSettingsChooser.this.flagShip, ProgramSettingsChooser.this.settingsContainer);
            ProgramSettingsChooser.this.dispose();
        }
    }
}
