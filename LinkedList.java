public class LinkedList { // Declare a public class named LinkedList
    Node head;
    public int size;

    LinkedList() { // Constructor for the LinkedList class
        size = 0;
    }

    public class Node { // Declare a public inner class named Node. This represents a node in the linked list
        String data; // Declare a String variable 'data'. This will hold the data of the node
        Node next;   // Declare a variable 'next' of type Node. This will point to the next node in the linked list

        Node(String data) { // Constructor for the Node class
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Method to add a new node with the given data to the end of the list
    //Time complexity: O(n)
    //Space  complexity: O(1)
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) { // Traverse the linked list until the end
                current = current.next; // Move to the next node
            }
            current.next = newNode; // Add the new node at the end of the linked list
        }
    }
    //Time complexity: O(n)
    //Space complexity: O(1)
    public void printList() { // Method to print the contents of the linked list
        Node currNode = head;

        while(currNode != null) { // Traverse the linked list until the end
            System.out.print("\n<"+currNode.data + ">");
            currNode = currNode.next; // Move to the next node
        }
    }

    //Time complexity: O(n)
    //Space  complexity: O(1)
    public void deleteNode(int position) { // Method to delete a node at the given position
        if (head == null)
            return;

        Node temp = head;
        if (position == 0) {
            head = temp.next; // Make the next node the head of the linked list
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++) // Traverse the linked list until the given position
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;
        Node next = temp.next.next; // Get the node after the node to be deleted
        temp.next = next;
    }
    //Time complexity: O(1)
    //Space  complexity: O(1)
    public int size() { // Method to get the size of the linked list
        return size; // Return the size of the linked list
    }

    //Time complexity: O(n)
    //Space  complexity: O(1)
    public String get(int index) { // Method to get the data at a specific index
        Node current = head;
        for (int i = 0; i < index; i++) { // Traverse the linked list until the given index
            current = current.next;
        }
        return current.data;
    }

    //Time complexity: O(nlog n)
    //Space complexity: O(log n)
    public Node mergeSort(Node head) { // Method to sort the linked list using merge sort
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head); // Get the middle node of the linked list
        Node nextOfMiddle = middle.next;

        middle.next = null; // Split the linked list into two halves
        Node left = mergeSort(head); // Sort the first half of the linked list
        Node right = mergeSort(nextOfMiddle);
        Node sortedList = merge(left, right);
        return sortedList;
    }

    //Time complexity: O(n)
    //Space  complexity: O(n)
    public Node merge(Node left, Node right) { // Helper method to merge two sorted linked lists
        Node result = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // If the data of the left node is less than or equal to the data of the right node
        if (left.data.compareTo(right.data) <= 0) {
            result = left; // Add the left node to the result
            result.next = merge(left.next, right);
        } else {
            result = right; // Add the right node to the result
            result.next = merge(left, right.next);
        }
        return result;
    }

    //Time complexity: O(n)
    //Space  complexity: O(1)
    public Node getMiddle(Node head) { // Helper method to find the middle node of a linked list
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head; // Initialize two pointers, slow and fast, to the head of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // Move the slow pointer one step
            fast = fast.next.next; // Move the fast pointer two steps
        }
        return slow;
    }
}



