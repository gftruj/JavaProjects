public class testObject{
    private boolean checked;
    private String language;
    public testObject(String s){
        checked = false;
        language = s;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}