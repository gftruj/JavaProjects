//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SettingsPanel extends JPanel {
    JTextField activityConstantTextField,
               activityPowerTextField,
               absorbentLength;
    String[] presety = new String[]{"Uran-235", "Pluton-239", "Radon-226", "Custom"},
             presetyAbsorbent = new String[]{"Beton", "Pb", "Aluminium"},
             presetyEnergii = new String[]{"0,2 MeV", "1,4 MeV", "3 MeV", "8 MeV"},
             englishSubs = new String[]{"Start", "Clear", "SOURCE", "Presets:", "Activity [Bq/g]:", "Absorbent", "Thickness[cm]", "Add", "", "", "STOP","SETTINGS","OPTIONS"},
             polishSubs = new String[]{"Start", "Wyczyść", "Parametry Źródła", "Presety:", "Aktywność [Bq/g]:", "Absorbent", "Grubość[cm]", "Dodaj", "", "", "STOP","USTAWIENIA","OPCJE"},
             usedSubs;
    JComboBox presetParticle,
              energyPreset,
              absorbentPreset;
    JButton startButton,
            clearButton,
            addAbsBtn,
            stopBtn;
    double absorbtion,
           energy,
           activity;
    String absorbent;
    Absorbent a;
    int summaryAbsorbentsLenght;
    SettingsContainer sc;
    FlagShip fs;
    MainPanel mpc;

    public SettingsPanel(FlagShip flagShip, SettingsContainer ps, MainPanel mainPanel) {
        this.presetParticle = new JComboBox(this.presety);
        this.energyPreset = new JComboBox(this.presetyEnergii);
        this.absorbentPreset = new JComboBox(this.presetyAbsorbent);
        this.energy = 0.2D;
        this.absorbent = "Beton";
        this.summaryAbsorbentsLenght = 20;
        this.sc = new SettingsContainer();
        this.fs = new FlagShip();
        this.sc = ps;
        this.fs = flagShip;
        this.mpc = mainPanel;
        this.usedSubs = this.fs.isEngLanguage().booleanValue()?this.englishSubs:this.polishSubs;

        this.setPreferredSize(new Dimension(200, 650));
        this.setLayout(new GridBagLayout());

        JLabel options = new JLabel(this.usedSubs[11]);
        options.setFont(new Font("TimesRoman", 1, 18));
        this.add(options, getGBC(0,1,3,1,new Insets(0,0,0,0),10));

        JLabel menuLabel = new JLabel(this.usedSubs[2]);
        menuLabel.setFont(new Font("TimesRoman", 1, 14));
        GridBagConstraints menuLabelC = getGBC(0,3,3,1,new Insets(0,0,0,0),10);
        menuLabelC.ipady = 40;
        this.add(menuLabel, menuLabelC);

        JLabel presetLabel = new JLabel(this.usedSubs[3]);
        presetLabel.setFont(new Font("TimesRoman", 1, 12));
        GridBagConstraints presetLabelC = getGBC(0,4,2,1,new Insets(0,-15,0,0),10);
        presetLabelC.ipadx = 10;
        //this.add(presetLabel, presetLabelC);

        GridBagConstraints energyPresetC = getGBC(0,5,0,1,new Insets(0,0,0,0),10);
        energyPresetC.ipady = 5;
        this.add(this.energyPreset, energyPresetC);
        this.energyPreset.addActionListener(new SettingsPanel.energyPresetListener());

        GridBagConstraints presetParticleC = getGBC(0,6,0,1,new Insets(10,0,0,0),10);
        presetParticleC.ipady = 2;
        this.add(this.presetParticle, presetParticleC);
        this.presetParticle.addActionListener(new SettingsPanel.ParticlePresetListener());

        JLabel activityLabel = new JLabel(this.usedSubs[4]);
        activityLabel.setFont(new Font("TimesRoman", 1, 12));
        this.add(activityLabel, getGBC(0,7,0,1,new Insets(10,10,0,0),21));

        this.activityConstantTextField = new JTextField(2);
        this.activityConstantTextField.setText("20");
        this.add(this.activityConstantTextField, getGBC(0,8,1,1,new Insets(0,25,0,0),21));

        JLabel activityPowerLabel = new JLabel("* 10^");
        activityPowerLabel.setFont(new Font("TimesRoman", 0, 12));
        GridBagConstraints activityPowerLabelC = getGBC(1,8,1,1,new Insets(0,-30,0,0),21);
        this.add(activityPowerLabel, activityPowerLabelC);

        this.activityPowerTextField = new JTextField(2);
        this.activityPowerTextField.setText("20");
        this.add(this.activityPowerTextField, getGBC(2,8,1,1,new Insets(0,-25,0,0),21));

        JLabel absorbentLabel = new JLabel(this.usedSubs[5]);
        absorbentLabel.setFont(new Font("TimesRoman", 1, 14));
        GridBagConstraints absorbentLabelC = getGBC(0,9,3,1,new Insets(0,0,0,0),10);
        absorbentLabelC.ipady = 20;
        this.add(absorbentLabel, absorbentLabelC);

        JLabel absorbionLabel = new JLabel(this.usedSubs[6]);
        absorbionLabel.setFont(new Font("TimesRoman", 1, 12));
        this.add(absorbionLabel, getGBC(0,10,1,1,new Insets(0,10,5,0),21));

        this.absorbentLength = new JTextField(2);
        this.absorbentLength.setText("20");
        this.add(this.absorbentLength, getGBC(2,10,1,1,new Insets(0,-20,0,10),21));

        GridBagConstraints absorbentPresetC = getGBC(0,11,2,1,new Insets(0,25,0,0),10);
        absorbentPresetC.ipady = 10;
        this.add(this.absorbentPreset, absorbentPresetC);
        this.absorbentPreset.addActionListener(new SettingsPanel.AbsorbentPresetListener());

        this.addAbsBtn = new JButton(this.usedSubs[7]);
        this.add(this.addAbsBtn, getGBC(0,12,3,1,new Insets(10,0,10,0),10));
        this.addAbsBtn.addActionListener(new SettingsPanel.addAbsBtnAction());

        JLabel settings = new JLabel(this.usedSubs[12]);
        settings.setFont(new Font("TimesRoman", 1, 18));
        this.add(settings, getGBC(0,13,3,1,new Insets(0,0,0,0),10));

        this.startButton = new JButton(this.usedSubs[0]);
        this.add(this.startButton, getGBC(0,14,0,1,new Insets(5,0,10,0),10));
        this.startButton.addActionListener(new SettingsPanel.startBtnListener());

        this.stopBtn = new JButton(this.usedSubs[10]);
        this.add(this.stopBtn, getGBC(0,15,0,1,new Insets(5,0,10,0),10));
        this.stopBtn.addActionListener(new SettingsPanel.stopButtonListener());

        this.clearButton = new JButton(this.usedSubs[1]);
        this.add(this.clearButton, getGBC(0,16,0,1,new Insets(5,0,5,0),10));
        this.clearButton.addActionListener(new SettingsPanel.clearBtnListener());

        this.activityConstantTextField.setText("8");
        this.activityConstantTextField.setEditable(false);
        this.activityPowerTextField.setEditable(false);
        this.activityPowerTextField.setText("4");
        this.absorbentPreset.setEnabled(false);
        Timer t = new Timer(50, (ActionListener)null);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(SettingsPanel.this.fs.isClearAbs()) {
                    SettingsPanel.this.reset();
                }
            }
        });
        t.start();
    }


    //GridBagConstraints factory
    public GridBagConstraints getGBC(int gridx,int gridy,int gridWidth,int gridHeight,Insets insets, int anchor){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        gbc.insets = insets;
        gbc.anchor = anchor;
        return gbc;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 200, 650);
    }

    public void reset() {
        this.absorbentPreset.setEnabled(false);
        this.energyPreset.setEnabled(true);
    }

    class AbsorbentPresetListener implements ActionListener {
        AbsorbentPresetListener() {
        }

        public void actionPerformed(ActionEvent e) {
            SettingsPanel.this.absorbent = (String) SettingsPanel.this.absorbentPreset.getSelectedItem();
        }
    }
    public void activityTextFieldHandler(String x, String y){
        SettingsPanel.this.activityConstantTextField.setText(x);
        SettingsPanel.this.activityPowerTextField.setText(y);
        SettingsPanel.this.activityPowerTextField.setEditable(false);
        SettingsPanel.this.activityConstantTextField.setEditable(false);
    }
    class ParticlePresetListener implements ActionListener {
        ParticlePresetListener() {
        }
        public void actionPerformed(ActionEvent e) {
            switch (SettingsPanel.this.presetParticle.getSelectedIndex()){
                case 0:
                    activityTextFieldHandler("8","4");
                    break;
                case 1:
                    activityTextFieldHandler("2.3","9");
                    break;
                case 2:
                    activityTextFieldHandler("3.7","10");
                    break;
                case 3:
                    activityTextFieldHandler("1","1");
                    break;
            }
        }
    }

    class addAbsBtnAction implements ActionListener {
        addAbsBtnAction() {
        }
        public void actionPerformed(ActionEvent e) {
            if(SettingsPanel.this.absorbent == "Beton") {
                if(SettingsPanel.this.energy == 0.2D) {
                    SettingsPanel.this.absorbtion = 0.275D;
                } else if(SettingsPanel.this.energy == 1.4D) {
                    SettingsPanel.this.absorbtion = 0.12D;
                } else if(SettingsPanel.this.energy == 3.0D) {
                    SettingsPanel.this.absorbtion = 0.08D;
                } else {
                    SettingsPanel.this.absorbtion = 0.058D;
                }
            } else if(SettingsPanel.this.absorbent == "Pb") {
                if(SettingsPanel.this.energy == 0.2D) {
                    SettingsPanel.this.absorbtion = 11.8D;
                } else if(SettingsPanel.this.energy == 1.4D) {
                    SettingsPanel.this.absorbtion = 0.6D;
                } else if(SettingsPanel.this.energy == 3.0D) {
                    SettingsPanel.this.absorbtion = 0.55D;
                } else {
                    SettingsPanel.this.absorbtion = 0.46D;
                }
            } else if(SettingsPanel.this.energy == 0.2D) {
                SettingsPanel.this.absorbtion = 0.323D;
            } else if(SettingsPanel.this.energy == 1.4D) {
                SettingsPanel.this.absorbtion = 0.141D;
            } else if(SettingsPanel.this.energy == 3.0D) {
                SettingsPanel.this.absorbtion = 0.094D;
            } else {
                SettingsPanel.this.absorbtion = 0.068D;
            }

            SettingsPanel.this.a = new Absorbent(SettingsPanel.this.summaryAbsorbentsLenght, 0, SettingsPanel.this.absorbtion, Integer.parseInt(SettingsPanel.this.absorbentLength.getText()), SettingsPanel.this.absorbent);
            SettingsPanel.this.sc.setAbsorbents(SettingsPanel.this.a);
            SettingsPanel.this.fs.setAddedAbsorbent(true);
            SettingsPanel.this.summaryAbsorbentsLenght += Integer.parseInt(SettingsPanel.this.absorbentLength.getText());
        }
    }

    class clearBtnListener implements ActionListener {
        clearBtnListener() {
        }
        public void actionPerformed(ActionEvent e) {
            SettingsPanel.this.summaryAbsorbentsLenght = 20;
            SettingsPanel.this.sc.clearAbsorbents();
            SettingsPanel.this.fs.setClearAbs(true);
        }
    }

    class energyPresetListener implements ActionListener {
        energyPresetListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if(SettingsPanel.this.energyPreset.getSelectedIndex() == 0) {
                SettingsPanel.this.energy = 0.2D;
            }

            if(SettingsPanel.this.energyPreset.getSelectedIndex() == 1) {
                SettingsPanel.this.energy = 1.2D;
            }

            if(SettingsPanel.this.energyPreset.getSelectedIndex() == 2) {
                SettingsPanel.this.energy = 3.0D;
            }

            if(SettingsPanel.this.energyPreset.getSelectedIndex() == 3) {
                SettingsPanel.this.energy = 8.0D;
            }

            SettingsPanel.this.energyPreset.setEnabled(false);
            SettingsPanel.this.absorbentPreset.setEnabled(true);
        }
    }

    class startBtnListener implements ActionListener {
        public startBtnListener() {
        }

        public void actionPerformed(ActionEvent e) {
            SettingsPanel.this.sc.clearChart();
            SettingsPanel.this.mpc.getQcp().setActivity(Double.parseDouble(SettingsPanel.this.activityConstantTextField.getText()) * Math.pow(10.0D, Double.parseDouble(SettingsPanel.this.activityPowerTextField.getText())));
            SettingsPanel.this.fs.setAnim(true);
        }
    }

    class stopButtonListener implements ActionListener {
        stopButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            SettingsPanel.this.sc.clearChart();
            SettingsPanel.this.fs.setStopAnim(true);
        }
    }
}
