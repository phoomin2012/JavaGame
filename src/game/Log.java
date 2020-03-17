package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

}
