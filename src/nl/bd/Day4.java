package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    ArrayList <String> cardArray = new ArrayList<>();

    public void filereader (ArrayList<String> cardArray) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputDay4CardsTest.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
                String[] line = lineText.split(" " );
                cardArray.add(new bingoCardLine(line[0], line[1], line[2], line[3], line[4], line[5]));
                /*Raar dat dit niet werkt
                *
                * volgens mij gaan we met nested classes werken gezien regel en colom apparte objecten binnen de kaart zijn
                *
                * of niet gezien die hele kaar niet interessant is, maar alleen de totaalsom van de nummers van de winnende regel of colom*/



            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    /*Bingokaarten in array van objecten voegen*/
    /*Bingonummers in andere array voegen en deze stuk voor stuk opvragen om te vergelijken, toevoegen aan tweede arraylist
     * met getrokken nummers*/

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

    /*Als Arraylist met getrokken nummers contains alle items uit een regel of kolom, dan bingo*/

    /*som regel of kolom * laatste entry uit de getrokken nummers = antwoord*/

}
