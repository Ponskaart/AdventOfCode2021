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

    public static void calculation(){
        ArrayList <bingoCardLine> lineArray = new ArrayList<bingoCardLine>();
        ArrayList <bingoCardColumn> columnArray = new ArrayList<bingoCardColumn>();
        ArrayList <String> numbersToBeDrawn = new ArrayList<>();
        ArrayList <String> drawnNumbers = new ArrayList<>();

        filereaderCards (lineArray);
        filereaderEntries (numbersToBeDrawn);
        String numbers = "";


//        for (bingoCardLine bingoCardLine : lineArray) {
//            System.out.println(bingoCardLine.getNumber1() + ", " + bingoCardLine.getNumber2() + ", "
//                    + bingoCardLine.getNumber3() + ", " + bingoCardLine.getNumber4() + ", "
//                    + bingoCardLine.getNumber5());
//             }

//        for (startingPointIndex = 0; startingPointIndex < 5; startingPointIndex++) {
//            endpointIndex = startingPointIndex * 5;

        int startingPointIndex = 0;
        int endpointIndex = 5;
        int counterLoopsTotal = 0;
        int counterNumberPosition = 0;

            do {
                counterNumberPosition++;

                for (int i = startingPointIndex ; i < endpointIndex; i++) {


                    if(counterNumberPosition <= 15) {
                        numbers = numbers + lineArray.get(i).number1 + ",";
                    } else if (counterNumberPosition <= 30) {
                        numbers = numbers + lineArray.get(i).number2 + ",";
                    } else if (counterNumberPosition <= 45) {
                        numbers = numbers + lineArray.get(i).number3 + ",";
                    } else if (counterNumberPosition <= 60) {
                        numbers = numbers + lineArray.get(i).number4 + ",";
                    } else if (counterNumberPosition <= 75) {
                        numbers = numbers + lineArray.get(i).number5 + ",";
                    }


                    String[] line = numbers.split(",");

                    columnArray.add(new bingoCardColumn(line[0], line[1], line[2], line[3], line[4]));
                }
                startingPointIndex = startingPointIndex + 5;
                endpointIndex = endpointIndex + 5;

                if (startingPointIndex > 10 || endpointIndex >15){
                    startingPointIndex = 0;
                    endpointIndex = 5;
                }
                 counterLoopsTotal++;
            } while (counterLoopsTotal <= 15);

        for (bingoCardColumn bingoCardColumn : columnArray) {
            System.out.println(bingoCardColumn.getNumber1() + ", " + bingoCardColumn.getNumber2() + ", "
                    + bingoCardColumn.getNumber3() + ", " + bingoCardColumn.getNumber4() + ", "
                    + bingoCardColumn.getNumber5());
             }
////        }











        /*berekening resultaat*/

        for (int i = 0; i < 27; i++){
            String drawnNumber = numbersToBeDrawn.get(i);
            drawnNumbers.add(drawnNumber);

            for (int j = 0; j < lineArray.size(); j++)
            if (drawnNumbers.contains(lineArray.get(i))){
                System.out.println(lineArray.get(i));
            } else if (drawnNumbers.contains(columnArray.get(i))){
                System.out.println(columnArray.get(i));
            }
        }
    }


    /*getrokken bingonummers in andere array voegen en iedere keer vergelijken of de bingoCardLine (for each, contains(getrokken bingonummers)
    * dit alles in een if else statement, dat als .contains true */



    /*Als Arraylist met getrokken nummers contains alle items uit een regel of kolom, dan bingo*/

    /*som regel of kolom * laatste entry uit de getrokken nummers = antwoord*/

}
