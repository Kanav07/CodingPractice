package Questions;

import algorithmsBasics.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        TreeMap<Integer,Integer> mergedList = new TreeMap<Integer, Integer>();

        for (int i = 0; i < a.size(); i++) {
            ListNode listhead = a.get(i);

            while (listhead!=null){
                if( mergedList.containsKey(listhead.val)){
                    int count = mergedList.get(listhead.val);
                    mergedList.put(listhead.val,count+1);
                } else mergedList.put(listhead.val,1);
                listhead= listhead.next;
            }
        }
        ListNode result=null, temp=null;

        Iterator itr = mergedList.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer,Integer> set = (Map.Entry<Integer, Integer>) itr.next();
            while (set.getValue()>0) {
                if (result == null) {
                    result = new ListNode(set.getKey());
                    temp = result;
                } else {
                    temp.next = new ListNode(set.getKey());
                    temp = temp.next;
                }
                set.setValue(set.getValue()-1);
            }
        }
        return result;
    }

}
