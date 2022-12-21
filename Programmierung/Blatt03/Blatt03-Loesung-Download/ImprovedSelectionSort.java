public class ImprovedSelectionSort {

    public static void sort(int[] a) {
        int len = a.length;
        int i_min, i_max, min, max, tmp;
        for (int i = 0; i < len/2; i++) {
            i_min = i;
            i_max = i;
            min = a[i];
            max = a[i];
            for (int j = i+1 ; j < len - i; j++) {
                if (min > a[j]) {
                    min = a[j];
                    i_min = j;
                }
                if (max < a[j]) {
                    max = a[j];
                    i_max = j;
                }
            }
            
            tmp = a[i];
            a[i] = a[i_min];
            a[i_min] = tmp;
            
            if (i == i_max) {
                i_max = i_min;
            }
            
            tmp = a[len - (i + 1)];
            a[len - (i + 1)] = a[i_max];
            a[i_max] = tmp;
        }
    }

}
