/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author RISHIKESH
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i,iteration_value;
        ArrayList<String> list=new ArrayList<String>();
        ArrayList<String> temp=new ArrayList<String>();
        Scanner in=new Scanner(System.in);
        String value;
        System.out.println("Enter Elements (Enter \"exit\" to stop)");
        for(;;)
        {
            value=in.next();
            if(value.equals("exit"))
            {
                break;
            }
            else
                list.add(value);                                      //Getting array list values
        }
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.addAll(list);                                             //putting into hashset and getting values from them removes duplicates
        temp.addAll(lhs);
        int[] frequency=new int[temp.size()];                           
        for(i=0;i<temp.size();i++)
        {
            int x=Collections.frequency(list,temp.get(i));            //Getting the frequency of the members in the list to frequency array
            frequency[i]=x;
        }
        for(i=0;i<temp.size();i++)
        {
            for(int j=0;j<temp.size();j++)
            {
                if(frequency[i]>frequency[j])
                {
                    int temp_swap=frequency[i];                       //Arranging in descending order of frequencies
                    frequency[i]=frequency[j];
                    frequency[j]=temp_swap;
                    String temp_swap_list=temp.get(i);
                    temp.set(i, temp.get(j));
                    temp.set(j, temp_swap_list);
                }
            }
        }
        if(temp.size()>=5)                                          //checking for top 5 elements because Always the list might not have 5 repeated elements 
        {                                                           
            iteration_value=5;
        }
        else
        {
            iteration_value=temp.size();
        }
        System.out.println("\nTop elements");        
        for(i=0;i<iteration_value;i++)
        {
            System.out.println("\n "+temp.get(i));                  //printing the final result
        }    
    }
}
    

