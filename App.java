import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import people.Person;
import service.CSVManagement;

public class App {

    public static void main(String[] args) throws IOException {

        // arg[0] arg[1] arg[2]
        // arg[0] "c:\data"
        // arg[1] myfile.txt
        // c:\datamyfile.txt

        // windows: c:\data\myfile.txt
        // macOS: /data/myfile.txt

        String dirPath = args[0];
        String fileName = args[1];

        // e.g. c:\data\myfile.txt
        String dirPathFileName = dirPath + File.separator + fileName;
        System.out.println(dirPathFileName);

        // check if a directory exists
        // if directory does not exist, create the directory
        File directory = new File(dirPath); // checking if directory exists

        if (directory.exists()) {
            System.out.println("Directory " + directory.toString() + " had already been created");
        } else {
            directory.mkdir();
        }

        //check if the file exists
        // if file does not exist, create the file
        File file = new File(dirPathFileName);
        
        if (file.exists()) {
            System.out.println("File " + file.toString() + " had already been created");
        } else {
            file.createNewFile();
        }

        // Use FileWriter
        // 1. Use console to read in a string of text (sentence)
        // 2. Use FileWriter to write the content to the file
        // Console console = System.console();
        // String keyboardInput = console.readLine("Enter/Input a sentence: ");
        
        // FileWriter fw = new FileWriter(file, true); // refer to documentation -> if true, when I write a new file and append
        //                                                     // if false -> file will be overwritten
        // fw.write(keyboardInput);
        // fw.flush();
        // fw.close();

        // // Use FileReader to read the file
        // FileReader fr = new FileReader(file);
        // int dataRead = fr.read();
        // while(dataRead != -1) {
        //     System.out.print((char) dataRead); // ASCII
        //     dataRead = fr.read();  // go to next character
        // }
        // fr.close();


        // Example 2
        // Use BufferedWrite to write to file
        // FileWriter fw = new FileWriter(file, true);
        // BufferedWriter bw = new BufferedWriter(fw);
        // bw.append(keyboardInput);
        // bw.flush();
        // bw.close();

        // // Use Buffered Reader to read the file content
        // try (FileReader fr = new FileReader(file)) {   // will automatically close the file reader etc
        //     try (BufferedReader br = new BufferedReader(fr)) {
        //         String line = "";
        //         while((line = br.readLine()) !=null) {
        //             System.out.println(line);
        //         }

        //     }

        // }
        // br.close();
        // fr.close();

        // Example 3
        // Use FileOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file, true);
        // byte[] byteContent = keyboardInput.getBytes();
        // fos.write(byteContent);
        // fos.flush();
        // fos.close();

        // // Use FileInputStream to read the file content
        // FileInputStream fis = new FileInputStream(file);
        // int contentRead = 0;
        // while ((contentRead = fis.read()) != -1) {
        //     System.out.print((char) contentRead);
        // }
        // fis.close();

        // Example 4 (Decorator pattern)
        // Use FileOutputStream and DataOutputStream to write to file
        // FileOutputStream fos = new FileOutputStream(file, true);
        // DataOutputStream dos = new DataOutputStream(fos); // how to tell the type of data out of DataOutputStream?
        // byte[] byteContent = keyboardInput.getBytes();
        // dos.write(byteContent);
        // dos.flush();
        // dos.close();




        // // Use FileInputStream and DataInputStream to read the content
        // FileInputStream fis = new FileInputStream(file);
        // DataInputStream dis = new DataInputStream(fis);
        // int content;
        // while ((content = dis.read()) != -1) {
        //     System.out.print((char) content);
        // }
        // dis.close();
        // fis.close();
        

        // Example 5 (Decorator pattern)
        // Use FileOutputStream and GIZPOutputStream


        List<Person> persons = new ArrayList<>();

        CSVManagement csv = new CSVManagement();
        csv.readCSV(dirPathFileName);

        // menu
        // 1. Enter new Person details
        // 2. Save to file (Prompt for new csv file name)
        // 3. Quit and terminate program

        Console consoleSelection = System.console();
        Integer selection = 0;
        while (selection != 3) {
            System.out.println("1. Enter new Person details");
            System.out.println("2. Save to new csv file");
            System.out.println("3. Quit program");
            selection = Integer.parseInt(consoleSelection.readLine(">>> "));
        

            switch (selection) {
                case 1:
                    Console con1 = System.console();
                    String personName = con1.readLine("Enter Person name: ");
                    String personConstituency = con1.readLine("Enter constituency: ");
                    String personBirthYear = con1.readLine("Enter Birth Year: ");

                    Person p = new Person(personName, personConstituency, Integer.parseInt(personBirthYear));
                    persons.add(p);
                    break;
                
                case 2:
                    Console con2 = System.console();
                    String newFileName = con2.readLine("Enter a csv file to save (filename only): ");

                    csv.writeCSV(dirPath + File.separator + newFileName, persons);
                    break;
                
                default:
                    break;



            }


        }

    // public static void menu() {
    //     System.out.println("=========================");
    //     System.out.println("Enter '1' for new Person details");
    //     System.out.println("Enter '2' to save new csv file");
    //     System.out.println("Enter '3' to quit program");
    //     System.out.println(">>>>>>>");
    // }

    // public static void userInput() {

    //     Console consoleSelection = System.console();
    //     Integer selection = 0;

    //     selection = Integer.parseInt(consoleSelection.readLine(">>>> "));

    //     while 
    // }



    
    }
}