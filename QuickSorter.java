
class QuickSorter extends Sorter {
 
    private QuickSorter(){}

    public static void sort(int[] array) {  
        quickSort(array, 0, array.length-1);
    }

    private static int partition(int[] array, int begin, int end) {  
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
    
    private static void quickSort(int[] array, int begin, int end) {  
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
}