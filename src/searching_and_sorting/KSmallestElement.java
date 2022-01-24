package searching_and_sorting;


public class KSmallestElement {

    /**
     * T.C - O(nk) //
     * @param arr
     * @param k
     */
    public static void printKSmallestVideos(int[] arr, int k) {
        //Assume first k elements are smallest

        if(k == arr.length) {
            return;
        }

        for (int i = k; i < arr.length; i++) {

            int max = arr[k - 1];
            int maxPosition = k - 1;

            for (int j = k - 2; j >= 0; j--) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxPosition = j;
                }
            }

            int currentElement = arr[i];

            if (max > currentElement) {

                int m = maxPosition;

                while (m < k - 1) {
                    arr[m] = arr[m + 1];
                    m++;
                }
                arr[k - 1] = currentElement;

            }
        }

        for(int i = 0; i < k; i++) {
            System.out.println(arr[i]  + " ");

        }

    }

    public static void main(String[] args) {

        int [] arr = {300, 400, 250, 100, 800};

        printKSmallestVideos(arr, 3);
    }
}
