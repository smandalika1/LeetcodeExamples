public class SubSequence {
    public static void main(String args[]){
        String s="";
        String t="ahbgdc";
        SubSequence ss=new SubSequence();
        System.out.println(ss.isSubsequence(s,t));
    }

    public boolean isSubsequence(String s, String t) {
        int j=0;
        if(s==null | s=="" |t==null | t=="" ){
            return false;
        }

        if(s.length()<=0 && t.length()<=0){
            return true;
        }

        for(int i=0;i<t.length();i++){
            if(s.length()>0 && t.length()>0 && Character.compare(t.charAt(i),s.charAt(j))==0){
                j++;
            }

            if(s.length()==j){
                return true;
            }
        }

        return false;
    }
}
