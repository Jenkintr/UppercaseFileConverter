/*
 * This program asks the user for the name of two files. The first file is opened
 * for reading and the second file is opened for writing. The program reads the 
 * contents of the first file, changes all the characters to uppercase, and stores
 * the results in the second file. 
 */
package uppercasefileconverter;

import java.util.Scanner; //Needed for the Scanner class
import java.io.*;        //Needed for file IO

/**
 *
 * @author TaylorJenkins
 * @date   09/19/2016
 */
public class UpperCaseFileConverter {

    
    public static void main(String[] args) throws IOException {
        String inputFilename;
        String outputFilename;
        
        //Intro to the program
        System.out.println("If you enter a file name, this program will take " + 
                " the information from the file and convert it to uppercase to " +
                "be stored in a new file.\n");
        
        //Create scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        //Get the input file name.
        System.out.println("Enter the file's name that you wish to convert: (ex: filename.txt) \t");
        inputFilename = keyboard.nextLine();
        
        //Check that filename exists.
        File inFile = new File(inputFilename);
        if (!inFile.exists())
        {
            System.out.println("The file " + inputFilename + " was not found.");
        }
        
        //Open the input file:
        Scanner inputFile = new Scanner(inFile);
        
        //Get the output file name.
        System.out.println("Enter the name of the file for this information to be stored to: \t");
        outputFilename = keyboard.nextLine();
        
        //Make sure output file name does not already exist.
        File outFile = new File(outputFilename);
        if (outFile.exists())
        {
            System.out.println("The file " + outputFilename + " already exists.");
            System.exit(0);
        }
        
        //Open the output file:
        PrintWriter outputFile = new PrintWriter(outFile);
                
       //Read lines from file until there are none left and print to output file
        while (inputFile.hasNext())
        {
            //Read the next line.
            String fromFile = inputFile.nextLine();
            
            //Print in uppercase to the output file.
            outputFile.println(fromFile.toUpperCase());
        }
        
        //Close the files:
        inputFile.close();
        outputFile.close();
        System.out.println("Your data from the file has been converted.");
    }
    
}
