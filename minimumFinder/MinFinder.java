import java.util.Arrays;

public class MinFinder {
    public static void main (String[] args) {
        int[] array = {9,4,2,10,7,8,0,8,1,9};
        MinFinder finder = new MinFinder();

        for (int index = 0; index < 3; index++) {
            System.out.println("Index of the " + (index + 1) + " smallest element is " +
                                finder.findMinimum(array, index)
            );
        }
    }

    public int findMinimum (int[] array, int position) {
        if (position < array.length) {
            int index = 0;
            int[] sortedArray = array.clone();
            Arrays.sort(sortedArray);

            // From the sorted array we get the (position) minimum number then
            // get the index from the original array
            for (int number : array) {
                if (number == sortedArray[position]) { break; }
                index++;
            }

            return index;
        } else {
            throw new IllegalArgumentException("Position out of bounds");
        }
    }
}


/* -------------- OUTPUT --------------
Index of the 1 smallest element is 6
Index of the 2 smallest element is 8
Index of the 3 smallest element is 2 */