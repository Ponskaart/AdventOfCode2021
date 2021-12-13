package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part2 {

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
        int j = i + 1;
        int k = j + 1;

        while (k < numberlist.size()-1) {

            int comparison1 = numberlist.get(i) + numberlist.get(j) + numberlist.get(k);

            i++;
            j++;
            k++;

            int comparison2 = numberlist.get(i) + numberlist.get(j) + numberlist.get(k);

            if (comparison2 > comparison1)
                counter++;
        }

        System.out.println(counter);

    }

}
