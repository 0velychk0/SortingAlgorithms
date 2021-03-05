
import java.util.Random;
import java.util.logging.*;
 
class SortTest {

    private static Logger logger = Logger.getLogger(SortTest.class.getName());

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

        QuickSorter.sort(array);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Quick Sort Time: {0}", (after - before));
// ****************
    }
}
