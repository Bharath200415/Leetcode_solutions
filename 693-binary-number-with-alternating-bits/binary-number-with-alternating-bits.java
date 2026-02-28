class Solution {
    public boolean hasAlternatingBits(int n) {
          if(n==1){
            return true ;
        }


       
        String bin=intToBin(n);
        char first=bin.charAt(0);
        char sec=bin.charAt(1);
          if(first==sec){
            return false;
        }


       
        for(int i=2;i<bin.length();i++){
            if(i%2==0){
                if(!(bin.charAt(i)==first)){
                    return false;
                }
            }
            else{
                if(!(bin.charAt(i)==sec)){
                    return false;
                }

            }
            
        }
        return true;

        
    }
    public String intToBin(int n) {
        StringBuilder bin = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            bin.append((char) (rem + '0'));
            n = n / 2;
        }
        return bin.reverse().toString();
    }
}