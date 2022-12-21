public class Fibonacci{
  public static int calculateIterative(int n){
    int nextValue=1;
    int value=0;
    for(int i=0;i<n;++i){
        int temp=nextValue;
        nextValue=value+nextValue;
        value=temp;
    }
    return value;
  }
     
  public static int calculateRecursive(int n){
    return recursiveHelp(n,1,0);
  }
  private static int recursiveHelp(int n,int current,int prev){
    if(n==0){
      return prev;
    }
    return recursiveHelp(n-1, current+prev,current);
  }


}
