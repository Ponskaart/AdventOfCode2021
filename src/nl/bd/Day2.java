package nl.bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Day2 {

    public static void filereader (ArrayList<String> inputlist) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("inputday2.txt"));
            String lineText;

            while ((lineText = fileReader.readLine()) != null) {
//                String[] line = lineText.split("");
                inputlist.add(lineText);
            }


            fileReader.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

    public static void calculation(){

        ArrayList<String> inputlist = new ArrayList<String>();

        filereader(inputlist);

        int horizontalPosition = 0;
        int depthPosition = 0;
        String entryRefined;
        int aim = 0;

        for (int i = 0 ; i <= inputlist.size()-1 ; i++) {


            String entry = inputlist.get(i);

            if (entry.startsWith("f")) {
                entryRefined = entry.replaceAll("[^0-9]", "");
                int forwardCounter = Integer.parseInt(entryRefined);
                horizontalPosition = horizontalPosition + forwardCounter;
                depthPosition = depthPosition + (aim * forwardCounter);
            }   else if (entry.startsWith("d")) {
                entryRefined = entry.replaceAll("[^0-9]", "");
                int downCounter = Integer.parseInt(entryRefined);
                aim = aim + downCounter;
            }   else {
                entryRefined =entry.replaceAll("[^0-9]", "");
                int upCounter = Integer.parseInt(entryRefined);
                 aim = aim - upCounter;
                }
        }

        System.out.println(horizontalPosition*depthPosition);

    }





}
