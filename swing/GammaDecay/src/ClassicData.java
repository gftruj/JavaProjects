//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import sun.plugin.javascript.navig.Anchor;

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

public class ClassicData extends JPanel {
    JTextField activityConstantTextField,
               activityPowerTextField,
               absorbentLength;
    String[] presety = new String[]{"Uran-235", "Pluton-239", "Radon-226", "Custom"},
             presetyAbsorbent = new String[]{"Beton", "Pb", "Aluminium"},
             presetyEnergii = new String[]{"0,2 MeV", "1,4 MeV", "3 MeV", "8 MeV"},
             englishSubs = new String[]{"Start", "Clear", "SOURCE", "Presets:", "Activity [Bq/g]:", "Absorbent", "Thickness[cm]", "Add", "", "", "STOP","SETTINGS","OPTIONS"},
             polishSubs = new String[]{"Start", "Wyczyść", "Parametry Źródła", "Presety:", "Aktywność [Bq/g]:", "Absorbent", "Grubość[cm]", "Dodaj", "", "", "STOP","USTAWIENIA","OPCJE"},
             usedSubs;
    JComboBox presetParticle;
    JComboBox energyPreset;
    JComboBox absorbentPreset;
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

    public ClassicData(FlagShip flagShip, SettingsContainer ps, MainPanel mainPanel) {
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

        GridBagConstraints energyPresetC = getGBCwoInsets(0,5,0,1,10);
        energyPresetC.ipady = 5;
        this.add(this.energyPreset, energyPresetC);
        this.energyPreset.addActionListener(new ClassicData.energyPresetListener());

        GridBagConstraints presetParticleC = getGBC(0,6,0,1,new Insets(10,0,0,0),10);
        presetParticleC.ipady = 2;
        this.add(this.presetParticle, presetParticleC);
        this.presetParticle.addActionListener(new ClassicData.ParticlePresetListener());

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
        this.absorbentPreset.addActionListener(new ClassicData.AbsorbentPresetListener());

        this.addAbsBtn = new JButton(this.usedSubs[7]);
        this.add(this.addAbsBtn, getGBC(0,12,3,1,new Insets(10,0,10,0),10));
        this.addAbsBtn.addActionListener(new ClassicData.addAbsBtnAction());

        JLabel settings = new JLabel(this.usedSubs[12]);
        settings.setFont(new Font("TimesRoman", 1, 18));
        this.add(settings, getGBC(0,13,3,1,new Insets(0,0,0,0),10));

        this.startButton = new JButton(this.usedSubs[0]);
        this.add(this.startButton, getGBC(0,14,0,1,new Insets(5,0,10,0),10));
        this.startButton.addActionListener(new ClassicData.startBtnListener());

        this.stopBtn = new JButton(this.usedSubs[10]);
        this.add(this.stopBtn, getGBC(0,15,0,1,new Insets(5,0,10,0),10));
        this.stopBtn.addActionListener(new ClassicData.stopButtonListener());

        this.clearButton = new JButton(this.usedSubs[1]);
        this.add(this.clearButton, getGBC(0,16,0,1,new Insets(5,0,5,0),10));
        this.clearButton.addActionListener(new ClassicData.clearBtnListener());

        this.activityConstantTextField.setText("8");
        this.activityConstantTextField.setEditable(false);
        this.activityPowerTextField.setEditable(false);
        this.activityPowerTextField.setText("4");
        this.absorbentPreset.setEnabled(false);
        Timer t = new Timer(50, (ActionListener)null);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(ClassicData.this.fs.isClearAbs()) {
                    ClassicData.this.reset();
                }
            }
        });
        t.start();
    }



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
    public GridBagConstraints getGBCwoInsets(int gridx,int gridy,int gridWidth,int gridHeight,int anchor){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
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
            ClassicData.this.absorbent = (String) ClassicData.this.absorbentPreset.getSelectedItem();
        }
    }

    class ParticlePresetListener implements ActionListener {
        ParticlePresetListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if(ClassicData.this.presetParticle.getSelectedIndex() == 0) {
                ClassicData.this.activityConstantTextField.setText("8");
                ClassicData.this.activityPowerTextField.setText("4");
                ClassicData.this.activityPowerTextField.setEditable(false);
                ClassicData.this.activityConstantTextField.setEditable(false);
            }

            if(ClassicData.this.presetParticle.getSelectedIndex() == 1) {
                ClassicData.this.activityConstantTextField.setText("2.3");
                ClassicData.this.activityPowerTextField.setText("9");
                ClassicData.this.activityPowerTextField.setEditable(false);
                ClassicData.this.activityConstantTextField.setEditable(false);
            }

            if(ClassicData.this.presetParticle.getSelectedIndex() == 2) {
                ClassicData.this.activityConstantTextField.setText("3.7");
                ClassicData.this.activityPowerTextField.setText("10");
                ClassicData.this.activityPowerTextField.setEditable(false);
                ClassicData.this.activityConstantTextField.setEditable(false);
            }

            if(ClassicData.this.presetParticle.getSelectedIndex() == 3) {
                ClassicData.this.activityConstantTextField.setText("1");
                ClassicData.this.activityPowerTextField.setText("1");
                ClassicData.this.activityPowerTextField.setEditable(true);
                ClassicData.this.activityConstantTextField.setEditable(true);
            }

        }
    }

    class addAbsBtnAction implements ActionListener {
        addAbsBtnAction() {
        }

        public void actionPerformed(ActionEvent e) {
            if(ClassicData.this.absorbent == "Beton") {
                if(ClassicData.this.energy == 0.2D) {
                    ClassicData.this.absorbtion = 0.275D;
                } else if(ClassicData.this.energy == 1.4D) {
                    ClassicData.this.absorbtion = 0.12D;
                } else if(ClassicData.this.energy == 3.0D) {
                    ClassicData.this.absorbtion = 0.08D;
                } else {
                    ClassicData.this.absorbtion = 0.058D;
                }
            } else if(ClassicData.this.absorbent == "Pb") {
                if(ClassicData.this.energy == 0.2D) {
                    ClassicData.this.absorbtion = 11.8D;
                } else if(ClassicData.this.energy == 1.4D) {
                    ClassicData.this.absorbtion = 0.6D;
                } else if(ClassicData.this.energy == 3.0D) {
                    ClassicData.this.absorbtion = 0.55D;
                } else {
                    ClassicData.this.absorbtion = 0.46D;
                }
            } else if(ClassicData.this.energy == 0.2D) {
                ClassicData.this.absorbtion = 0.323D;
            } else if(ClassicData.this.energy == 1.4D) {
                ClassicData.this.absorbtion = 0.141D;
            } else if(ClassicData.this.energy == 3.0D) {
                ClassicData.this.absorbtion = 0.094D;
            } else {
                ClassicData.this.absorbtion = 0.068D;
            }

            ClassicData.this.a = new Absorbent(ClassicData.this.summaryAbsorbentsLenght, 0, ClassicData.this.absorbtion, Integer.parseInt(ClassicData.this.absorbentLength.getText()), ClassicData.this.absorbent);
            ClassicData.this.sc.setAbsorbents(ClassicData.this.a);
            ClassicData.this.fs.setAddedAbsorbent(true);
            ClassicData.this.summaryAbsorbentsLenght += Integer.parseInt(ClassicData.this.absorbentLength.getText());
        }
    }

    class clearBtnListener implements ActionListener {
        clearBtnListener() {
        }

        public void actionPerformed(ActionEvent e) {
            ClassicData.this.summaryAbsorbentsLenght = 20;
            ClassicData.this.sc.clearAbsorbents();
            ClassicData.this.fs.setClearAbs(true);
        }
    }

    class csvExportAction implements ActionListener {
        csvExportAction() {
        }

        public void actionPerformed(ActionEvent e) {
            ClassicData.this.fs.setExport(true);
        }
    }

    class energyPresetListener implements ActionListener {
        energyPresetListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if(ClassicData.this.energyPreset.getSelectedIndex() == 0) {
                ClassicData.this.energy = 0.2D;
            }

            if(ClassicData.this.energyPreset.getSelectedIndex() == 1) {
                ClassicData.this.energy = 1.2D;
            }

            if(ClassicData.this.energyPreset.getSelectedIndex() == 2) {
                ClassicData.this.energy = 3.0D;
            }

            if(ClassicData.this.energyPreset.getSelectedIndex() == 3) {
                ClassicData.this.energy = 8.0D;
            }

            ClassicData.this.energyPreset.setEnabled(false);
            ClassicData.this.absorbentPreset.setEnabled(true);
        }
    }

    class startBtnListener implements ActionListener {
        public startBtnListener() {
        }

        public void actionPerformed(ActionEvent e) {
            ClassicData.this.sc.clearChart();
            ClassicData.this.mpc.getQcp().setActivity(Double.parseDouble(ClassicData.this.activityConstantTextField.getText()) * Math.pow(10.0D, Double.parseDouble(ClassicData.this.activityPowerTextField.getText())));
            ClassicData.this.fs.setAnim(true);
        }
    }

    class stopButtonListener implements ActionListener {
        stopButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            ClassicData.this.sc.clearChart();
            ClassicData.this.fs.setStopAnim(true);
        }
    }
}
