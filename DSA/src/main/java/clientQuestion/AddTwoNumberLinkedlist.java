package clientQuestion;

public class AddTwoNumberLinkedlist {
    static LinkedList addTwoLists(LinkedList first,
                                  LinkedList second)
    {
        int num1 = 0, num2 = 0;
        while (first.head != null) {
            num1 = num1 * 10 + first.head.data;
            first.head = first.head.next;
        }
        while (second.head != null) {
            num2 = num2 * 10 + second.head.data;
            second.head = second.head.next;
        }
        int num3 = num1 + num2;
        LinkedList temp = new LinkedList();
        while (num3 != 0) {
            int last = num3 % 10;
            temp.push(last);
            num3 = num3 / 10;
        }
        return temp;
    }
    public static void main(String[] args)
    {
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();
        first.push(6);
        first.push(4);
        first.push(9);
        first.push(5);
        first.push(7);

        second.push(4);
        second.push(8);

        LinkedList ans = addTwoLists(first, second);

        System.out.print("Sum is : ");
        ans.printList();
    }
}

class LinkedList {
    Node head;

    LinkedList() { head = null; }

    void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}