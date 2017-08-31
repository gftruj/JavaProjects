import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pionek on 2017-08-31.
 */
@Config(
        browser = Browser.CHROME,
        url = "http://vrrocks.pl"
)

public class mainClass extends Locomotive {
    List<String> sequence;
    List<testObject> langTests;
    testObject plTest = new testObject("PL"),
            enTest = new testObject("EN");

    public mainClass() {
        sequence = new ArrayList<String>() {{
            add("#webvrlink");
            add("#linktous");
            add("#mainsitelink");
        }};
        langTests = new ArrayList<testObject>() {{
            add(plTest);
            add(enTest);
        }};
    }

    public void clickAndValidateByCSS(String s) {
        click(s).validatePresent(s);
    }

    public boolean clickAndValidateTestLink(List<String> items, String s) {
        String csslang;
        csslang = (s.equals("PL") ? "#pllink" : "#enlink");
        try {
            clickAndValidateByCSS(csslang);
            for (String i : items) {
                clickAndValidateByCSS(i);
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Test
    public void testLinks() {
        for (testObject check : langTests) {
            check.setChecked(clickAndValidateTestLink(sequence, check.getLanguage()));
        }
    }

    @After
    public void log() {
        System.out.println("LOGGIN: \n");
        for (testObject check : langTests) {
            System.out.println(check.getLanguage()+": "+check.isChecked()+"\n");
        }
    }

}

