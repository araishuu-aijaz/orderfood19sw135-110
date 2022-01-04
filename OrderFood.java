import java.util.*;
import java.lang.Thread;

interface Queue{
public void add(Object obj);
public Object first();
public Object remove();
public int size();

}


public class OrderFood extends Thread implements Queue {

        private static class Node{
        Object object;
        Node prev= this, next=this;

        Node (Object obj){
        this.object=obj;
        }

        Node (Object obj, Node prev, Node next){
            this.object=obj;
            this.prev=prev;
            this.next=next;
        }

    }
    private int size;
    private Node head = new Node (null);

    public int size (){
        return size;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    public Object first(){
        if (size==0)
            throw new IllegalStateException("No any Order Placed");
        return head.next.object;
    }
    public void add(Object obj){
        head.prev.next= new Node (obj, head.prev, head);
        head.prev=head.prev.next;
        size++;
    }
    public Object remove(){
        if (size==0)throw new IllegalStateException("No any Order Placed");
        Object obj=head.next.object;
        head.next=head.next.next;
        head.next.prev=head;
        --size;
        return obj;
    }

public static void main(String[] args){


	Scanner obj = new Scanner(System.in);
	OrderFood lq = new OrderFood();
	String s=" ",q=" ",food=" ";   // s=q=yes/no,food=french fries, etc;
	int i=0,quant=0; // quant= food quantity, i= order no. , totalmoney= money of complete order.
    long totalmoney=1;
    System.out.println("\n\n********** MENU **********\n\nFrench Fries= 40 pkr\n\nChicken Burger= 80 pkr\n\nChiken Roll= 60 pkr\n\nChocolate Doughnut= 50 pkr\n\nOrange juice= 70 pkr\n\n");

    do{

    	System.out.println("Please Place your Order!\n\n");

    	do{


			System.out.println("What do you want to order?");
			food=obj.next();
			obj.nextLine();

			System.out.println("\nHow many?");
        	quant=obj.nextInt();
        	                                          if(food.equalsIgnoreCase("french fries")){
														  int k=40;
														  totalmoney=k*quant;
												      }
												      else if(food.equalsIgnoreCase("chicken burger")){
													  	  int k=80;
														  totalmoney=k*quant;
												      }
												      else if(food.equalsIgnoreCase("chicken roll")){
													  	  int k=60;
														  totalmoney=k*quant;
												      }
												      else if(food.equalsIgnoreCase("chocolate doughnut")){
													  	  int k=50;
														  totalmoney=k*quant;
												      }
												      else if(food.equalsIgnoreCase("orange juice")){
													  	  int k=70;
														  totalmoney=k*quant;
			                              }


	    	System.out.println("\nDo you want to order more(yes/no)?");
	    	s=obj.next();







	  	} while(s.equalsIgnoreCase("yes"));


	    System.out.println("\nYour Order no is "+(++i)+". Please pay "+totalmoney+"  pkr at the counter, it will be ready in a moment");
	    lq.add("Order no: "+(i));



	  System.out.println("\nAre there any more orders to take(yes/no)?");
	  q=obj.next();

      } while(q.equalsIgnoreCase("yes"));

      if(lq.size==1){
		  System.out.println(lq.size+" Order is being prepared");}
      else {
		  System.out.println(lq.size+" Orders are being prepared");}



	try{ for(int j=1; j<=i; j++){

    sleep(5000);
	System.out.println(lq.remove()+"is prepared, please collect it from the counter!\n");}
} catch(Exception e){ }




    }

}
