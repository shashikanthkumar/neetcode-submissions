class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> count1=new HashMap<>();
       for(char c:s1.toCharArray()){
            count1.put(c,count1.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> count2 = new HashMap<>();
        int windowSize = s1.length();
        for(int end=0;end<s2.length();end++){
            char c=s2.charAt(end);
            count2.put(c,count2.getOrDefault(c,0)+1);
            if(end>=windowSize){
                char leftchar=s2.charAt(end-windowSize);
                count2.put(leftchar,count2.get(leftchar)-1);
                if(count2.get(leftchar)==0){
                    count2.remove(leftchar);
                }
            }
            if(count1.equals(count2)){
                return true;
            }
        }
        return false;
    }
}
