package com.learning.sorting;

public class Sort {
    //Time Complexity: O(N2)
    //Auxiliary Space: O(1)
    public static void SelectionSort(int[] arr) {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[minIndx] > arr[j])
                    minIndx = j;
            // // Swap the found minimum element with the first element
            int temp = arr[minIndx];
            arr[minIndx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("selection sort ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    //Bubble Sort is the simplest sorting algorithm that works by repeatedly
// swapping the adjacent elements if they are in the wrong order.
    //Time Complexity: O(N2)
    //Auxiliary Space: O(1)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; i++) {
                if (arr[j] > arr[j + 1]) {
                    //
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble sort : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        //SelectionSort(arr);
       // bubbleSort(arr);
        Person person=new Person();
        person.setName("manoj");
        updateName(person);
        System.out.println("name:"+person.getName());

    }
    public static void updateName(Person person){
        person.setName("jon");
        person=null;

    }
}

class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
