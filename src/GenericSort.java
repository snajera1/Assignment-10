import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericSort {

    public static <E extends Comparable<E>> void merge(E[] list, int start, int middle, int end) { //Function to sort and merge arrays with a generic parameter declared
        int i = start; // Establishes variables to track where the loops are located while iterating through the split arrays
        int j = middle;
        List<E> tempArr = new ArrayList<E>();
        while (i < middle && j < end) { //While loop that goes through an array in two halves, comparing the values in the two halves
            if (list[i].compareTo(list[j]) <= 0) { //if list[i] is bigger than list[j], the compareTo will return a positive integer
                tempArr.add(list[i]); //Adds value to the temp arraylist
                i++;
            } else {
                tempArr.add(list[j]); //Else, the larger value from the second half gets added to the temp arraylist
                j++;
            }
        }

        while (i < middle) { //Adds any remaining values in the first half to the temp arraylist if the while loop ended early
            tempArr.add(list[i]);
            i++;
        }

        while(j < end) { //Adds any remaining numbers in the second half to the temp arraylist
            tempArr.add(list[j]);
            j++;
        }

        for (i = start; i < end; i++) { //Copies the contents of the temp arraylist to the main array
            list[i] = tempArr.get(i - start);
        }
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list) { //Function that uses overloading to call the mergeSort function with more parameters, established with generic type parameter
        mergeSort(list, 0, list.length);

    }

    public static <E extends Comparable<E>> void mergeSort(E[] list, int start, int end) { //Function that uses recursive calls and calls of merge to preform merge sort, uses generic type parameter E
        if (end - start <= 1) //If the array is less than or equal to 1, return nothing as the array cannot be sorted
            return;
        int middle = (start + end) / 2; //Calculates where the middle of the array is
        mergeSort(list, start, middle); //Recursive calls to split the array down the middle
        mergeSort(list, middle, end);
        merge(list, start, middle, end); //Uses the merge function to combine the arrays 
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] arr) { //Function to perform the bubble sort method with a generic type parameter

        boolean swapped; //Creates a boolean variable to tell if a pair of integers have already been swapped/sorted
        for (int i = 0; i < arr.length; i++) { //Outer loop controls how many times the loop will be passed over
            swapped = false; //Resets the swapped variable to false
            for (int j = 0; j < arr.length - 1; j++) { //Inner loop passes over array and compares each array index with the index after it to determine if it needs to be swapped/sorted
                if (arr[j].compareTo(arr[j + 1]) > 0) { //If arr[j] is bigger than arr[j + 1], comparesTo returns a positive integer, swaps the two of them 
                    E temp = arr[j]; //Establishes a temp variable of generic type E
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; //Sets the swapped variable to true
                }
            }

            if (!swapped) { //Checks if swapped was never changed to true, if so then ends the outer loop early
                break;
            }
        }
    }

public static void main(String[] args) {
    String[] list = new String[6]; //Establishes two identical arrays of strings and integers to show how both sorting methods work with multiple data types
    list[0] = ("b");
    list[1] = ("a");
    list[2] = ("c");
    list[3] = ("f");
    list[4] = ("e");
    list[5] = ("d");

    Integer[] listInt = new Integer[6];
    listInt[0] = 6;
    listInt[1] = 4;
    listInt[2] = 1;
    listInt[3] = 3;
    listInt[4] = 2;
    listInt[5] = 5;

    String[] list1 = new String[6];
    list1[0] = ("b");
    list1[1] = ("a");
    list1[2] = ("c");
    list1[3] = ("f");
    list1[4] = ("e");
    list1[5] = ("d");

    Integer[] listInt1 = new Integer[6];
    listInt1[0] = 6;
    listInt1[1] = 4;
    listInt1[2] = 1;
    listInt1[3] = 3;
    listInt1[4] = 2;
    listInt1[5] = 5;

    System.out.println("These two String and Integer arrays are sorted by the same merge sort set of methods:"); 
    System.out.println(Arrays.toString(list));
    mergeSort(list);
    System.out.println(Arrays.toString(list));
    System.out.println(Arrays.toString(listInt));
    bubbleSort(listInt);
    System.out.println(Arrays.toString(listInt));

    System.out.println("These two String and Integer arrays are sorted by the same bubble sort method: ");
    System.out.println(Arrays.toString(list1));
    bubbleSort(list1);
    System.out.println(Arrays.toString(list1));
    System.out.println(Arrays.toString(listInt1));
    bubbleSort(listInt1);
    System.out.println(Arrays.toString(listInt1));
}

}

