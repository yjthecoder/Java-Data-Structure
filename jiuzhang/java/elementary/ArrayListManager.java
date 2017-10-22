package jiuzhang.java.elementary;

import java.util.ArrayList;

//ArrayList
//*Note: 常用API
public class ArrayListManager {
    /**
     * @param n: You should generate an array list of n elements.
     * @return: The array list your just created.
     */
    public static ArrayList<Integer> create(int n) {
        // Write your code here
        ArrayList<Integer>  arrayList= new ArrayList<Integer>(n);  //*Note: capacity is not size
//        for (int i = 0; i < n; i++) {
//            arrayList.add(i);
//        }
        return arrayList;
    }
    
    /**
     * @param list: The list you need to clone
     * @return: A deep copyed array list from the given list
     */
    public static ArrayList<Integer> clone(ArrayList<Integer> list) {
        // Write your code here
        ArrayList<Integer>  arrayList= new ArrayList<Integer>(list.size());
        for (Integer i: list) {
            arrayList.add(i);
        }
        return arrayList;
    }
    
    /**
     * @param list: The array list to find the kth element
     * @param k: Find the kth element
     * @return: The kth element
     */
    public static int get(ArrayList<Integer> list, int k) {
        // Write your code here
        return list.get(k);
    }
    
    /**
     * @param list: The array list
     * @param k: Find the kth element, set it to val
     * @param val: Find the kth element, set it to val
     */
    public static void set(ArrayList<Integer> list, int k, int val) {
        // write your code here
        list.set(k, val);
    }
    
    /**
     * @param list: The array list to remove the kth element
     * @param k: Remove the kth element
     */
    public static void remove(ArrayList<Integer> list, int k) {
        // write tour code here
        list.remove(k);
    }
    
    /**
     * @param list: The array list.
     * @param val: Get the index of the first element that equals to val
     * @return: Return the index of that element
     */
    public static int indexOf(ArrayList<Integer> list, int val) {
        if (list == null) {
            return -1; //*Note: always think about corner case, look at the parameters
        }
            
        return list.indexOf(val); //*Note: return -1 if val is not found
    }
    
    public static void main(String[] args) {
        //ArrayListManager am = new ArrayListManager();
        ArrayList<Integer> a = ArrayListManager.create(5);
        System.out.println(a.size());
    }
}

