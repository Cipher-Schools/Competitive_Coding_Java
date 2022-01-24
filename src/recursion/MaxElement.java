package recursion;


public class MaxElement {

    public static int maximumElement(int arr[], int index) {

        if(index == arr.length - 1) {
            return arr[arr.length - 1];
        }

        int currentMax = arr[index];

        int recursionMaxAns =
                maximumElement(arr, index + 1);

        currentMax = Math.max(currentMax, recursionMaxAns);

        return currentMax;

    }

    public static void main(String[] args) {

        int [] arr = {5, 4, 6, 14, 10};

        System.out.println(maximumElement(arr, 0));
    }
}
