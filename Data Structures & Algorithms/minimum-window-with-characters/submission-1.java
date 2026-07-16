class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> count1=new HashMap<>();
        for(char c:t.toCharArray()){
            count1.put(c,count1.getOrDefault(c,0)+1);
        }
        //frequency of first string characters
        HashMap<Character,Integer> count2=new HashMap<>();
        //frequency of Second string characters

        int windowsize=t.length()-1;
        //window size to keep attention
        int have=0, need=count1.size();
        int resLen=Integer.MAX_VALUE;
        int reStart=0;
        int start=0;
        for(int end=0;end<s.length();end++){
            char c=s.charAt(end);
            count2.put(c,count2.getOrDefault(c,0)+1);
            if(count1.containsKey(c)&& count2.get(c).intValue()==count1.get(c).intValue()){
                have++;
            }
            while(have==need){
                if(end-start+1<resLen){
                    resLen=end-start+1;
                    reStart=start;
                }
                char leftChar=s.charAt(start);
                count2.put(leftChar,count2.get(leftChar)-1);
                if(count1.containsKey(leftChar)&&count2.get(leftChar)<count1.get(leftChar)){
                    have--;
                }
                start++;

            }
        }
        return resLen==Integer.MAX_VALUE?"":s.substring(reStart,reStart+resLen);
    }
}
