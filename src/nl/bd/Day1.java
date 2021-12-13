package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    public static void filereader (ArrayList<Integer> numberlist) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputday1.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
//                String[] line = lineText.split("");
                numberlist.add(Integer.parseInt(lineText));
            }


            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }


    public static void calculation(){

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> numberlist = new ArrayList<Integer>();

        filereader(numberlist);



        int counter = 0;

        int i = 0;
        int k = i + 1;

        do {

            if (numberlist.get(k) > numberlist.get(i))
                counter++;

            i++;
            k++;
        } while (k <= numberlist.size()-1);

//
//        for(int i= 0 ; i < numberlist.size()-1; i++){
//            for(int k = i+1 ; k < numberlist.size() ; k++){
//                if(numberlist.get(k) > numberlist.get(i)) {
//                    counter++;
//                }
//
//            }
//        }
        System.out.println(counter);

    }

}
