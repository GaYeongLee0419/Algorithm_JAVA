package BinarySearch;

public class binarySearch {

    public int binarySearch(int[] arr, int target, int start, int end){

        int mid;
        while (start <= end) {
            mid = (int)(start + end) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }


}
