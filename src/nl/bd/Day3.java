package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

    public static void filereader (ArrayList<String> inputlist) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputday3.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {

                inputlist.add(lineText);

            }


            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public static void calculation(){

        ArrayList<String> inputlist = new ArrayList<String>();

        filereader(inputlist);

        String gamma = "";

        int charMax = 12;

        for (int charIndex = 0; charIndex < charMax; charIndex++) {

            int comparison1 = 0;
            int comparison0 = 0;

            for (int i = 0; i < inputlist.size(); i++) {

                String binairyNumber = inputlist.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndex))) > 0) {
                    comparison1++;
                } else {
                    comparison0++;
                }
            }

            if (comparison1 > comparison0){
                gamma = gamma + "1";
            } else{
                gamma = gamma + "0";
            }
        }

        int actualGamma = Integer.parseInt(gamma, 2);

        String epsilon = gamma.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");

        int actualEpsilon = Integer.parseInt(epsilon,2);

        int answer = actualEpsilon*actualGamma;

        System.out.println(answer);
        System.out.println(gamma);
        System.out.println(epsilon);


    }


}
