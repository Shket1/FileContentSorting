import java.util.Arrays;

public class MergeSort {
    public int[] merge(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length <= 1) {
            return arr;
        }

        int[] arrLeft = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arrRight = Arrays.copyOfRange(arr, arrLeft.length, arr.length);

        return mergeSort(merge(arrLeft), merge(arrRight));
    }

    public String[] merge(String[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length <= 1) {
            return arr;
        }

        String[] arrLeft = Arrays.copyOfRange(arr, 0, arr.length / 2);
        String[] arrRight = Arrays.copyOfRange(arr, arrLeft.length, arr.length);

        return mergeSort(merge(arrLeft), merge(arrRight));
    }

    private int[] mergeSort(int[] arrLeft, int[] arrRight) {
        int[] res = new int[arrLeft.length + arrRight.length];
        int leftIndex = 0, rightIndex = 0, resIndex = 0;

        while (leftIndex < arrLeft.length && rightIndex < arrRight.length) {
            if (arrLeft[leftIndex] < arrRight[rightIndex]) {
                res[resIndex++] = arrLeft[leftIndex++];
            } else {
                res[resIndex++] = arrRight[rightIndex++];
            }
        }
        while (resIndex < res.length) {
            if (leftIndex != arrLeft.length) {
                res[resIndex++] = arrLeft[leftIndex++];
            } else {
                res[resIndex++] = arrRight[rightIndex++];
            }
        }
        return res;
    }

    private String[] mergeSort(String[] arrLeft, String[] arrRight) {
        String[] res = new String[arrLeft.length + arrRight.length];
        int leftIndex = 0, rightIndex = 0, resIndex = 0;

        while (leftIndex < arrLeft.length && rightIndex < arrRight.length) {
            if (arrLeft[leftIndex].compareToIgnoreCase(arrRight[rightIndex]) < 0) {
                res[resIndex++] = arrLeft[leftIndex++];
            } else {
                res[resIndex++] = arrRight[rightIndex++];
            }
        }
        while (resIndex < res.length) {
            if (leftIndex != arrLeft.length) {
                res[resIndex++] = arrLeft[leftIndex++];
            } else {
                res[resIndex++] = arrRight[rightIndex++];
            }
        }
        return res;
    }
}
