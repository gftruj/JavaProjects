//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CreateMenu extends JFrame {
    String[] englishSubs = new String[]{"Gamma Decay", "File", "Close", "Help", "About", "Contribute", "Made by Piotr Milewski \n Select the MeV preset, \n then build a barrier using the add button", "Likd the Pr0gram? \nContribute by sending 1$ at\n 02 24 1140 0000 2005"};
    String[] polishSubs = new String[]{"Osłabienie Gamma", "Plik", "Zamknij", "Pomoc", "O Programie", "Przyczyń sie", "Autor: Piotr Milewski \n wybierz wartość MeV \n stwórz barierę używając przycisku dodaj", "Fajny Pr0gram? \nPrzyczyń sie do niego stawiając nam Cole(1$) na \n 24 1140 2004 0000 3102 5087 5347"};
    String[] usedSubs;

    public CreateMenu(String lang, JFrame frame) {
        this.usedSubs = (lang=="English")?this.englishSubs:this.polishSubs;

        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        JMenu menuFile = new JMenu(this.usedSubs[1]);
        menu.add(menuFile);
        JMenuItem endProgram = new JMenuItem(this.usedSubs[2]);
        menuFile.add(endProgram);
        ActionListener endListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        endProgram.addActionListener(endListener);
        JMenu menuHelp = new JMenu(this.usedSubs[3]);
        menu.add(menuHelp);
        JMenuItem helpMe = new JMenuItem(this.usedSubs[4]);
        menuHelp.add(helpMe);
        JMenuItem contribute = new JMenuItem(this.usedSubs[5]);
        //menuHelp.add(contribute);
        ActionListener helpListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog((Component)null, CreateMenu.this.usedSubs[6]);
            }
        };
        ActionListener contributeListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog((Component)null, CreateMenu.this.usedSubs[7]);
            }
        };
        helpMe.addActionListener(helpListener);
        contribute.addActionListener(contributeListener);
    }
}
