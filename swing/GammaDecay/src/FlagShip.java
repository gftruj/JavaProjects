//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class FlagShip {
    Boolean classicGtype = Boolean.valueOf(true);
    Boolean engLanguage = Boolean.valueOf(false);
    Boolean fastMode = Boolean.valueOf(false);
    Boolean addAbs = Boolean.valueOf(false);
    Boolean clearAbs = Boolean.valueOf(false);
    Boolean stopAnim = Boolean.valueOf(false);
    Boolean startAnim = Boolean.valueOf(false);
    Boolean music = Boolean.valueOf(false);
    Boolean stopped = Boolean.valueOf(false);
    Boolean csvExport = Boolean.valueOf(false);

    public FlagShip() {
    }

    public void setClassicGametype(Boolean b) {
        this.classicGtype = b;
    }

    public Boolean isClassicGtype() {
        return this.classicGtype;
    }

    public void setEngLanguage(Boolean b) {
        this.engLanguage = b;
    }

    public Boolean isEngLanguage() {
        return this.engLanguage;
    }

    public void setMus(boolean m) {
        if(m) {
            this.music = Boolean.valueOf(true);
        } else {
            this.music = Boolean.valueOf(false);
        }

    }

    public boolean getMus() {
        return this.music.booleanValue();
    }

    public boolean getAnim() {
        return this.startAnim.booleanValue();
    }

    public void setAnim(boolean t) {
        this.startAnim = Boolean.valueOf(t);
    }

    public boolean addedAbsorbent() {
        return this.addAbs.booleanValue();
    }

    public void setAddedAbsorbent(boolean b) {
        this.addAbs = Boolean.valueOf(b);
    }

    public boolean isClearAbs() {
        return this.clearAbs.booleanValue();
    }

    public void setClearAbs(boolean b) {
        this.clearAbs = Boolean.valueOf(b);
    }

    public void setStopAnim(boolean b) {
        this.stopAnim = Boolean.valueOf(b);
    }

    public boolean stopAnim() {
        return this.stopAnim.booleanValue();
    }

    public boolean isFastMode() {
        return this.fastMode.booleanValue();
    }

    public void setFastMode(boolean set) {
        this.fastMode = Boolean.valueOf(set);
    }

    public void setStopped(boolean b) {
        this.stopped = Boolean.valueOf(b);
    }

    public boolean stopped() {
        return this.stopped.booleanValue();
    }

    public void setExport(boolean b) {
        this.csvExport = Boolean.valueOf(b);
    }

    public Boolean getExport() {
        return this.csvExport;
    }
}
