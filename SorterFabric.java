
class SorterFabric{

    private SorterFabric(){}

    public static void getSortByType(SorterTypeEnum types, int[] array)
    {
        switch (types) {
            case BUBBLE: 
                BubbleSorter.sort(array);
                break;
            case INSERTION: 
                InsertionSorter.sort(array);
                break;
            case SELECTION: 
                SelectionSorter.sort(array);
                break;
            case MERGE: 
                MergeSorter.sort(array);
                break;
            case QUICK: 
                QuickSorter.sort(array);
                break;
        }
    }
}
