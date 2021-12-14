package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    public class bingoCardLine{

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

    ArrayList <bingoCardLine> cardArray = new ArrayList<bingoCardLine>();

    public void filereader (ArrayList<bingoCardLine> cardArray) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4CardsTest.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
                String[] line = lineText.split("\\s" );
                cardArray.add(new bingoCardLine(line[0], line[1], line[2], line[3], line[4]));

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


    /*getrokken bingonummers in andere array voegen en iedere keer vergelijken of de bingoCardLine (for each, contains(getrokken bingonummers)
    * dit alles in een if else statement, dat als .contains true */



    /*Als Arraylist met getrokken nummers contains alle items uit een regel of kolom, dan bingo*/

    /*som regel of kolom * laatste entry uit de getrokken nummers = antwoord*/

}
