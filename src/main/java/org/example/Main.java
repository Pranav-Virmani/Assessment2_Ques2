package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import org.jfree.chart.JFreeChart;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create table in the database
            DatabaseManager.createTable();

            // Step 2: Read Excel data
            List<DataModel> data = ExcelReader.readExcel("C:\\Users\\pranav.virmani\\Desktop\\Accolite_Data.xlsx");

            // Step 3: Insert data into the database
            DatabaseManager.insertData(data);
            List<String> ls=DatabaseManager.teamWithMaxInterviews();
            DatabaseManager.teamWithMinInterviews();
            DatabaseManager.top3Skills();
            DatabaseManager.top3Panels();
          //  DatabaseManager.skillsInPeakTime();





            //ListIterator<String> it=ls.listIterator();
/*for (String team : ls)
            {
//prints the elements of the List
                obj =new DataModel();
                obj.setTeam(team);
                System.out.println(obj.getTeam());
                data1.add(obj);
                System.out.println(data1);

            }*/

            // Step 4: Generate charts
            JFreeChart chart = ChartGenerator.createChart(data);
           // JFreeChart chart1 = ChartGenerator.createChart(ls);

            // Step 5: Generate PDF and embed charts
            PdfGenerator.generatePdf(data, "C:\\Users\\pranav.virmani\\Desktop\\Assignment2\\Ques2\\Output\\Output1.pdf");
           // PdfGenerator.generatePdf(data1, "C:\\Users\\pranav.virmani\\Desktop\\Assignment2\\Ques2\\Output\\Output2.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}