/*
File name: OrderedList.java

 */
package orderednodestester;


public class OrderedList<E> 
{
 //Instance Variables:
    
    
    /**
     * Constructor.
     */
    public OrderedList()
    {
        
    }
    
    /**
     * Insert a new node with int x into its proper place on the list.
     * 
     * @param x the number in the node
     * @return the node inserted in the proper place on the list
     */
    public Node insert(int x)
    {
        Node cool;
        return cool;
    }
    
    /**
     * Remove the node that contains x from the list
     * @param x the number in the node to be removed
     * @return the removed node
     */
    public Node delete(int x)
    {
        
    }
    
    /**
     * Clear the list.
     */
    public void clear()
    {
        
    }
    
    /**
     * Reverse the elements of the list. When done the list will be in 
     * descending order. 
     * 
     * :::::::::::ALGORITHM:::::::::::
     * Remove the first node and insert it immediately after the last node.
     * Repeat for all nodes except the last one.
     * 
     * @return the revered elements on the list
     */
    public Node reverse1()
    {
        
    }
    
    /**
     * Reverse the elements of the list.
     * 
     * :::::::::::ALGORITHM:::::::::::
     * Traverse the list, remove each node (except the first) and insert it
     * as the new first node.
     * 
     * @return the revered elements on the list
     */
    public Node reverse2()
    {
        
    }
}//end of OrderedList class definition

class Node<E>
{
    E info;         //each Node object contains an 
                    //object of the "type variable" class
    Node next;      //a reference to another node
    
    Node(E x)
    {
        info = x;
        next = null;
    }
    
}//end of Nodes class definition
