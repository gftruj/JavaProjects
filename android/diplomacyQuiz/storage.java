package com.example.pionek.diplomacypls;

import java.util.ArrayList;

/**
 * Created by Pionek on 01.09.2016.
 */
public class storage {


    public class item {
        String kraj;
        String state;
        String legisType;
        ArrayList<String> figury = new ArrayList<String>();
        ArrayList<String> parlamenty = new ArrayList<String>();

        public void addFigure(String _figure){
            figury.add(_figure);
        }
        public void addParlamenty(String _parlamenty){
            parlamenty.add(_parlamenty);
        }
        public void setCountry(String _cnt){
            kraj = _cnt;
        }
        public void setState(String _cnt){
            state = _cnt;
        }
        public void setLegisType(String _cnt){
            legisType = _cnt;
        }


    }
    ArrayList<item> base = new ArrayList<item>();
    public storage(){


        item Australia = new item();
        Australia.addFigure("Governor-General Sir Peter Cosgrove");
        Australia.addFigure("Prime Minister Malcolm Turnbull");
        Australia.addParlamenty("Upper house Senate");
        Australia.addParlamenty("Lower house House of Representatives");
        Australia.setCountry("Australia");
        Australia.setState("Federal parliamentary constitutional monarchy");
        Australia.setLegisType("Parliament");

        base.add(Australia);

        item Armenia = new item();
        Armenia.setCountry("Armenia");
        Armenia.setState("Unitary semi-presidential republic");
        Armenia.addFigure("President Serzh Sargsyan");
        Armenia.addFigure("Prime Minister Hovik Abrahamyan");
        Armenia.addParlamenty("National Assembly");
        Armenia.setLegisType("Legislature:");
        base.add(Armenia);

        item Azerbaijan = new item();
        Azerbaijan.setCountry("Azerbaijan");
        Azerbaijan.setState("Unitary dominant-party semi-presidential republic");
        Azerbaijan.addFigure("President Ilham Aliyev");
        Azerbaijan.addFigure("Prime Minister Artur Rasizade");
        Azerbaijan.setLegisType("Legislature ?");
        Azerbaijan.addParlamenty("National Assembly");
        base.add(Azerbaijan);

        item China = new item();
        China.setCountry("China");
        China.addFigure("President and Party General Secretary Xi Jinping");
        China.addFigure("Prime Minister Li Keqiang");
        China.setLegisType("Legislature: ");
        China.setState("Unitary socialist one-party state");
        China.addParlamenty("National People's Congress");
        base.add(China);

        item Croatia = new item();
        Croatia.setCountry("Croatia");
        Croatia.addFigure("President Kolinda Grabar-Kitarović");
        Croatia.addFigure("Prime Minister Tihomir Oreśković");
        Croatia.setLegisType("Legislature: ");
        Croatia.setState("Unitary parliamentary constitutional republic");
        Croatia.addParlamenty("Sabor");
        base.add(Croatia);

        item Czech = new item();
        Czech.setCountry("Czech Republic");
        Czech.addFigure("President Milos Zeman");
        Czech.addFigure("Prime Minister Bohuslav Sobotka");
        Czech.setLegisType("Parliament: ");
        Czech.setState("Unitary parliamentary constitutional republic");
        Czech.addParlamenty("Upper house Senate");
        Czech.addParlamenty("Lower house Chamber of Deputies");
        base.add(Czech);

        item Egypt = new item();
        Egypt.setCountry("Egypt");
        Egypt.addFigure("President Abdel Fattah el-Sisi");
        Egypt.addFigure("Prime Minister Sherif Ismail");
        Egypt.setLegisType("Legislature: ");
        Egypt.setState("Unitary semi-presidential republic");
        Egypt.addParlamenty("House of Representatives");
        base.add(Egypt);

        item France = new item();
        France.setCountry("France");
        France.addFigure("President Francois Hollande");
        France.addFigure("Prime Minister Manuel Valls");
        France.addFigure("President of the Senate Gerard Larcher");
        France.addFigure("President of the National Assembly Claude Bartolone");
        France.setLegisType("Parliament: ");
        France.setState("Unitary semi parliamentary constitutional republic");
        France.addParlamenty("Upper house Senate");
        France.addParlamenty("Lower house National Assembly");
        base.add(France);

        item Georgia = new item();
        Georgia.setCountry("Georgia");
        Georgia.addFigure("President Giorgi Margvelashvili");
        Georgia.addFigure("Prime Minister Giorgi Kvirikashvili");
        Georgia.addFigure("Speaker of the Parliament David Usupashvili");
        Georgia.setLegisType("Parliament");
        Georgia.setState("Unitary semi-presidential republic");
        Georgia.addParlamenty("Parliament of Georgia");

        base.add(Georgia);

        item Germany = new item();
        Germany.setCountry("Germany");
        Germany.addFigure("President Joachim Gauck");
        Germany.addFigure("Chancellor Angela Merkel");
        Germany.addFigure("President of the Bundestag Norbert Lammert");
        Germany.addFigure("President of the Bundesrat Stanislaw Tillich");
        Germany.setLegisType("Legislature: ");
        Germany.setState("Federal parliamentary republic");
        Germany.addParlamenty("Upper house Bundesrat");
        Germany.addParlamenty("Lower house Bundestag");
        base.add(Germany);

        item Greece = new item();
        Greece.setCountry("Greece");
        Greece.addFigure("President Prokopis Pavlopoulos");
        Greece.addFigure("Prime Minister Alexis Tsipras");
        Greece.addFigure("Speaker of the Parliament Nikos Voutsis");
        Greece.setLegisType("Legislature");
        Greece.setState("Hellenic Republic");
        Greece.addParlamenty("Hellenic Parliament");

        base.add(Greece);
        item Hungary = new item();
        Hungary.setState("Unitary parliamentary constitutional republic");
        Hungary.setLegisType("Legislature:");
        Hungary.addFigure("President János Áder");
        Hungary.addFigure("Prime Minister Viktor Orbán");
        Hungary.addParlamenty("Országgyűlés");
        Hungary.setCountry("Hungary");
        base.add(Hungary);

        item Iran = new item();
        Iran.setState("Islamic Repubic");
        Iran.setLegisType("Legislature:");
        Iran.addFigure("President Hassan Rouhani");
        Iran.addFigure("Supreme Leader Ali Khamenei");
        Iran.addParlamenty("Islamic Consultative Assembly");
        Iran.setCountry("Iran");
        base.add(Iran);

        item Israel= new item();
        Israel.setState("Unitary parliamentary republic");
        Israel.setLegisType("Legislature:");
        Israel.addFigure("President Reuven Rivlin");
        Israel.addFigure("Prime Minister Benjamin Netanyahu");
        Israel.addParlamenty("Knesset");
        Israel.setCountry("Israel");
        base.add(Israel);

        item Macedonia= new item();
        Macedonia.setState("Parliamentary republic");
        Macedonia.setLegisType("Legislature:");
        Macedonia.addFigure("President Gjorge Ivanov");
        Macedonia.addFigure("Prime Minister Emil Dimitriev");
        Macedonia.addParlamenty("Assembly");
        Macedonia.setCountry("Macedonia");
        base.add(Macedonia);

        item Poland= new item();
        Poland.setState("Parliamentary republic");
        Poland.setLegisType("Legislature:");
        Poland.addFigure("President Andrzej Duda");
        Poland.addFigure("Prime Minister Beata Szydło");
        Poland.addParlamenty("Upper House Senate");
        Poland.addParlamenty("Lower House Sejm");
        Poland.setCountry("Poland");
        base.add(Poland);

        item Russia= new item();
        Russia.setState("Federal semi - Presidential constitutional republic");
        Russia.setLegisType("Legislature:");
        Russia.addFigure("President Vladimir Putin");
        Russia.addFigure("Prime Minister Dmitry Medvedev");
        Russia.addParlamenty("Upper House Federation Council");
        Russia.addParlamenty("Lower House State Duma");
        Russia.setCountry("Russia");
        base.add(Russia);

        item Serbia= new item();
        Serbia.setState("Unitary parliamentary constitutional republic");
        Serbia.setLegisType("Legislature:");
        Serbia.addFigure("President Tomislav Nikolić");
        Serbia.addFigure("Prime Minister Aleksandar Vučić");
        Serbia.addFigure("Assembly President Maja Gojković");
        Serbia.addParlamenty("National Assembly");
        Serbia.setCountry("Serbia");
        base.add(Serbia);

        item Slovakia= new item();
        Slovakia.setState("Unitary parliamentary constitutional republic");
        Slovakia.setLegisType("Legislature:");
        Slovakia.addFigure("President Andrej Kiska");
        Slovakia.addFigure("Prime Minister Robert Fico");
        Slovakia.addParlamenty("National Council");
        Slovakia.setCountry("Slovakia");
        base.add(Slovakia);

        item Syria= new item();
        Syria.setState("Unitary dominant - party semi-presidential republic");
        Syria.setLegisType("Legislature:");
        Syria.addFigure("President Bashar al-Assad");
        Syria.addFigure("Prime Minister Wael Nader al-Halqi");
        Syria.addFigure("Speaker of the People's Council Mohammad Jihad al-Laham");
        Syria.addParlamenty("People's Council");
        Syria.setCountry("Syria");
        base.add(Syria);

        item Turkey= new item();
        Turkey.setState("Unitary parliamentary constitutional republic");
        Turkey.setLegisType("Legislature:");
        Turkey.addFigure("President Recep Tayyip Erdoğan");
        Turkey.addFigure("Prime Minister Binali Yıldırım");
        Turkey.addParlamenty("Grand National Assembly");
        Turkey.setCountry("Turkey");
        base.add(Turkey);

        item Ukraine= new item();
        Ukraine.setState("Unitary semi-presidential constitutional republic");
        Ukraine.setLegisType("Legislature:");
        Ukraine.addFigure("President Petro Poroshenko");
        Ukraine.addFigure("Prime Minister Volodymyr Groysman");
        Ukraine.addFigure("Chairman of Parliament Andriy Parubiy");
        Ukraine.addParlamenty("Verkhovna Rada");
        Ukraine.setCountry("Ukraine");
        base.add(Ukraine);

        item USA= new item();
        USA.setState("Federal presidential constitutional republic");
        USA.setLegisType("Congress:");
        USA.addFigure("President Barack Obama");
        USA.addFigure("Vice President Joe Biden");
        USA.addFigure("Speaker of the house Paul Ryan");
        USA.addParlamenty("Upper House Senate");
        USA.addParlamenty("Lower House of Representatives");

        USA.setCountry("USA");
        base.add(USA);

    }
    public ArrayList<item> getBase(){
        return base;
    }







}
