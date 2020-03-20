package game;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Log<log> {

    private String startTime;
    private Date today;

    public void writeLogfile() {
        String line = "";
        File inFile = new File("log.txt");
        File writeFile;
        SimpleDateFormat timeToString = new SimpleDateFormat("dd/MM/yy H:m:s"); // Edit here
        today = new Date(); // Edit here
        try {
            if (inFile.exists()) {
                Scanner sc1 = new Scanner(inFile);

                while (sc1.hasNextLine()  || inFile.length() == 0){ // Edit here
                    if(inFile.length() != 0) {  // Edit here insert new if statement for file empty will execute
                        line = line + sc1.nextLine() + "\r\n";
                    }

                    writeFile = new File("log.txt");
                    FileOutputStream outFS = new FileOutputStream(writeFile);
                    PrintWriter outS = new PrintWriter(outFS);
                    //outS.print(line + "Start game at " + getStartTime());
                    outS.print(line + "Start game at " + timeToString.format(today)); //Edit here
                    outS.close();

                }

            } else {
                writeFile = new File("log.txt");
                FileOutputStream outFS = new FileOutputStream(writeFile);
                PrintWriter outS = new PrintWriter(outFS);
                //outS.println("Start game at " + getStartTime());
                outS.println("Start game at " + timeToString.format(today)); // Edit here
                outS.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void saveHeighScore(int score) throws IOException {
        File inFile = new File("score.txt");
        File writeFile;
        try{

            if(inFile.exists()){

                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                String line = reader.readLine();
                System.out.println(line);

                if (line != null){
                    int oldScore = Integer.parseInt(line);
                    if(oldScore < score){
                        String name = JOptionPane.showInputDialog(null, "Enter your name");
//                        savePlayerTop(name);
                        writeFile = new File("score.txt");
                        FileOutputStream outFS = new FileOutputStream(writeFile);
                        PrintWriter outS = new PrintWriter(outFS);
                        outS.println(score); //Write Score
                        outS.close();
                    }
                }
            }else{
                writeFile = new File("score.txt");
                inFile.createNewFile();
                FileOutputStream outFS = new FileOutputStream(writeFile);
                PrintWriter outS = new PrintWriter(outFS);
                outS.println(score);//Write Score
                outS.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error !! : " + e.getMessage());
        }
    }

   public static void saveTop(String name, int score){
       List<String> list = new ArrayList<String>();

   }

    private static String[] push(String[] array, String push) {
        String[] longer = new String[array.length + 1];
        for (int i = 0; i < array.length; i++)
            longer[i] = array[i];
        longer[array.length] = push;
        return longer;
    }

}
