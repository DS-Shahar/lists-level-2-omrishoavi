/*Lists level 2*/

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
	public static int sumOfDistances(int target,Node<Integer> head) {
		Node<Integer> current = head;
		int index = 0, firstIndex = -1, lastIndex = -1, size = 0;
		while (current != null) {
			if (current.getValue() == target) {
				if (firstIndex == -1) {
					firstIndex = index;
				}
				lastIndex = index;
			}
			current = current.getNext();
			index++;
		}
		size = index;

		if (firstIndex == -1) {
			return -1;
		}

		return firstIndex + (size - 1 - lastIndex);
	}



	/*Q4*/
	public static boolean allUnique(Node<Integer> head) {
		Node<Integer> c1 = head;

		while (c1 != null) {
			Node<Integer> c2 = c1.getNext();
			while (c2 != null) {
				if (c1.getValue() == c2.getValue()) {
					return false;
				}
				c2 = c2.getNext();
			}
			c1 = c1.getNext();
		}
		return true;
	}

	/*Q5*/
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

	/*Q6*/
	public static int longestNonDecreasingLength(Node<Integer> head) {
		int maxLength = 0, currentLength = 0;
		Node<Integer> current = head;

		while (current != null) {
			if (current.getNext() != null && current.getValue().compareTo(current.getNext().getValue()) <= 0) {
				currentLength++;
			} else {
				currentLength++;
				maxLength = Math.max(maxLength, currentLength);
				currentLength = 0;
			}
			current = current.getNext();
		}
		return maxLength;
	}


	/*Q7*/
	public static void printLongestNonDecreasing(Node<Integer> head) {
		int maxLength = 0, currentLength = 0, startIndex = 0, maxStartIndex = 0, index = 0;
		Node<Integer> current = head;

		while (current != null) {
			if (current.getNext() != null && current.getValue().compareTo(current.getNext().getValue()) <= 0) {
				currentLength++;
			} else {
				currentLength++;
				if (currentLength > maxLength) {
					maxLength = currentLength;
					maxStartIndex = startIndex;
				}
				currentLength = 0;
				startIndex = index + 1;
			}
			current = current.getNext();
			index++;
		}

		current = head;
		for (int i = 0; i < maxStartIndex; i++) {
			current = current.getNext();
		}
		for (int i = 0; i < maxLength; i++) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		System.out.println();
	}


	/*Q8*/
	public static boolean isRepeating(Node<Integer> l1, Node<Integer> l2) {
		Node<Integer> l1Pointer = l1;
		Node<Integer> l2Pointer = l2;

		while (l2Pointer != null) {
			if (!l2Pointer.getValue().equals(l1Pointer.getValue())) return false;

			l1Pointer = l1Pointer.getNext();
			l2Pointer = l2Pointer.getNext();

			if (l1Pointer == null) l1Pointer = l1; 
		}

		return l1Pointer == l1; 
	}

	/*Q9*/
	public static boolean containsSubsequence(Node<Integer> l1, Node<Integer> l2) {
	    Node<Integer> l2Pointer = l2;

	    while (l2Pointer != null) {
	        Node<Integer> l1Pointer = l1;
	        Node<Integer> temp = l2Pointer;

	        while (l1Pointer != null && temp != null && l1Pointer.getValue().equals(temp.getValue())) {
	            l1Pointer = l1Pointer.getNext();
	            temp = temp.getNext();
	        }

	        if (l1Pointer == null) return true;

	        l2Pointer = l2Pointer.getNext();
	    }

	    return false;
	}


	/*
	Q10 with array
	input: n
	function: 5n+23
	Order of magnitude: O(n)
	*/
	public static boolean containsOneToTenWithArray(Node<Integer> head) {
	    boolean[] seen = new boolean[10];
	    Node<Integer> current = head;

	    while (current != null) {
	        int value = current.getValue();
	        if (value >= 1 && value <= 10) {
	            seen[value - 1] = true;
	        }
	        current = current.getNext();
	    }

	    for (boolean found : seen) {
	        if (!found) return false;
	    }
	    return true;
	}

	/*
	Q10 without array
	input: n
	function: 50n+40
	Order of magnitude: O(n)
	*/
	public static boolean containsOneToTenWithoutArray(Node<Integer> head) {
	    for (int i = 1; i <= 10; i++) {
	        Node<Integer> current = head;
	        boolean found = false;

	        while (current != null) {
	            if (current.getValue() == i) {
	                found = true;
	                break;
	            }
	            current = current.getNext();
	        }

	        if (!found) return false;
	    }
	    return true;
	}
	
	/*Order of Magnitude:
	O(n) in both cases, but the constant is smaller for the version with the array.*/
	
	public static void main(String[] args) {

		int [] a = {5,6,5,5,4};
		int [] b = {1,2,3,7,8,11,12,10,5,6,5,5,6,5,5,6,4};
		Node<Integer> head1 = buildListFromArr(a);
		Node<Integer> head2 = buildListFromArr(b);
		System.out.println(containsOneToTenWithArray(head2));

	}	
}


