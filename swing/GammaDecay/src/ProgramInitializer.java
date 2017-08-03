//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
// Main class. Used primarily to initialize the whole program. In this case just the settings box:
public class ProgramInitializer {
    ProgramSettingsChooser settingsChooser;
    public ProgramInitializer() {
        this.settingsChooser = new ProgramSettingsChooser(new FlagShip(), new SettingsContainer());
    }

    public static void main(String[] args) {
        new ProgramInitializer();
    }
}
