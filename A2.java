/*

- @Anirudha Verma
- 20128760
- Feb 9, 2020
- Assignment 2 - CISC 235

- I confirm that this submission is my own work and is consistent with the Queen's regulations on Academic Integrity.
 */

import java.util.Collections;

class assignment2
{
    static class stack {
        private int[] array;
        public int top;
        private int capacity;

        // Create stack
        public stack() {
            array = new int[10];
            top = -1;
            capacity = 10;
        }

        // Push into stack
        public void push(int data) {
            if (capacity == top + 1) {
                // expand stack if full
                expandStack();
            }

            // push data
            array[++top] = data;
        }

        // Expanding the stack by 2
        public void expandStack()
        {
            int currentSize = top + 1;

            // Expand by multiplying the current size by 2
            int[] newArray = new int[currentSize * 2];

            // Copying elements of the previous array into the new array with a bigger capacity
            for (int i=0; i<currentSize; i++)
            {
                newArray[i] = array[i];
            }

            // Making the new extended array the normal array
            array = newArray;
            capacity = newArray.length;
        }

        // Popping the element on top of the stack
        public int pop()
        {

            if (isEmpty())
            {
                System.out.println("Stack is empty");
                return -1;
            }

            // Pop stack
            else {
                int temp = array[top];
                top = top - 1;
                return temp;
            }
        }

        // Checking if the stack is empty
        public boolean isEmpty()
        {
            if (top == -1)
                return true;
            else
                return false;
        }

        // Displaying the stack
        public void display()
        {
            // Reversing the current array
            int currentSize = top + 1;

            int[] newArray = new int[currentSize];

            for (int i=0; i<currentSize; i++)
            {
                newArray[i] = array[currentSize - 1 - i];
            }

            // Displaying the stack
            for (int i = 0; i <= top; i++)
            {
                System.out.print(newArray[i] + " ");
            }
        }

    }

    // Function 1
    public static void function1(int n)
    {
        stack resultStack = new stack();
        stack tempStack = new stack();
        int current;

        tempStack.push(n);

        while (!tempStack.isEmpty())
        {
            current = tempStack.pop();

            if (current > 1)
            {
                if (current % 2 == 0)
                {
                    tempStack.push(current/2);
                }
                else
                {
                    tempStack.push(3*current + 1);
                }
            }

            resultStack.push(current);
        }

        resultStack.display();
    }

    // Function 2
    public static void function2(int n)
    {
        stack resultStack = new stack();
        stack tempStack = new stack();
        int current;

        tempStack.push(n);

        while (!tempStack.isEmpty())
        {
            current = tempStack.pop();

            if (current >= 6)
            {
                tempStack.push(current/3);
                tempStack.push((2 * current)/3);
            }
            resultStack.push(current);
        }

        resultStack.display();
    }


    // Function 3
    public static void function3(int a, int b)
    {
        stack resultStack = new stack();
        stack tempStack = new stack();
        stack tempStack2 = new stack();

        tempStack.push(a);
        tempStack2.push(b);

        while(!tempStack.isEmpty())
        {
            a = tempStack.pop();
            b = tempStack2.pop();

            if (a <= b)
            {
                tempStack.push(a);
                tempStack2.push((a+b)/2 - 1);

                tempStack2.push(b);
                tempStack.push((a+b)/2 + 1);

                resultStack.push((a+b)/2);

            }
        }

        resultStack.display();
    }


    // Function 4
    public static void function4(int a, int b)
    {
        stack resultStack = new stack();
        stack tempStack = new stack();
        stack tempStack2 = new stack();

        tempStack.push(a);
        tempStack2.push(b);

        while(!tempStack.isEmpty())
        {
            a = tempStack.pop();
            b = tempStack2.pop();

            if (a <= b)
            {
                tempStack.push(a);
                tempStack2.push((a+b)/2 - 1);

                resultStack.push((a+b)/2);

                tempStack2.push(b);
                tempStack.push((a+b)/2 + 1);
            }
        }

        resultStack.display();
    }

    // Recursive Function 1
    public static void recursiveFunction1(int n)
    {
        if (n > 1)
        {
            if (n % 2 == 0)
                recursiveFunction1(n / 2);

            else
                recursiveFunction1(3 * n + 1);

        }

        System.out.print(n + " ");
    }

    // Recursive Function 2
    public static void recursiveFunction2(int n) {
        if (n >= 6) {
            recursiveFunction2(n / 3);
            recursiveFunction2(2 * n / 3);
        }
        System.out.print(n + " ");
    }

    // Recursive Function 3
    public static void recursiveFunction3(int a, int b){
        if (a <= b){
            int m = (a + b) / 2;
            recursiveFunction3(a, m-1);
            System.out.print(m + " ");
            recursiveFunction3(m + 1, b);
        }
    }

    // Recursive Function 4
    public static void recursiveFunction4(int a, int b){
        if (a <= b){
            int m = (a + b) / 2;
            recursiveFunction4(a, m-1);
            recursiveFunction4(m + 1, b);
            System.out.print(m + " ");
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        assignment2 ass2 = new assignment2();

        System.out.println("\nFunction 1");
        int[] func1 = {7, 18, 19, 22, 105};
        for (int i = 0; i < func1.length; i++)
        {
            ass2.function1(func1[i]);
            System.out.println("");
            recursiveFunction1(func1[i]);
            System.out.println("\n--------------------------");
        }

        System.out.println("\nFunction 2");
        int[] func2 = {7, 18, 19, 22, 43};
        for (int i = 0; i < func2.length; i++)
        {
            ass2.function2(func2[i]);
            System.out.println("");
            recursiveFunction2(func2[i]);
            System.out.println("\n--------------------------");

        }

        System.out.println("\nFunction 3");
        int[][] func3 = {{0,7}, {1,18}, {4,19}, {-1,22}};
        for (int i = 0; i < func3.length; i++)
        {
            ass2.function3(func3[i][0],func3[i][1]);
            System.out.println("");
            recursiveFunction3(func3[i][0],func3[i][1]);
            System.out.println("\n--------------------------");
        }

        System.out.println("\nFunction 4");
        int[][] func4 = {{0,7}, {1,18}, {4,19}, {-1,22}};
        for (int i = 0; i < func4.length; i++)
        {
            ass2.function4(func4[i][0],func4[i][1]);
            System.out.println("");
            recursiveFunction4(func4[i][0],func4[i][1]);
            System.out.println("\n--------------------------");

        }
    }
}
