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
        filereaderTest(inputlistOxygen);

        ArrayList<String> inputlistScrubber = new ArrayList<String>();
        filereaderTest(inputlistScrubber);

        String oxygen = "";
        String scrubber = "";

        int charMax = 5;

        for (int charIndexOx = 0; charIndexOx < charMax; charIndexOx++) {
            int comparisonOxygen1 = 0;
            int comparisonOxygen0 = 0;


            for (int i = 0; i < inputlistOxygen.size(); i++) {

                String binairyNumber = inputlistOxygen.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndexOx))) > 0) {
                    comparisonOxygen1++;
                } else {
                    comparisonOxygen0++;
                }
            }

            if (comparisonOxygen1 > comparisonOxygen0 || comparisonOxygen1 == comparisonOxygen0) {
                oxygen = oxygen + "1";
            } else {
                oxygen = oxygen + "0";
            }

            if (comparisonOxygen1 > comparisonOxygen0 || comparisonOxygen1 == comparisonOxygen0) {
                    for (String binairyNumber : inputlistOxygen) {
                        if (binairyNumber.charAt(charIndexOx) == 0) {
                            inputlistOxygen.remove(binairyNumber);
                        }
                    }
            } else {
                for (String binairyNumber : inputlistOxygen) {
                    if (binairyNumber.charAt(charIndexOx) == 1){
                        inputlistOxygen.remove(binairyNumber);
                    }
                }
            }

        }

        for (int charIndexSc = 0; charIndexSc < charMax; charIndexSc++) {

            int comparisonScrubber1 = 0;
            int comparisonScrubber0 = 0;
            
            for (int i = 0; i < inputlistScrubber.size(); i++) {

                String binairyNumber = inputlistScrubber.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndexSc))) > 0) {
                    comparisonScrubber1++;
                } else {
                    comparisonScrubber0++;
                }
            }

            if (comparisonScrubber1 > comparisonScrubber0 || comparisonScrubber1 == comparisonScrubber0) {
                scrubber = scrubber + "0";
            } else {
                scrubber = scrubber + "1";
            }

            if (comparisonScrubber1 > comparisonScrubber0 || comparisonScrubber1 == comparisonScrubber0) {
                for (String binairyNumber : inputlistScrubber) {
                    if (binairyNumber.charAt(charIndexSc) == 0) {
                        inputlistScrubber.remove(binairyNumber);
                    }
                }
            } else {
                for (String binairyNumber : inputlistScrubber) {
                    if (binairyNumber.charAt(charIndexSc) == 1){
                        inputlistScrubber.remove(binairyNumber);
                    }
                }
            }
        }

        int actualOxygen = Integer.parseInt(oxygen, 2);
        int actualScrubber = Integer.parseInt(scrubber, 2);
        int answer = actualScrubber * actualOxygen;

        System.out.println(answer);
        System.out.println(oxygen);
        System.out.println(scrubber);
    }

    public static void calculationPart2(){

        ArrayList<String> inputlist = new ArrayList<String>();

        filereader(inputlist);

        String oxygen = "";

        int charMax = 12;
        int comparison1 = 0;
        int comparison0 = 0;

        for (int charIndex = 0; charIndex < charMax; charIndex++) {

            for (int i = 0; i < inputlist.size(); i++) {

                String binairyNumber = inputlist.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndex))) > 0) {
                    comparison1++;
                } else {
                    comparison0++;
                }
            }

            if (comparison1 >= comparison0) {
                oxygen = oxygen + "1";
            } else {
                oxygen = oxygen + "0";
            }

            for(int i = 0; i < inputlist.size(); i++) {
                if (comparison1 > comparison0){
                    if(inputlist.get(i).charAt(charIndex) == 0){
                        inputlist.remove(i);
                    }
                } else if (comparison1 < comparison0){
                    if(inputlist.get(i).charAt(charIndex) == 1){
                        inputlist.remove(i);
                    }
                    else if (comparison1 == comparison0){
                        if(inputlist.get(i).charAt(charIndex) == 0){
                            inputlist.remove(i);
                        }
                    }
                }
            }
        }

        ArrayList<String> inputlist2 = new ArrayList<String>();

        filereader(inputlist2);

        String scrubber = "";

        charMax = 12;
        comparison1 = 0;
        comparison0 = 0;

        for (int charIndex = 0; charIndex < charMax; charIndex++) {

            for (int i = 0; i < inputlist.size(); i++) {

                String binairyNumber = inputlist.get(i);

                if (Integer.parseInt(Character.toString(binairyNumber.charAt(charIndex))) > 0) {
                    comparison1++;
                } else {
                    comparison0++;
                }
            }

            if (comparison1 >= comparison0) {
                scrubber = scrubber + "1";
            } else {
                scrubber = scrubber + "0";
            }

            for(int i = 0; i < inputlist.size(); i++) {
                if (comparison1 > comparison0){
                    if(inputlist.get(i).charAt(charIndex) == 1){
                        inputlist.remove(i);
                    }
                } else if (comparison1 < comparison0){
                    if(inputlist.get(i).charAt(charIndex) == 0){
                        inputlist.remove(i);
                    }
                    else if (comparison1 == comparison0){
                        if(inputlist.get(i).charAt(charIndex) == 1){
                            inputlist.remove(i);
                        }
                    }
                }
            }
        }

        int actualOxygen = Integer.parseInt(oxygen, 2);
        int actualScrubber = Integer.parseInt(scrubber,2);

        int answer = actualScrubber*actualOxygen;

        System.out.println(answer);
        System.out.println(oxygen);
        System.out.println(scrubber);
    }
}
