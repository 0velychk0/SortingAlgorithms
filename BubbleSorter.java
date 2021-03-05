
class BubbleSorter extends Sorter {
 
    private BubbleSorter(){}

    public static void sort(int[] array) {  
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
}