package linkedlistqueue;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test 1: PUSH
        Queue<Integer> q = new LinkedListQueue<Integer>();

        q.push(132); // Pushed first
        q.push(12);
        q.push(54);
        q.push(95);
        q.push(1);
        q.push(2);
        q.push(9);
        q.push(13);
        q.push(515);
        q.push(956);

        System.out.println("TESTING PUSH");
        System.out.println("Queue is " + q);
        System.out.println("Size: " + q.size());
        System.out.println("Size must be: 10");
        System.out.println("Peek: " + q.peek());
        System.out.println("Peek must be: 132");
        System.out.println("Empty? " + q.empty());
        System.out.println("Empty? must be: false");
        System.out.println();

        // Test 2: POP
        q.pop();
        q.pop();
        q.pop();
        System.out.println("TESTING POP");
        System.out.println("Queue is " + q);
        System.out.println("Size: " + q.size());
        System.out.println("Size must be: 7");
        System.out.println("Peek: " + q.peek());
        System.out.println("Peek must be: 95");
        System.out.println("Empty? " + q.empty());
        System.out.println("Empty? must be: false");
        System.out.println();

        // Test 3: CLEAR
        q.clear();
        System.out.println("TESTING CLEAR");
        System.out.println("Queue is " + q);
        System.out.println("Size: " + q.size());
        System.out.println("Size must be: 0");
        System.out.println("Empty? " + q.empty());
        System.out.println("Empty? must be: true");
        System.out.println();

        // Test 4: PUSH
        q.push(13);
        System.out.println("TESTING PUSH (1 element pushed)");
        System.out.println("Queue is " + q);
        System.out.println("Size: " + q.size());
        System.out.println("Size must be: 1");
        System.out.println("Peek: " + q.peek());
        System.out.println("Peek must be: 13");
        System.out.println("Empty? " + q.empty());
        System.out.println("Empty? must be: false");
        System.out.println();

        // Test 5: POP
        q.pop();
        System.out.println("TESTING POP (1 element popped)");
        System.out.println("Queue is " + q);
        System.out.println("Size: " + q.size());
        System.out.println("Size must be: 0");
        System.out.println("Empty? " + q.empty());
        System.out.println("Empty? must be: true");
        System.out.println();

        // Checking the unchecked exceptions for POP
        try {
            q.pop();
        } catch (Exception e) {
            System.out.println(e);
        }
        // Checking the unchecked exceptions for PEEK
        try {
            q.peek();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
