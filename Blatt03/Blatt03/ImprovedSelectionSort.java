public class ImprovedSelectionSort {

    public static void sort(int[] a) {
        // Implement me!
        for (int n = 0; n <= a.length/2 - 1; n++) {
            
            // /2 ist die Ganzzahldivision
            
            int min = 2147483647;
            int max = -2147483648;
            int minInd = n;
            int maxInd = a.length - n - 1;
            
            for (int i = n; i <= a.length - n - 1; i++) {
                
                if (a[i] <= min) {
                    min = a[i];
                    minInd = i;
                } 
                
                if (a[i] >= max) {
                    max = a[i];
                    maxInd = i;
                }
                
            }
            int temp1 = a[n];
            a[n] = a[minInd];
            a[minInd] = temp1;
            int temp2 = a[a.length - n - 1];
            a[a.length - n - 1] = a[maxInd];
            a[maxInd] = temp2;
            
        }
    }

}
