
import java.util.Random;
import java.util.logging.*;

class SortTest {

    private static Logger logger = Logger.getLogger(SortTest.class.getName());

    // 1. Bubble sort
    public static void bubbleSort(int[] array) {  
        boolean sorted = false;
        int temp;
        int count = 1;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - count; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
            count++;
        }
    }
// ewddwde
    // 2. Insertion Sort
    public static void insertionSort(int[] array) {  
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }
     
    // 3. Selection Sort
    public static void selectionSort(int[] array) {  
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
    }

    // 4. Merge Sort
    public static void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;
    
        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];
    
        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];
    
        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;
    
        // копируем из leftArray и rightArray обратно в массив  
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void mergeSort(int[] array, int left, int right) {  
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

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


    // Array checker that is is sorted
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
// ****************        
        int[] array = random.ints(100000, 10,100000).toArray();

        long before = System.currentTimeMillis();

        bubbleSort(array);
        
        long after = System.currentTimeMillis();
        
        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Bubble Sort Time: {0}", (after - before));

// ****************
        array = random.ints(100000, 10,100000).toArray();

        before = System.currentTimeMillis();

        insertionSort(array);
        
        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Insertion Sort Time: {0}", (after - before));
// ****************
        array = random.ints(100000, 10,100000).toArray();

        before = System.currentTimeMillis();

        selectionSort(array);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Selection Sort Time: {0}", (after - before));
// **************** mergeSort
        array = random.ints(100000, 10,100000).toArray();

        before = System.currentTimeMillis();

        mergeSort(array, 0, array.length-1);

        after = System.currentTimeMillis();

        if (sortChecker(array) < 0)
        {
            logger.log(Level.WARNING, "=== BUG FOUND ===");
        }

        logger.log(Level.INFO, "Merge Sort Time: {0}", (after - before));
// **************** quickSort
        array = random.ints(100000, 10,100000).toArray();

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
// First Version


