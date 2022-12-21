public class SelectionSort {

    public static void sort(int[] a) {
        // Implement me!
        for (int n = 0; n <= a.length - 2; n++) {
            
            int min = 2147483647;
            int minInd = n;
            
            for (int i = n; i <= a.length - 1; i++) {
                
                if (a[i] <= min) {
                    min = a[i];
                    minInd = i;
                } 
                
            }
            int temp = a[n];
            a[n] = a[minInd];
            a[minInd] = temp;
            
        }

    }
}