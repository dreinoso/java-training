import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IndexAscendingSorter {
    public static void main (String[] args) {
        int[] array = {9,4,2,10,7,8,0,8,1,1,1,9};
        IndexAscendingSorter finder = new IndexAscendingSorter();
        int[] indixes = finder.orderIndexAscending(array);

        System.out.println("Indexes in ascending order of the array: " + Arrays.toString(indixes));
    }

    public int[] orderIndexAscending(int[] array) {
        int[] minimumIndexes = new int[array.length];
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        Set<Integer> savedIndexes = new HashSet<>();
        for (int index = 0; index < array.length; index++){
            int minIndex = 0;
            // From the sorted array we get the (position) minimum number then
            // get the index from the original array
            for (int number : array) {
                if (number == sortedArray[index] && !savedIndexes.contains(minIndex)) { 
                    savedIndexes.add(minIndex);
                    minimumIndexes[index] = minIndex;
                    break;
                }
                minIndex++;
            }
        }
        return minimumIndexes;
    }
}


/* -------------- OUTPUT --------------
Index of the 1 smallest element is 6
Index of the 2 smallest element is 8
Index of the 3 smallest element is 2 */