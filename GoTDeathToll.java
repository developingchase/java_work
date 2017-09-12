/*
* File: GoTDeathToll.java
* Author: Chase
* Date: July 16, 2017
* Purpose: A class for reading a CSV file, printing the file to the screen,
* then giving a count of the items; used GoT Characters List; DB8
* CSV file from: https://raw.githubusercontent.com/ceebu/GOT-from-Kaggle/master/character-deaths.csv
 */
//package gotdeathtoll;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GoTDeathToll {
    public static void main(String[] args) {
        System.out.println("[+] Starting GoTDeathToll.java...");

        String fileForInput = "..\\character-deaths.csv";
        int deathCount = 0;
        int totalCount = 0;
        if (args.length == 1){
            fileForInput = args[0];
            System.out.println("[+] Reading in " + fileForInput + 
                    " for processing.");
        }else{ //missing args, tell user and exit
            System.out.println("[!] You must provide an input file.");
            System.exit(0);
        }
        //Have the file, now let's read it
        BufferedReader inputCrimeCSVStream = null;
        String fileLine;
        try {
            inputCrimeCSVStream = new BufferedReader(new FileReader(fileForInput));
            inputCrimeCSVStream.readLine(); // read the headers so they are out of the way
           // Read the lines using BufferedReader
            while ((fileLine = inputCrimeCSVStream.readLine()) != null) {
                //create a new USCrimeData object in array
                String[] fileLineArray = fileLine.split(",");
                if (!fileLineArray[2].isEmpty()){
                    System.out.println(fileLineArray[0] + " was killed in the year " + fileLineArray[2]);  
                    deathCount+=1;
                };
                totalCount+=1;
            }
        } catch (IOException io) {
            System.out.println("[!] File IO exception" + io.getMessage());
        }finally {
            // Need another catch for closing 
            // the streams          
            try {               
                if (inputCrimeCSVStream != null) {
                inputCrimeCSVStream.close();
            }                
            } catch (IOException io) {
                System.out.println("[!] Issue closing the CSV " + io.getMessage());
            }   
        }
        System.out.println("Whew. That was rough. A total of " + deathCount + " characters have died.");
        System.out.println("Only " + (totalCount - deathCount) + " (" + ((totalCount-deathCount)/(double) totalCount)*100 + "%) characters remain.");
        System.out.println("Let's see who makes it through Season 7!");
    }
    
}
