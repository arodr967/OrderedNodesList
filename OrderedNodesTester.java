/*
File name: OrderedNodesTester.java
Test class for LinkedList class.
 */
package orderednodestester;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//*********PROPERTY OF ALICIA RODRIGUEZ**********
public class OrderedNodesTester 
{
    /**
     * Read and execute list operation instructions 
     * from data file, until EOF. 
     * Each operation is to be implemented via a separate method of the list
     * class.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {        
        OrderedList orderedList = new OrderedList();
        
        //input file
        Scanner fileScan = new Scanner(new File("ordlist.txt"));  
                
        System.out.println("Welcome to the Generic "
                + "Ordered List of Nodes!\n");
        //*********PROPERTY OF ALICIA RODRIGUEZ**********
        while(fileScan.hasNext()) //while not eof
        {
            String instruction = fileScan.next(); //read the first token as
                                                  //the specific instruction
         if(fileScan.hasNextInt())
         { //if theres a number that comes after the instruction...
             
            int number = fileScan.nextInt();        //number of instruction
            
            if(instruction.equalsIgnoreCase("INSERT"))
            {
                System.out.println("Inserting " + number + "...");                
                orderedList.insert(number); //call insert method
                System.out.println("Updated list: " +   //display list
                        orderedList.toString() + "\n");
                
            }
            //*********PROPERTY OF ALICIA RODRIGUEZ**********    
            if(instruction.equalsIgnoreCase("DELETE"))
            {
                System.out.println("Deleting " + number + "...");
               
                if(!orderedList.isEmpty()) 
                {   //check if the list is not already empty
                    orderedList.delete(number);     //call delete method
                    System.out.println("Updated list: " +   //display list
                            orderedList.toString() + "\n");
                } 
                else { //if its empty, theres nothing to delete
                System.out.println("The list is empty! \n");
                }
                
            }
            
         } else { //otherwise, if its just a string...
             //*********PROPERTY OF ALICIA RODRIGUEZ**********
            if(instruction.equalsIgnoreCase("CLEAR"))
            {
                System.out.println("Clearing the list...");
                
                if(!orderedList.isEmpty())
                { //check if the list is not already empty
                orderedList.clear();
                System.out.println("The list has been cleared.\n");
                } else {
                    System.out.println("The list is already empty,"
                            + " there's no need to clear. \n");
                }
            }
            //*********PROPERTY OF ALICIA RODRIGUEZ**********
            if(instruction.equalsIgnoreCase("REVERSE1"))
            {
                System.out.println("Initiating REVERSE1 instruction...");
                
                if(!orderedList.isEmpty())
                { //check if the list is not already empty
                orderedList.reverse1();
                System.out.println("Updated list: " + 
                        orderedList.toString() + "\n");               
                
                } else{
                    System.out.println("The list is empty! \n");
                }
            }
            //*********PROPERTY OF ALICIA RODRIGUEZ**********
            if(instruction.equalsIgnoreCase("REVERSE2"))
            {
                System.out.println("Initiating REVERSE2 instruction...");
                
                if(!orderedList.isEmpty())
                { //check if the list is not already empty
                orderedList.reverse2();
                System.out.println("Updated list: " + 
                        orderedList.toString() + "\n");
                
                } else {
                    System.out.println("The list is empty! \n");
                }
            }
         }           
       } //eof                
    }    
} //end of the OrderedNodesTester class definition
//*********PROPERTY OF ALICIA RODRIGUEZ**********
