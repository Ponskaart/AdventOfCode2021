package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {

    public static void filereaderCards (ArrayList<int[][]> bingoCardArray, ArrayList<String> lineNumbers) {

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4CardsTest.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
                lineNumbers.add(lineText);
            }

            for (int totalCards = 0; totalCards < 3; totalCards++) {
                int[][] bingoCard = new int[5][5];

                for (int i = 0; i < 5; i++) {
                    String[] lineNumber = lineNumbers.get(i+(5*totalCards)).trim().split("\\s+");

                    for (int j = 0; j < 5; j++) {

                        bingoCard[i][j] = Integer.parseInt(lineNumber[j]);
                    }
                }

                bingoCardArray.add(bingoCard);
            }

            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

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

    public static void calculation() {

        ArrayList<String> numbersToBeDrawn = new ArrayList<>();
        ArrayList<String> drawnNumbers = new ArrayList<>();
        ArrayList<int[][]> bingoCardArray = new ArrayList<>();
        ArrayList<String> lineNumbers = new ArrayList<>();

            filereaderCards(bingoCardArray, lineNumbers);

            for(int i = 0; i < 3; i++){

                for(int j = 0; j<5; j++)
                {
                    for(int k = 0; k<5; k++)
                    {
                        System.out.print(bingoCardArray.get(i)[j][k] + ",");
                    }
                    System.out.println("");
                }
            }










        /*2d arraylist maken en in arraylist stoppen met 2d arraylists*/





    }
}








































//    public static class bingoCardLine{
//
//        private String number1;
//        private String number2;
//        private String number3;
//        private String number4;
//        private String number5;
//
//        bingoCardLine(String number1, String number2, String number3, String number4, String number5){
//            this.number1 = number1;
//            this.number2 = number2;
//            this.number3 = number3;
//            this.number4 = number4;
//            this.number5 = number5;
//            /*constructor maken
//             * voor regels met ieder losse nummer variabelen en kolommen met ieder losse nummer variabelen van de bingokaart*/
//        }
//
//        public String getNumber1() {
//            return number1;
//        }
//
//        public void setNumber1(String number1) {
//            this.number1 = number1;
//        }
//
//        public String getNumber2() {
//            return number2;
//        }
//
//        public void setNumber2(String number2) {
//            this.number2 = number2;
//        }
//
//        public String getNumber3() {
//            return number3;
//        }
//
//        public void setNumber3(String number3) {
//            this.number3 = number3;
//        }
//
//        public String getNumber4() {
//            return number4;
//        }
//
//        public void setNumber4(String number4) {
//            this.number4 = number4;
//        }
//
//        public String getNumber5() {
//            return number5;
//        }
//
//        public void setNumber5(String number5) {
//            this.number5 = number5;
//        }
//    }
//
//    public static class bingoCardColumn{
//
//        private String number1;
//        private String number2;
//        private String number3;
//        private String number4;
//        private String number5;
//
//        bingoCardColumn(String number1, String number2, String number3, String number4, String number5){
//            this.number1 = number1;
//            this.number2 = number2;
//            this.number3 = number3;
//            this.number4 = number4;
//            this.number5 = number5;
//            /*constructor maken
//             * voor regels met ieder losse nummer variabelen en kolommen met ieder losse nummer variabelen van de bingokaart*/
//        }
//
//        public String getNumber1() {
//            return number1;
//        }
//
//        public void setNumber1(String number1) {
//            this.number1 = number1;
//        }
//
//        public String getNumber2() {
//            return number2;
//        }
//
//        public void setNumber2(String number2) {
//            this.number2 = number2;
//        }
//
//        public String getNumber3() {
//            return number3;
//        }
//
//        public void setNumber3(String number3) {
//            this.number3 = number3;
//        }
//
//        public String getNumber4() {
//            return number4;
//        }
//
//        public void setNumber4(String number4) {
//            this.number4 = number4;
//        }
//
//        public String getNumber5() {
//            return number5;
//        }
//
//        public void setNumber5(String number5) {
//            this.number5 = number5;
//        }
//    }
//
//    public static class fullCardLine{
//
//        private bingoCardLine line1;
//        private bingoCardLine line2;
//        private bingoCardLine line3;
//        private bingoCardLine line4;
//        private bingoCardLine line5;
//
//        fullCardLine(bingoCardLine line1, bingoCardLine line2, bingoCardLine line3, bingoCardLine line4,
//                     bingoCardLine line5){
//            this.line1 = line1;
//            this.line2 = line2;
//            this.line3 = line3;
//            this.line4 = line4;
//            this.line5 = line5;
//        }
//
//        public bingoCardLine getLine1() {
//            return line1;
//        }
//
//        public void setLine1(bingoCardLine line1) {
//            this.line1 = line1;
//        }
//
//        public bingoCardLine getLine2() {
//            return line2;
//        }
//
//        public void setLine2(bingoCardLine line2) {
//            this.line2 = line2;
//        }
//
//        public bingoCardLine getLine3() {
//            return line3;
//        }
//
//        public void setLine3(bingoCardLine line3) {
//            this.line3 = line3;
//        }
//
//        public bingoCardLine getLine4() {
//            return line4;
//        }
//
//        public void setLine4(bingoCardLine line4) {
//            this.line4 = line4;
//        }
//
//        public bingoCardLine getLine5() {
//            return line5;
//        }
//
//        public void setLine5(bingoCardLine line5) {
//            this.line5 = line5;
//        }
//    }
//
//    public static class fullCardColumn{
//
//        private bingoCardColumn line1;
//        private bingoCardColumn line2;
//        private bingoCardColumn line3;
//        private bingoCardColumn line4;
//        private bingoCardColumn line5;
//
//        fullCardColumn(bingoCardColumn line1, bingoCardColumn line2, bingoCardColumn line3, bingoCardColumn line4,
//                       bingoCardColumn line5){
//            this.line1 = line1;
//            this.line2 = line2;
//            this.line3 = line3;
//            this.line4 = line4;
//            this.line5 = line5;
//        }
//
//        public bingoCardColumn getLine1() {
//            return line1;
//        }
//
//        public void setLine1(bingoCardColumn line1) {
//            this.line1 = line1;
//        }
//
//        public bingoCardColumn getLine2() {
//            return line2;
//        }
//
//        public void setLine2(bingoCardColumn line2) {
//            this.line2 = line2;
//        }
//
//        public bingoCardColumn getLine3() {
//            return line3;
//        }
//
//        public void setLine3(bingoCardColumn line3) {
//            this.line3 = line3;
//        }
//
//        public bingoCardColumn getLine4() {
//            return line4;
//        }
//
//        public void setLine4(bingoCardColumn line4) {
//            this.line4 = line4;
//        }
//
//        public bingoCardColumn getLine5() {
//            return line5;
//        }
//
//        public void setLine5(bingoCardColumn line5) {
//            this.line5 = line5;
//        }
//    }
//
//    public static void filereaderCards (ArrayList<bingoCardLine> lineArray) {
//        try {
//            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4CardsTest.txt"));
//            String lineText;
//
//            while ((lineText = fileReader.readLine()) != null) {
//                String[] line = lineText.trim().split("\\s+" );
//                lineArray.add(new bingoCardLine(line[0],line[1],line[2],line[3],line[4]));
//
//                /* alleen de totaalsom van de nummers van de winnende regel of colom is interessant, dus alle rijen en kolommen in een array stoppen en dan vergelijken
//                * voor kolommen is het een for loop, met index start op 0, als index < bingoCardLine.size(), index +5. Want kaart is 5x5
//                * en dan die weerin een for loop waarbij we index van 0 naar 4 laten gaan, want index arraylist begint met 0, deze index start waarde laten zijn van bovenstaande forloop
//                * zo garandeer je dat je alle kolommen toevoegd. */
//            }
//            fileReader.close();
//        } catch (IOException e) {
//            System.out.println("File Read Error");
//        }
//    }
//
////    if (catch Monster squid == true){
////        System.out.println("yossssss, we win")
////    } else {
////        play.sound("darksoulsdeathmusic.mp3");
////        System.out.println("you died");
////    }
//
//    public static void filereaderEntries (ArrayList<String> numbersToBeDrawn) {
//        try {
//            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4EntriesTest.txt"));
//            String lineText;
//
//            while ((lineText = fileReader.readLine()) != null) {
//                String[] line = lineText.split("," );
//                numbersToBeDrawn.addAll(List.of(line));
//            }
//            fileReader.close();
//        } catch (IOException e) {
//            System.out.println("File Read Error");
//        }
//    }
//
//    public static void printResultLine (ArrayList <bingoCardLine> lineArray, int j) {
//
//        System.out.println("The winning bingo line is: " + lineArray.get(j).getNumber1() + " " + lineArray.get(j).getNumber2() + " "
//                + lineArray.get(j).getNumber3() +" "+ lineArray.get(j).getNumber4() +" "
//                + lineArray.get(j).getNumber5());
//    }
//
//    public static void printResultColumn (ArrayList <bingoCardColumn> columnArray, int j) {
//
//        System.out.println("The winning bingo column is: " + columnArray.get(j).getNumber1() + " " + columnArray.get(j).getNumber2() + " "
//                + columnArray.get(j).getNumber3() +" "+ columnArray.get(j).getNumber4() +" "
//                + columnArray.get(j).getNumber5());
//    }
//
//    public static void calculation() {
//        ArrayList<bingoCardLine> lineArray = new ArrayList<bingoCardLine>();
//        ArrayList<bingoCardColumn> columnArray = new ArrayList<bingoCardColumn>();
//        ArrayList<String> numbersToBeDrawn = new ArrayList<>();
//        ArrayList<String> drawnNumbers = new ArrayList<>();
//        ArrayList<fullCardLine> fullCardLine = new ArrayList<fullCardLine>();
//        ArrayList<fullCardColumn> fullCardColumn = new ArrayList<fullCardColumn>();
//
//        filereaderCards(lineArray);
//        filereaderEntries(numbersToBeDrawn);
//        String numbers = "";
//
//        int startingPointIndex = 0;
//        int endpointIndex = 5;
//
//        startingPointIndex = 0;
//        endpointIndex = 5;
//        int counterLoopsTotal = 0;
//
//        while (counterLoopsTotal < 15) {
//            if (counterLoopsTotal == 0 || counterLoopsTotal == 1 || counterLoopsTotal == 2) {
//                if (counterLoopsTotal == 0) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 1) {
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 2) {
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber1() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//                numbers = "";
//
//            } else if (counterLoopsTotal == 3 || counterLoopsTotal == 4 || counterLoopsTotal == 5) {
//                if (counterLoopsTotal == 3) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 4) {
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 5) {
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber2() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//                numbers = "";
//
//            } else if (counterLoopsTotal == 6 || counterLoopsTotal == 7 || counterLoopsTotal == 8) {
//                if (counterLoopsTotal == 6) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 7) {
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 8) {
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber3() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//                numbers = "";
//
//            } else if (counterLoopsTotal == 9 || counterLoopsTotal == 10 || counterLoopsTotal == 11) {
//                if (counterLoopsTotal == 9) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 10) {
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 11) {
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber4() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//                numbers = "";
//
//            } else {
//                if (counterLoopsTotal == 12) {
//                    startingPointIndex = 0;
//                    endpointIndex = 5;
//                } else if (counterLoopsTotal == 13) {
//                    startingPointIndex = 5;
//                    endpointIndex = 10;
//                } else if (counterLoopsTotal == 14) {
//                    startingPointIndex = 10;
//                    endpointIndex = 15;
//                }
//                for (int i = startingPointIndex; i < endpointIndex; i++) {
//                    numbers = numbers + lineArray.get(i).getNumber5() + (" ");
//                }
//                String[] line = numbers.trim().split(" ");
//                columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
//                counterLoopsTotal++;
//                numbers = "";
//            }
//        }
//
//        counterLoopsTotal = 0;
//
//        while (counterLoopsTotal < 3){
//            if (counterLoopsTotal == 0){
//                int i = 0;
//                fullCardLine.add(new fullCardLine(lineArray.get(i),lineArray.get(i + 1),lineArray.get(i + 2),lineArray.get(i + 3),lineArray.get(i + 4)));
//            } else if(counterLoopsTotal == 1){
//                int i = 5;
//                fullCardLine.add(new fullCardLine(lineArray.get(i),lineArray.get(i + 1),lineArray.get(i + 2),lineArray.get(i + 3),lineArray.get(i + 4)));
//            } else if (counterLoopsTotal == 2){
//
//                int i = 10;
//                fullCardLine.add(new fullCardLine(lineArray.get(i),lineArray.get(i + 1),lineArray.get(i + 2),lineArray.get(i + 3),lineArray.get(i + 4)));
//            }
//            counterLoopsTotal++;
//        }
//
//        counterLoopsTotal = 0;
//
//        while (counterLoopsTotal < 3){
//            if (counterLoopsTotal == 0){
//                int i = 0;
//                fullCardColumn.add(new fullCardColumn(columnArray.get(i),columnArray.get(i + 1),columnArray.get(i + 2),columnArray.get(i + 3),columnArray.get(i + 4)));
//            } else if(counterLoopsTotal == 1){
//                int i = 5;
//                fullCardColumn.add(new fullCardColumn(columnArray.get(i),columnArray.get(i + 1),columnArray.get(i + 2),columnArray.get(i + 3),columnArray.get(i + 4)));
//            } else if (counterLoopsTotal == 2){
//                int i = 10;
//                fullCardColumn.add(new fullCardColumn(columnArray.get(i),columnArray.get(i + 1),columnArray.get(i + 2),columnArray.get(i + 3),columnArray.get(i + 4)));
//            }
//            counterLoopsTotal++;
//        }
//
//        boolean proceed = true;
//        int result = 0;
//
//        while (proceed) {
//
//            for (int i = 0; i < numbersToBeDrawn.size(); i++) {
//                String drawnNumber = numbersToBeDrawn.get(i);
//                drawnNumbers.add(drawnNumber);
//
//                System.out.println(drawnNumber);
//
//                for (int j = 0; j < lineArray.size(); j++) {
//                    if (drawnNumbers.contains(lineArray.get(j).getNumber1())
//                            && drawnNumbers.contains(lineArray.get(j).getNumber2())
//                            && drawnNumbers.contains(lineArray.get(j).getNumber3())
//                            && drawnNumbers.contains(lineArray.get(j).getNumber4())
//                            && drawnNumbers.contains(lineArray.get(j).getNumber5())) {
//
//                        bingoCardLine winningLine = new bingoCardLine(lineArray.get(j).getNumber1(),
//                                lineArray.get(j).getNumber2(), lineArray.get(j).getNumber3(),
//                                lineArray.get(j).getNumber4(), lineArray.get(j).getNumber5());
//
//                        System.out.println(winningLine);
//
//                        int totalLinesSum = 0;
//                        int sumline1 = 0;
//                        int sumline2 = 0;
//                        int sumline3 = 0;
//                        int sumline4 = 0;
//                        int sumline5 = 0;
//                        int sumWinningLine = 0;
//
//                        for (int k = 0; k < fullCardLine.size(); k++) {
//                            if(fullCardLine.get(k).getLine1() == winningLine
//                                    || fullCardLine.get(k).getLine2() == winningLine
//                                    || fullCardLine.get(k).getLine3() == winningLine
//                                    || fullCardLine.get(k).getLine4() == winningLine
//                                    || fullCardLine.get(k).getLine5() == winningLine){
//
//                                System.out.println("test");
//
//                                sumline1 = Integer.parseInt(fullCardLine.get(k).getLine1().getNumber1()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine1().getNumber2()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine1().getNumber3()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine1().getNumber4()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine1().getNumber5());
//
//                                sumline2 = Integer.parseInt(fullCardLine.get(k).getLine1().getNumber1()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine2().getNumber2()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine2().getNumber3()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine2().getNumber4()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine2().getNumber5());
//
//                                sumline3 = Integer.parseInt(fullCardLine.get(k).getLine3().getNumber1()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine3().getNumber2()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine3().getNumber3()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine3().getNumber4()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine3().getNumber5());
//
//                                sumline4 = Integer.parseInt(fullCardLine.get(k).getLine4().getNumber1()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine4().getNumber2()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine4().getNumber3()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine4().getNumber4()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine4().getNumber5());
//
//                                sumline5 = Integer.parseInt(fullCardLine.get(k).getLine5().getNumber1()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine5().getNumber2()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine5().getNumber3()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine5().getNumber4()) +
//                                        Integer.parseInt(fullCardLine.get(k).getLine5().getNumber5());
//
//                                sumWinningLine = Integer.parseInt(winningLine.getNumber1()) +
//                                        Integer.parseInt(winningLine.getNumber2()) +
//                                        Integer.parseInt(winningLine.getNumber3()) +
//                                        Integer.parseInt(winningLine.getNumber4()) +
//                                        Integer.parseInt(winningLine.getNumber5());
//
//                                totalLinesSum = sumline1 + sumline2 + sumline3 + sumline4 + sumline5
//                                        - sumWinningLine;
//
//                                int totalResult = totalLinesSum * Integer.parseInt(numbersToBeDrawn.get(i));
//
//                                System.out.println(totalResult);
//
//                                break;
//
//                            }
//                        }
//
//                       printResultLine(lineArray, j);
//
//                        proceed = false;
//                        if (proceed == false) {
//                            break;
//                        }
//
//                    } else if (drawnNumbers.contains(columnArray.get(j).getNumber1())
//                            && drawnNumbers.contains(columnArray.get(j).getNumber2())
//                            && drawnNumbers.contains(columnArray.get(j).getNumber3())
//                            && drawnNumbers.contains(columnArray.get(j).getNumber4())
//                            && drawnNumbers.contains(columnArray.get(j).getNumber5())) {
//
//                        result = (Integer.parseInt(columnArray.get(j).getNumber1()) + Integer.parseInt(columnArray.get(j).getNumber2()) +
//                                Integer.parseInt(columnArray.get(j).getNumber3()) + Integer.parseInt(columnArray.get(j).getNumber4())
//                                + Integer.parseInt(columnArray.get(j).getNumber5())) * Integer.parseInt(numbersToBeDrawn.get(i));
//
//                        printResultColumn(columnArray, j);
//                        System.out.println(result);
//                        proceed = false;
//
//                        if (proceed == false) {
//                            break;
//                        }
//                    }
//                }
//                if (proceed == false) {
//                    break;
//                }
//
                /*
                *
                *      the     <コ:彡       has won
                *
                *           i am defeat
                *
                * */
//
//            }
//        }
//    }
//}


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
