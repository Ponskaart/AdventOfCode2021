package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

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

    public static void filereaderTest (ArrayList<String> inputlist) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputday3test.txt"));
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

    /*Day 3 part 2*/

    public static void calculationPart2Test() {
        ArrayList<String> inputlistOxygen = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();

        filereader(inputlistOxygen);

        int charMax = 12;

            for (int charIndex = 0; charIndex < charMax; charIndex++) {
                int comparisonOxygen1 = 0;
                int comparisonOxygen0 = 0;
                int comparisonMax;

//                if (charIndex == 5 && inputlistOxygen.size() == 1){
//                   System.out.println(inputlistOxygen);
//                   break;
//                }

                for (int i = 0; i < inputlistOxygen.size(); i++) {
                    String binairyNumber = inputlistOxygen.get(i);

                    if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndex))) > 0) {
                        comparisonOxygen1++;
                    } else {
                        comparisonOxygen0++;
                    }
                }

                if (comparisonOxygen1 > comparisonOxygen0) {
                    comparisonMax = 1;
                } else if (comparisonOxygen1 < comparisonOxygen0){
                    comparisonMax = 0;
                } else {
                    comparisonMax = 1;
                }



                if (comparisonMax == 1) {

                    for (int i = 0; i < inputlistOxygen.size(); i++){
                        String number = inputlistOxygen.get(i);
                        if (Character.getNumericValue(number.charAt(charIndex)) == 1) {
                            temp.add(number);
                        }
                    }

                    inputlistOxygen.clear();
                    inputlistOxygen.addAll(temp);
                    temp.clear();

                }

                if(comparisonMax == 0){
                    for (int i = 0; i < inputlistOxygen.size(); i++) {
                        String number = inputlistOxygen.get(i);
                        if (Character.getNumericValue(number.charAt(charIndex)) == 0) {
                            temp.add(number);
                        }
                    }
                    inputlistOxygen.clear();
                    inputlistOxygen.addAll(temp);
                    temp.clear();

                }

                if(inputlistOxygen.size() == 1){
                    break;
                }

            }

        String oxygen = inputlistOxygen.get(0);

            inputlistOxygen.clear();
            temp.clear();
        filereader(inputlistOxygen);

        for (int charIndex = 0; charIndex < charMax; charIndex++) {
            int comparisonOxygen1 = 0;
            int comparisonOxygen0 = 0;
            int comparisonMax;

//                if (charIndex == 5 && inputlistOxygen.size() == 1){
//                   System.out.println(inputlistOxygen);
//                   break;
//                }

            for (int i = 0; i < inputlistOxygen.size(); i++) {
                String binairyNumber = inputlistOxygen.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndex))) > 0) {
                    comparisonOxygen1++;
                } else {
                    comparisonOxygen0++;
                }
            }

            if (comparisonOxygen1 > comparisonOxygen0) {
                comparisonMax = 0;
            } else if (comparisonOxygen1 < comparisonOxygen0){
                comparisonMax = 1;
            } else {
                comparisonMax = 0;
            }



            if (comparisonMax == 1) {

                for (int i = 0; i < inputlistOxygen.size(); i++){
                    String number = inputlistOxygen.get(i);
                    if (Character.getNumericValue(number.charAt(charIndex)) == 1) {
                        temp.add(number);
                    }
                }

                inputlistOxygen.clear();
                inputlistOxygen.addAll(temp);
                temp.clear();

            }

            if(comparisonMax == 0){
                for (int i = 0; i < inputlistOxygen.size(); i++) {
                    String number = inputlistOxygen.get(i);
                    if (Character.getNumericValue(number.charAt(charIndex)) == 0) {
                        temp.add(number);
                    }
                }
                inputlistOxygen.clear();
                inputlistOxygen.addAll(temp);
                temp.clear();

            }

            if(inputlistOxygen.size() == 1){
                break;
            }

        }
        String scrubber = inputlistOxygen.get(0);
        int answer = Integer.parseInt(oxygen, 2) * Integer.parseInt(scrubber, 2);
        System.out.println(answer);
    }

    }
