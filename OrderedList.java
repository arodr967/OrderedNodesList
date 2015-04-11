/*
File name: OrderedList.java
A generic ordered list implemented by Nodes.
 */
package orderednodestester;
//***********PROPERTY OF ALICIA RODRIGUEZ***********
public class OrderedList<E extends Comparable<E>> 
{
 //Instance Variables:
    private Node head; //the first thing on the list (head)
                       //node automatically already points to null
    private boolean ascending; //true when list is first created 
    
    /**
     * Constructs a node that's pointing to null. An empty list.
     */
    public OrderedList()
    {
        head = null;       
        ascending = true;
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    //*******UTILITY METHODS*******
    
    /**
     * Insert a node after the input node
     * @param prevNode the node that comes before the one that will
     * be inserted
     * @param input the node inputed by insert method
     */
    private void insertAfter(Node prevNode, Node input)
    {       
        input.next = prevNode.next;
        prevNode.next = input;
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    /**
     * Insert the node as the first node on the list
     * 
     * @param input the node inputed by insert method
     */
    private void insertFirst(Node input)
    {
        input.next = head;  //input is pointing to whatever head is
        head = input;       //head is point to input to make it the first
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    /**
     * Insert a new node with E x into its proper place on the list.
     * List is in descending order, from largest to smallest.
     * 
     * @param info the info of any type to be inserted in list
     */
    private void insertDES(E info)
    {
        Node input = new Node(info);
        Node temp = head;
            
        //1...
        if(isEmpty())
        {
           head = input;    //head is now pointing to whatever head is
        } //2...
        
        if(compare(input.info,temp.info) > 0)  
           //if input info comes before temp info (pos)
        {
            insertFirst(input);    
        } //3 & 4...
        else //***********PROPERTY OF ALICIA RODRIGUEZ***********
        {   //node goes inbetween 2 other nodes on list
            while(temp.next != null &&
                compare(temp.next.info, input.info) > 0)
            {
                temp = temp.next;
            }            
           insertAfter(temp, input);
            }        
    }
    
    /**
     * Insert a new node with E x into its proper place on the list.
     * List is in ascending order, from smallest to largest.
     * 
     * @param info the info of any type to be inserted in list
     */
    private void insertASC(E info)
    {
        //Must check if...
        //1. the list is empty
        //2. there is one node on the list
        //3. info goes after the last node on the list
        //4. info goes in between one of the nodes on the list
        
        Node input = new Node(info);
        Node temp = head;
        //***********PROPERTY OF ALICIA RODRIGUEZ***********
        //1...
        if(isEmpty())
        {
            head = input;    //head is now pointing to whatever head is
        } //2...
        else if(compare(input.info,temp.info) < 0)  
            //if input info comes before temp info (negative)
        {
            insertFirst(input);    
        } //3 & 4...
        else
        {   //node goes inbetween 2 other nodes on list
            while(temp.next != null &&
                  compare(temp.next.info, input.info) < 0)
            {
                temp = temp.next;
            }
            
            insertAfter(temp, input);
        }
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    /**
     * Precondition: The prevNode cannot be the last node on the list
     * Deletes the node that comes after a previous one
     * 
     * @param prevNode the node that comes before the one that 
     * will be deleted
     */
    private void deleteAfter(Node prevNode)
    {             
        //the node i want to delete comes after the prev
        Node toDelete = prevNode.next; 
        prevNode.next = toDelete.next;  //take node out of the list
    }
    
    /**
     * Delete the first node on the list
     * 
     * @param toDelete first node on the list which we want to remove
     */
    private void deleteFirst(Node toDelete)
    {
        head = toDelete.next;
    } //***********PROPERTY OF ALICIA RODRIGUEZ***********
    
    /**
     * Delete a node from the list but save it's info
     * 
     * @param toDelete the node which we want to remove but save for later
     * @return the savedNode with the saved info from the node to delete
     */
    private Node saveAndDelete(Node toDelete)
    {
        Node savedNode;
        
        E saveInfo = toDelete.info;   //save info of save
        delete(toDelete.info);        //delete save.info
        savedNode = new Node(saveInfo);  //create node with savedinfo
        
        return savedNode;       
    }
    
    /**
     * Gets the last node of the list
     * //***********PROPERTY OF ALICIA RODRIGUEZ***********
     * @return a pointer to the last node of the list
     */
    private Node lastNode()
    {        
        if(isEmpty())   //check if the list is empty
        {
            System.out.println("The list is empty!");
            return null;
        }
        Node temp = head;    
        //if its the last node, then temp is pointing to null
        while(temp.next != null) //while its not null
        {
            temp = temp.next;   //go to the next one until you find null
        }
        //we've now reached the last node
        return temp;       
    }
    
    /**
     * Gets the first node of the list
     * @return a pointer to the first node of the list
     */
    private Node firstNode()
    {//***********PROPERTY OF ALICIA RODRIGUEZ***********
        if(isEmpty())
        {
            System.out.println("The list is empty!");
            return null;
        }
        
        Node temp = head;
        
        return temp;
    }
    
    /**
     * Compares the first object with the second
     * 
     * @param firstObject first of any type of object
     * @param secondObject second of any type of object
     * @return the first object compared to the second
     */
    private int compare(E firstObject, E secondObject)
    {
        //it is assumed that both objects are of the same type
        return firstObject.compareTo(secondObject);
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    //*******CONCRETE METHODS*******
        
    /**
     * Check if the list is empty.
     *
     * @return true or false if the list is empty
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    /**
     * Get if the list is ascending or not
     * 
     * @return true when list is ascending
     */
    public boolean isAscending()
    {
        return ascending;
    }
    
    /**
     * Insert a new node with E x into its proper place on the list.
     * 
     * @param info the info of any type to be inserted in list
     */
    public void insert(E info)
    {               
        if(isAscending())
            insertASC(info);
        else 
            insertDES(info);       
    }
    
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    /**
     * Remove the node that contains x from the list.
     * 
     * @param x info of any type
     */
    public void delete(E x)
    {
        Node toDelete = head;   
        
        while(!toDelete.info.equals(x) && toDelete.next != null) 
        {   //while the info is not equal to temp
            //move on to the next node
            toDelete = toDelete.next;
        }
        //CHECK IF X IS NOT ON THE LIST        
        if(!toDelete.info.equals(x) && toDelete.next == null)
        {
            System.out.println(x + " is not on the list!");
        }
        else if(toDelete == head)   //first item on list?
        {
            deleteFirst(toDelete);
        }
        else //if(toDelete.info.equals(x))
        {
            //now the info of toDelete is equal to the info of E

         Node temp = head;  //another pointer that will tell me when
                            //its behind the node i want to delete
        //***********PROPERTY OF ALICIA RODRIGUEZ***********
        
         while(temp.next != toDelete)
         {
              temp = temp.next;
         }
            //temp.next is what i want to delete
                
         deleteAfter(temp);  //delete whatever's after temp 
        }
    }
    
    /**
     * Clear the list.
     */
    public void clear()
    {
        head = null;
    }//***********PROPERTY OF ALICIA RODRIGUEZ***********
    
    /**
     * Reverse the elements of the list. When done the list will be in 
     * descending order. 
     * 
     * :::::::::::ALGORITHM:::::::::::
     * Remove the first node and insert it immediately after the last node.
     * Repeat for all nodes except the last one.
     */
    public void reverse1()
    {        
        Node toDelete = head;
        Node lastNode = lastNode(); //create pointer to the last node
       
        do
        {//***********PROPERTY OF ALICIA RODRIGUEZ***********
            //create a new node if the info of the one we want to delete 
            Node save = saveAndDelete(toDelete);                          
            insertAfter(lastNode, save);    //insert move after the last node
            
            toDelete = head;   //update toDelete to point to whatever head is
            
        } while(toDelete != lastNode);

       ascending = !ascending; //true or false = false or true      
    }
    
    /**
     * Reverse the elements of the list.
     * 
     * :::::::::::ALGORITHM:::::::::::
     * Traverse the list, remove each node (except the first) and insert it
     * as the new first node.
     */
    public void reverse2()
    {
        Node toDelete = head;
        Node firstNode = firstNode();
         
        while(firstNode.next != null)
        {//***********PROPERTY OF ALICIA RODRIGUEZ***********
            toDelete = firstNode.next;
            
            Node save = saveAndDelete(toDelete);
            
            insertFirst(save);            
        }
        
        ascending = !ascending; //true or false = false or true        
    }
    
    /**
     * Gets all of the objects on the list and prints them out as a string
     *
     * @return the updated list as a string
     */
    @Override
    public String toString()
    {
        String update = " ";
        Node temp = head;   //start at the beginning of the list
        
        while (temp != null)    //while more nodes on the list...
        {
            update += temp.info + " ";  //get current object
            temp = temp.next;           //..and move to next node
        }
        
        return update + "\n";
    }
    //***********PROPERTY OF ALICIA RODRIGUEZ***********
    //*******inner class of Node*******
    class Node
    {    
        E info;         //each Node object contains an 
                    //object of the "type variable" class
        Node next;      //a reference to another node
    
        Node(E x)
        {//***********PROPERTY OF ALICIA RODRIGUEZ***********
        info = x;
        next = null;
        }   
      
    }//end of Nodes class definition
}//end of OrderedList class definition
//***********PROPERTY OF ALICIA RODRIGUEZ***********
