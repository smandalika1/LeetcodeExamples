import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static void main(String args[]){
        String s1="egg";
        String s2="add";
        IsomorphicString IS=new IsomorphicString();
        System.out.println(IS.isIsomorphic(s1,s2));

    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        HashMap<Character,Character> hm=new HashMap<Character,Character>();
        int len=s.length();
        for(int i=0;i<len;i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);

            if((hm.containsKey(c1) && Character.compare(hm.get(c1),c2)!=0 )
            || (hm.containsValue(c2)&& Character.compare(getByValue(hm,c2),c1)!=0)
            ){

                return false;
            }
            hm.put(s.charAt(i),t.charAt(i));
        }
        return true;
    }
    private Character getByValue(HashMap<Character,Character> hm,char ch){
        for(Map.Entry<Character,Character> entry:hm.entrySet()){
            if(Character.compare(entry.getValue(),ch)==0){
                return entry.getKey();
            }
        }
        return null;
    }
}
