import java.util.*;

public class HashMapUtil {

    public static void main(String args[]){
        int[] arr = new int[] {2,1,1,3,3,3};
        int k = 3;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){

            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        //System.out.println(hm);
        List< Map.Entry<Integer,Integer>> list= new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());

        Collections.sort(
                list,new Comparator<Map.Entry<Integer,Integer> > (){
                    public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer>o2){
                            return o1.getValue().compareTo(o2.getValue());
                    }
        }
        );

        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        //System.out.println(temp);
        for(Map.Entry<Integer,Integer> element:temp.entrySet()){
        //temp.forEach((key,v)->{
            if(k==0){
                break;
            }

            int value=element.getValue();
            if(value==1){
                hm.remove(element.getKey());
                k--;
            }
            else{
                if(k>=value){
                    hm.remove(element.getKey());
                    k=k-value;

                }else{
                    hm.put(element.getKey(),value-k);

                }

            }

        }
        System.out.println(hm);
    }
}
