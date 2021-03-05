
import java.util.Random;
import BubbleSorter;
import InsertionSorter;
import SelectionSorter;
import java.util.logging.*;
 
class SortTest {

    private static Logger logger = Logger.getLogger(SortTest.class.getName());

 

    // 5. Fast Sort
    public static int partition(int[] array, int begin, int end) {  
        int pivot = end;
    
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
    
        return counter;
    }
    
    public static void quickSort(int[] array, int begin, int end) {  
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }


    // Array checker that it is sorted
    public static int sortChecker(int[] array) {  
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1])
            {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arrayToSort = random.ints(100000, 10,100000).toArray();
// **************** Bubble Sort
        int[]  array = arrayToSort.clone();

        long before = System.currentTimeMillis();

        BubbleSorter.sort(array);
        
        long after = System.currentTimeMillis();
        
        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Bubble Sort Time: {0}", (after - before));

// **************** Insertion Sort
        array = arrayToSort.clone();

        before = System.currentTimeMillis();

        InsertionSorter.sort(array);
        
        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Insertion Sort Time: {0}", (after - before));
// **************** Selection Sort
        array = arrayToSort.clone();

        before = System.currentTimeMillis();

        SelectionSorter.sort(array);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Selection Sort Time: {0}", (after - before));
// **************** Merge Sort
        array = arrayToSort.clone();

        before = System.currentTimeMillis();

        MergeSorter.sort(array);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Merge Sort Time: {0}", (after - before));
// **************** Quick Sort
        array = arrayToSort.clone();

        before = System.currentTimeMillis();

        quickSort(array, 0, array.length-1);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Quick Sort Time: {0}", (after - before));
// ****************
    }
}
