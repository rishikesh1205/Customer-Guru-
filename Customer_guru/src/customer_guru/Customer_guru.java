/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_guru;

import java.util.*;

/**
 *
 * @author RISHIKESH
 */


class customer_guru
{
    public void mergeArrays(int[] array1,int[] array2,int[] array3,int n1,int n2) 
    {
        int i=0, j=0, k=0;
        
        while(i<n1 && j<n2)                  //algorithm of merge sort              
        {
            if(array1[i]<array2[j])         
                array3[k++]=array1[i++];
            else
                array3[k++]=array2[j++];     
        }
        while(i<n1)
            array3[k++]=array1[i++];
        while(j<n2)
            array3[k++]=array2[j++];
    }
    public static int randomFill(){         //random function to fill array with random values

    Random rand = new Random();
    int randomNum = rand.nextInt();
    return randomNum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        customer_guru cg=new customer_guru();
        System.out.println("Enter the size of Array 1: ");
        Scanner size_n1 = new Scanner(System.in);
        int n1 = size_n1.nextInt()-1;               //Get the size of array1
        System.out.println("Enter the size of Array 2: ");
        Scanner size_n2 = new Scanner(System.in);   //Get the size of array2
        int n2 = size_n2.nextInt()-1;
        int[] array1 = new int[100];    //initialize arrays for example I've given 100
        int[] array2 = new int[100];
      
        for(int i=0;i<n1;i++)
        {
            array1[i]=randomFill();     //we cannot type 100 input values
                                        //so filling array1 with random numbers
        }
        for(int i=0;i<n2;i++)
        {
            array2[i]=randomFill();     //filling array2 with random numbers
 
        }
        Arrays.sort(array1);            //sorting array1
        Arrays.sort(array2);            //sorting arrray2
        int[] array3 = new int[n1+n2];  //declaring array3 with sum of size of 2 arrays 
        cg.mergeArrays( array1,array2,array3,n1,n2); //now performing merge sort for array 3 with o[n] complexity
        System.out.println("Array after merging:");
        for(int i=0;i<n1+n2;i++)
            System.out.print(array3[i] + " ");  //printing the result 
       }
}
         
        
    