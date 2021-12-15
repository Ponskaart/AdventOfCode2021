package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {
    public static class bingoCardLine{

        private String number1;
        private String number2;
        private String number3;
        private String number4;
        private String number5;

        bingoCardLine(String number1, String number2, String number3, String number4, String number5){
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
            this.number4 = number4;
            this.number5 = number5;
            /*constructor maken
             * voor regels met ieder losse nummer variabelen en kolommen met ieder losse nummer variabelen van de bingokaart*/
        }

        public String getNumber1() {
            return number1;
        }

        public void setNumber1(String number1) {
            this.number1 = number1;
        }

        public String getNumber2() {
            return number2;
        }

        public void setNumber2(String number2) {
            this.number2 = number2;
        }

        public String getNumber3() {
            return number3;
        }

        public void setNumber3(String number3) {
            this.number3 = number3;
        }

        public String getNumber4() {
            return number4;
        }

        public void setNumber4(String number4) {
            this.number4 = number4;
        }

        public String getNumber5() {
            return number5;
        }

        public void setNumber5(String number5) {
            this.number5 = number5;
        }
    }

    public static class bingoCardColumn{

        private String number1;
        private String number2;
        private String number3;
        private String number4;
        private String number5;

        bingoCardColumn(String number1, String number2, String number3, String number4, String number5){
            this.number1 = number1;
            this.number2 = number2;
            this.number3 = number3;
            this.number4 = number4;
            this.number5 = number5;
            /*constructor maken
             * voor regels met ieder losse nummer variabelen en kolommen met ieder losse nummer variabelen van de bingokaart*/
        }

        public String getNumber1() {
            return number1;
        }

        public void setNumber1(String number1) {
            this.number1 = number1;
        }

        public String getNumber2() {
            return number2;
        }

        public void setNumber2(String number2) {
            this.number2 = number2;
        }

        public String getNumber3() {
            return number3;
        }

        public void setNumber3(String number3) {
            this.number3 = number3;
        }

        public String getNumber4() {
            return number4;
        }

        public void setNumber4(String number4) {
            this.number4 = number4;
        }

        public String getNumber5() {
            return number5;
        }

        public void setNumber5(String number5) {
            this.number5 = number5;
        }
    }

    public static void filereaderCards (ArrayList<bingoCardLine> lineArray) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4CardsTest.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
                String[] line = lineText.trim().split("\\s+" );
                lineArray.add(new bingoCardLine(line[0],line[1],line[2],line[3],line[4]));

                /* alleen de totaalsom van de nummers van de winnende regel of colom is interessant, dus alle rijen en kolommen in een array stoppen en dan vergelijken
                * voor kolommen is het een for loop, met index start op 0, als index < bingoCardLine.size(), index +5. Want kaart is 5x5
                * en dan die weerin een for loop waarbij we index van 0 naar 4 laten gaan, want index arraylist begint met 0, deze index start waarde laten zijn van bovenstaande forloop
                * zo garandeer je dat je alle kolommen toevoegd. */
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

//    if (catch Monster squid == true){
//        System.out.println("yossssss, we win")
//    } else {
//        play.sound("darksoulsdeathmusic.mp3");
//        System.out.println("you died");
//    }

    public static void filereaderEntries (ArrayList<String> numbersToBeDrawn) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4EntriesTest.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
                String[] line = lineText.split("," );
                numbersToBeDrawn.addAll(List.of(line));
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public static void printResultLine (ArrayList <bingoCardLine> lineArray, int j) {

        System.out.println(lineArray.get(j).getNumber1() + " " + lineArray.get(j).getNumber2() + " "
                + lineArray.get(j).getNumber3() +" "+ lineArray.get(j).getNumber3() +" "
                + lineArray.get(j).getNumber4());
    }

    public static void printResultColumn (ArrayList <bingoCardColumn> columnArray, int j) {

        System.out.println(columnArray.get(j).getNumber1() + " " + columnArray.get(j).getNumber2() + " "
                + columnArray.get(j).getNumber3() +" "+ columnArray.get(j).getNumber3() +" "
                + columnArray.get(j).getNumber4());
    }

    public static void calculation(){
        ArrayList <bingoCardLine> lineArray = new ArrayList<bingoCardLine>();
        ArrayList <bingoCardColumn> columnArray = new ArrayList<bingoCardColumn>();
        ArrayList <String> numbersToBeDrawn = new ArrayList<>();
        ArrayList <String> drawnNumbers = new ArrayList<>();

        filereaderCards (lineArray);
        filereaderEntries (numbersToBeDrawn);
        String numbers = "";

        int startingPointIndex = 0;
        int endpointIndex = 5;
        int counterLoopsTotal = 0;

        while (counterLoopsTotal < 15){
                if(counterLoopsTotal == 0 || counterLoopsTotal == 1 || counterLoopsTotal == 2) {
                    if (counterLoopsTotal == 0) {
                        startingPointIndex = 0;
                        endpointIndex = 5;
                    } else if (counterLoopsTotal == 1){
                        startingPointIndex = 5;
                        endpointIndex = 10;
                    } else if (counterLoopsTotal == 2){
                        startingPointIndex = 10;
                        endpointIndex = 15;
                    }
                    for (int i = startingPointIndex ; i < endpointIndex; i++) {
                        numbers = numbers + lineArray.get(i).getNumber1() + (" ");
                    }
                    String[] line = numbers.trim().split(" ");
                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                    counterLoopsTotal++;
                    numbers = "";

                } else if (counterLoopsTotal == 3 || counterLoopsTotal == 4 || counterLoopsTotal == 5) {
                    if (counterLoopsTotal == 3) {
                        startingPointIndex = 0;
                        endpointIndex = 5;
                    } else if (counterLoopsTotal == 4){
                        startingPointIndex = 5;
                        endpointIndex = 10;
                    } else if (counterLoopsTotal == 5){
                        startingPointIndex = 10;
                        endpointIndex = 15;
                    }
                    for (int i = startingPointIndex ; i < endpointIndex; i++) {
                        numbers = numbers + lineArray.get(i).getNumber2() + (" ");
                    }
                    String[] line = numbers.trim().split(" ");
                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                    counterLoopsTotal++;
                    numbers = "";

                } else if (counterLoopsTotal == 6 || counterLoopsTotal == 7 || counterLoopsTotal == 8) {
                    if (counterLoopsTotal == 6) {
                        startingPointIndex = 0;
                        endpointIndex = 5;
                    } else if (counterLoopsTotal == 7){
                        startingPointIndex = 5;
                        endpointIndex = 10;
                    } else if (counterLoopsTotal == 8){
                        startingPointIndex = 10;
                        endpointIndex = 15;
                    }
                    for (int i = startingPointIndex ; i < endpointIndex; i++) {
                        numbers = numbers + lineArray.get(i).getNumber3() + (" ");
                    }
                    String[] line = numbers.trim().split(" ");
                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                    counterLoopsTotal++;
                    numbers = "";

                } else if (counterLoopsTotal == 9 || counterLoopsTotal == 10 || counterLoopsTotal == 11) {
                    if (counterLoopsTotal == 9) {
                        startingPointIndex = 0;
                        endpointIndex = 5;
                    } else if (counterLoopsTotal == 10){
                        startingPointIndex = 5;
                        endpointIndex = 10;
                    } else if (counterLoopsTotal == 11){
                        startingPointIndex = 10;
                        endpointIndex = 15;
                    }
                    for (int i = startingPointIndex ; i < endpointIndex; i++) {
                        numbers = numbers + lineArray.get(i).getNumber4() + (" ");
                    }
                    String[] line = numbers.trim().split(" ");
                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                    counterLoopsTotal++;
                    numbers = "";

                } else {
                    if (counterLoopsTotal == 12) {
                        startingPointIndex = 0;
                        endpointIndex = 5;
                    } else if (counterLoopsTotal == 13){
                        startingPointIndex = 5;
                        endpointIndex = 10;
                    } else if (counterLoopsTotal == 14){
                        startingPointIndex = 10;
                        endpointIndex = 15;
                    }
                    for (int i = startingPointIndex ; i < endpointIndex; i++) {
                        numbers = numbers + lineArray.get(i).getNumber5() + (" ");
                    }
                    String[] line = numbers.trim().split(" ");
                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                    counterLoopsTotal++;
                    numbers = "";
                }
        }

//        for (bingoCardColumn bingoCardColumn : columnArray) {
//            System.out.println(bingoCardColumn.getNumber1() + ", " + bingoCardColumn.getNumber2() + ", "
//                    + bingoCardColumn.getNumber3() + ", " + bingoCardColumn.getNumber4() + ", "
//                    + bingoCardColumn.getNumber5());
//        }

        boolean result = false;

        while(result = false) {
            for (int i = 0; i < numbersToBeDrawn.size(); i++) {
                String drawnNumber = numbersToBeDrawn.get(i);
                drawnNumbers.add(drawnNumber);

                for (int j = 0; j < lineArray.size(); j++){
                    if (drawnNumbers.contains(lineArray.get(j).getNumber1())
                            && drawnNumbers.contains(lineArray.get(j).getNumber2())
                            && drawnNumbers.contains(lineArray.get(j).getNumber3())
                            && drawnNumbers.contains(lineArray.get(j).getNumber4())
                            && drawnNumbers.contains(lineArray.get(j).getNumber5())) {
                        printResultLine(lineArray, j);
                        result = true;
                    } else if (drawnNumbers.contains(columnArray.get(j).getNumber1())
                            && drawnNumbers.contains(columnArray.get(j).getNumber2())
                            && drawnNumbers.contains(columnArray.get(j).getNumber3())
                            && drawnNumbers.contains(columnArray.get(j).getNumber4())
                            && drawnNumbers.contains(columnArray.get(j).getNumber5())) {
                        System.out.println(columnArray.get(j));
                        printResultColumn(columnArray, j);
                        result = true;
                    } else {
                        System.out.println("no match found");
                    }
                }
            }
        }
    }
}


    /*getrokken bingonummers in andere array voegen en iedere keer vergelijken of de bingoCardLine (for each, contains(getrokken bingonummers)
    * dit alles in een if else statement, dat als .contains true */



    /*Als Arraylist met getrokken nummers contains alle items uit een regel of kolom, dan bingo*/

    /*som regel of kolom * laatste entry uit de getrokken nummers = antwoord*/


//        for (bingoCardLine bingoCardLine : lineArray) {
//            System.out.println(bingoCardLine.getNumber1() + ", " + bingoCardLine.getNumber2() + ", "
//                    + bingoCardLine.getNumber3() + ", " + bingoCardLine.getNumber4() + ", "
//                    + bingoCardLine.getNumber5());
//             }

//        for (startingPointIndex = 0; startingPointIndex < 5; startingPointIndex++) {
//            endpointIndex = startingPointIndex * 5;




//        for (int counterLoopsTotal = 0; counterLoopsTotal < 3; counterLoopsTotal++) {
//            System.out.println(counterLoopsTotal);
//            if(counterLoopsTotal == 0) {
//                for (int i = 0 ; i < 5; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber1() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//
//                numbers = "";
//
//                System.out.println("counter = " + counterLoopsTotal);
//
//            } else if (counterLoopsTotal == 1) {
//                for (int i = 5 ; i < 10; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber1() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//
//                numbers = "";
//
//                System.out.println("counter = " + counterLoopsTotal);
//
//            } else if (counterLoopsTotal == 2) {
//                for (int i = 10; i < 15; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber1() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//
//                numbers = "";
//
//                System.out.println("counter = " + counterLoopsTotal);
//            }
//
//            } else if (counterLoopsTotal == 9 || counterLoopsTotal == 10 || counterLoopsTotal == 11) {
//                if (counterLoopsTotal == 9) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 10){
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 11){
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex ; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber4() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//
//            } else {
//                if (counterLoopsTotal == 12) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 13){
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 14){
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex ; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber5() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//            }
//
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));

//            counterLoopsTotal++;




//        }
