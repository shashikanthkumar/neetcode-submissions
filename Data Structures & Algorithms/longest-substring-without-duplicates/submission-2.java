class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list=new ArrayList<Character>();
        int start=0,end=0, maxlength=0;
        while(end<s.length()){
            char a=s.charAt(end);
            if(!list.contains(a)){
                list.add(a);
                end++;
                maxlength=Math.max(maxlength,list.size());
            }
            else{
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return maxlength;
    }
}
