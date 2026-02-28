class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0 , next = 1 ,count = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                next++;
            }else{
                count += Math.min(prev , next);
                prev = next;
                next = 1;
            }
        }
        return count + Math.min(prev , next);       
    }
}