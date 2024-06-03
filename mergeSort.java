public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 34, 7, 23, 32, 5, 62 };
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) System.out.print(i + " ");
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
// Output:
// 5 7 23 32 34 62 
