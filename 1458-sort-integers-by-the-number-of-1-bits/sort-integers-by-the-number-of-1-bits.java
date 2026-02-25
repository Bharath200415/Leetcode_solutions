class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){

                if (Integer.bitCount(arr[i])>Integer.bitCount(arr[j])){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

                if (Integer.bitCount(arr[i])==Integer.bitCount(arr[j])){
                    if (arr[i]>arr[j]){
                        int temp2=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp2;
                    }
                }
            }
        }
        return arr;
    }
}