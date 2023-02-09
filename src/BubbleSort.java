import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static int[] createRandomArray(int arrayLength) {
        int length = arrayLength;
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Unsorted Array: " + Arrays.toString(array));
        return array;
    }
    
    public static void writeArrayToFile(int[] array, String filename) {
        try (FileWriter fileWriter = new FileWriter("UnsortedArray.txt")) {
            for (int i = 0; i < array.length; i++) {
                fileWriter.write(array[i] + "\n");
            }
        } catch (IOException e) {
        }
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                arrayList.add(Integer.parseInt(s));
            }
            scanner.close();
        } catch (IOException e) {
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
        }

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void writeSortedArrayToFile(int[] array, String filename) {
        try (FileWriter fileWriter = new FileWriter("SortedArray.txt")) {
            for (int i = 0; i < array.length; i ++) {
                fileWriter.write(array[i] + "\n");
            }
        } catch (IOException e) {
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the array length:");
        writeArrayToFile(createRandomArray(scanner.nextInt()), "UnsortedArray.txt");
        int [] array = readFileToArray("UnsortedArray.txt");
        bubbleSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
        writeSortedArrayToFile(array, "SortedArray.txt");
        scanner.close();
    }
}