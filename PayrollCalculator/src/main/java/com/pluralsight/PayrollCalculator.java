package com.pluralsight;




import java.io.*;
import java.util.regex.Pattern;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");

            BufferedReader bufReader = new BufferedReader(fileReader);

            bufReader.readLine(); //Skips first line

            String input;
            // read until there is no more data
            while((input = bufReader.readLine()) != null) {

                String[] items = input.split(Pattern.quote("|"));
//                input.split("\\|"); - alternative to above
//                if (items[0].equalsIgnoreCase("id")) { alternative to skip first line bufReader.readLine()
//                    continue; //starts loop over here
//                }
                int id = Integer.parseInt(items[0]); //this is the id
                String name = items[1];
                double hours = Double.parseDouble(items[2]);
                double payRate = Double.parseDouble(items[3]);

                Employee newEmployee = new Employee(id, name, hours, payRate);

                System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f%n", newEmployee.getEmployeeId(), newEmployee.getName(), newEmployee.getGrossPay());
            }

            bufReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: reading file");
            System.out.println(e.getMessage());
        }

    }
}
