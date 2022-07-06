import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LongestPallindrome {
    public static void main(String args[]){
        LongestPallindrome lp=new LongestPallindrome();
        System.out.println(lp.longestPalindrome("ababababa"));
    }

    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.get(ch)==null){
                hm.put(ch,1);
            }else{
                hm.put(ch,hm.get(ch)+1);
            }
        }
        int length=0;
        boolean singlevalue=false;
        System.out.println(hm);

        for(Map.Entry<Character,Integer> entry:hm.entrySet()){
            if(hm.size()==1){
                return entry.getValue();
            }
            if(entry.getValue()==1 || (entry.getValue()%2!=0)){
                singlevalue=true;
            }
            length=length+((entry.getValue()/2)*2);
        }
        if(singlevalue){
            length=length+1;
        }
        return length;
    }
}
