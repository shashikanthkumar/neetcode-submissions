class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list=new ArrayList<Character>();
        int maxlength=0;
        int start=0,end=0;
        while(end<s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
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
