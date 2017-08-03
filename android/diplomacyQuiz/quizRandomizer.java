package com.example.pionek.diplomacypls;

public class quizRandomizer {

    int[] values;
    int[] values1;

    public void getRandom(int _max) {

        values = new int[_max];
        values[0] = (int) (Math.random() * _max);
        //LOG BEFORE GETTING RANDOMS
        boolean match_found = true;
        //I WANT TO FIND PERMUTATIONS WITHOUT REPETITION, SO FOR EACH ELEMENT:
        for (int i = 1; i < _max; i++) {
            //WHILE THERE IS NO MATCH
            while (match_found) {
                match_found = false; //initial loop setup
                //GET A RANDOM VALUE:
                values[i] = (int) (Math.random() *_max);
                //CHECK IF IT IS NOT YET PRESENT IN THE ARRAY
                for (int j = 0; j < i; j++) {
                    System.out.println(values[j]);
                    if (values[j] == values[i]) {
                        match_found = true;
                    }
                    //IF NOT PRESENT - match_found is false, therefore our work here is done !
                }
            }
        }
    }


    public void gr() {
        values1 = new int[3];
        values1[0] = (int) (Math.random() * 2);
        for (int i = 1; i < values1.length; i++) {
            while (true) {
                values1[i] = (int) (Math.random() * 2);
                if (values1[i] != values1[i - 1]) {
                    break;
                }
            }
        }
    }
}
