/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author RISHIKESH
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        String from,to;
        Date today = new Date();                        //Getting today's date
        Scanner in = new Scanner(System.in);
        System.out.print("Enter From Date: "); 
        from=in.next();                                 //Getting from date
        System.out.print("Enter To Date:   "); 
        to=in.next();                                   //Getting to date
        Date fromdate=null,todate=null; 

          

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Setting the required format for date              
        fromdate=sdf.parse(from);
        todate=sdf.parse(to);                                             
        
        //printing values
        
        System.out.println("\nToday            : " + sdf.format(today));    
        System.out.println("From Date        : " + sdf.format(fromdate));
        System.out.println("To Date          : " + sdf.format(todate));
        
        
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(fromdate);             
        int month_fromdate=calendar.get(Calendar.MONTH);    //Getting month
        int year_fromdate=calendar.get(Calendar.YEAR);      //Getting year
        calendar.set(year_fromdate, month_fromdate, 01);    //Setting the start date to 01 for the same month and year
        Date firstvalue=calendar.getTime();
        System.out.println("\nFirst Day of Month: " + sdf.format(firstvalue));
        
        //Checking if the to date belongs to the same month and year
        
        calendar.setTime(today);
        int month_today=calendar.get(Calendar.MONTH);
        int year_today=calendar.get(Calendar.YEAR);
        calendar.setTime(todate);
        int month_toDate=calendar.get(Calendar.MONTH);
        int year_todate=calendar.get(Calendar.YEAR);
        if(month_toDate==month_today&&year_today==year_todate)
        {
        System.out.println("Last Day of Month: " + sdf.format(today));  
        }
        //If they are not equal calculate the last date of the particular month 
        // to do so move to the start date of the next month and reduce a day
        else
        {
            calendar.setTime(todate);
            calendar.add(Calendar.MONTH, 1);  
            calendar.set(Calendar.DAY_OF_MONTH, 1);  
            calendar.add(Calendar.DATE, -1);  
            Date lastDayOfMonth = calendar.getTime(); 
            System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
        }    
    }
}
