import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IndexAscendingSorter {
    public static void main (String[] args) {
        int[] array = {9,4,2,10,7,8,0,8,1,1,1,9};
        IndexAscendingSorter finder = new IndexAscendingSorter();
        int[] indixes = finder.orderIndexAscending(array);

        System.out.println("Indexes of the array in ascending order: " +
                            Arrays.toString(indixes));
    }

    /**
     * Returns the indexes of the input array in ascending order.
     * @param array Array from the one, get the indexes.
     * @return Array with the indexes in ascending order.
     */
    public int[] orderIndexAscending(int[] array) {
        int[] minimumIndexes = new int[array.length];
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        Set<Integer> savedIndexes = new HashSet<>();

        for (int index = 0; index < array.length; index++){
            int minIndex = 0;
            // Add the index in ascending order, we need to keep the indexes already
            // saved, so won't miss indexes from repeted values
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
Indexes of the array in ascending order: [6, 8, 9, 10, 2, 1, 4, 5, 7, 0, 11, 3]
 ---------------------------------------*/