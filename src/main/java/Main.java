package lists;

public class lists2 {

	public static Node<Integer> buildListFromArr(int[] arr) {
		Node<Integer> head = new Node<>(arr[0]);
		Node<Integer> current = head;
		for(int i=1; i<arr.length; i++) {
			Node<Integer> newNode = new Node<>(arr[i]);
			current.setNext(newNode);
			current = newNode;
		}
		return head;
	}

	public static Node<Integer> delEven(Node<Integer> H) {
		Node<Integer> current = H;
		Node<Integer> newH = new Node<>(null);
		Node<Integer> newCurrent = newH;
		while (current.getNext().getNext()!=null) {
			newCurrent.setNext(current.getNext());
			newCurrent = current.getNext();
			current.setNext(current.getNext().getNext());
			current = current.getNext();
		}
		newCurrent.setNext(current.getNext());
		current.setNext(current.getNext().getNext());
		return newH.getNext();
	}


	public static Node<Integer> delDoubles(Node<Integer> head) {
		Node<Integer> current1 = head;

		while (current1 != null) {
			Node<Integer> current2 = current1.getNext();
			Node<Integer> previous2 = current1;

			while (current2 != null) {
				if (current2.getValue()==current1.getValue()) {
					previous2.setNext(current2.getNext()); 
				} else {
					previous2 = current2;  
				}
				current2 = current2.getNext();  
			}
			current1 = current1.getNext();   
		}

		return head;
	}

/*Q1*/
	public static Node<Integer> weakUp(Node<Integer> c1,Node<Integer> c2,Node<Integer> newC,Node<Integer> newH) {
		if (c1 != null && c2 != null) {
			if (c1.getValue() > c2.getValue()) {
				newC.setNext(c2);
				newC = c2;
				c2 = c2.getNext();
			}
			else if (c1.getValue() < c2.getValue()) {
				newC.setNext(c1);
				newC = c1;
				c1 = c1.getNext();
			}
			else {
				newC.setNext(c2);
				newC = c2;
				c2 = c2.getNext();
				newC.setNext(c1);
				newC = c1;
				c1 = c1.getNext();
			}

			return weakUp(c1,c2,newC,newH);
		}
		else if (c1==null) {
			newC.setNext(c2);
			newC = c2;
			c2 = c2.getNext();
			return newH.getNext();
		}
		else {
			newC.setNext(c1);
			newC = c1;
			c1 = c1.getNext();
			return newH.getNext();
		}
	}

/*Q2*/
	public static Node<Integer> upSidra(Node<Integer> head) {
	    if (head == null) {
	        return null; 
	    }

	    Node<Integer> newHead = new Node<>(null); 
	    Node<Integer> newCurrent = newHead;

	    while (head != null) {
	    	
	        Node<Integer> minNode = head;
	        Node<Integer> minNodePrev = null;
	        Node<Integer> current = head;
	        Node<Integer> prev = null;

	        
	        while (current != null) {
	            if (current.getValue() < minNode.getValue()) {
	                minNode = current;
	                minNodePrev = prev;
	            }
	            prev = current;
	            current = current.getNext();
	        }

	        if (minNodePrev != null) {
	            minNodePrev.setNext(minNode.getNext());
	        } else {
	            head = head.getNext(); 
	        }

	        newCurrent.setNext(minNode);
	        minNode.setNext(null); 
	        newCurrent = newCurrent.getNext();
	    }

	    return newHead.getNext(); 
	}

	
/*Q3*/
	
/*Q4*/
	
/*Q5*/
	
/*Q6*/
	
/*Q7*/
	
/*Q8*/
	
/*Q9*/
	
/*Q10*/

	public static void main(String[] args) {

		int [] a = {1,3,4,3,4,5,1,18,15,17};
		/*int [] b = {5,5,5,6,12,14,14,15};*/
		Node<Integer> head1 = buildListFromArr(a);
		/*Node<Integer> head2 = buildListFromArr(b);
		Node<Integer> head3 = new Node<>(null);*/
		System.out.println(upSidra(head1));

	}	
}


