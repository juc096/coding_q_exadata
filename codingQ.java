import java.util.HashMap;
import java.util.Collections;
import java.lang.Math; 

class codingQ {
    public void swap(Integer a, Integer b) {
        Integer temp = new Integer(a);
        a = new Integer(b);
        b = new Integer(a);
    }

    public int count_string(String s) {

        //convert string to list
        List<String> temp_list = new ArrayList<String>(s.split(" "));
        
        //create a hashmap that maps the words of the string to the integer count of how
        //many times it appears in the string
        HashMap<String, Integer> temp_map = new HashMap<String, Integer>();

        //insert each word into hashmap
        for (String t : temp_list) {
            //if no k-v pair exist, add it
            if(temp_map.get(t) == null)
                temp_map.put(t,1);
            //else increment the count value
            else
                temp_map.get(t)++;
        }

        //obtain set of keys
        Set<String> key_set = temp_map.keySet();
        int word_count = 0;

        //iterate through the set and add the word count int values 
        for (String k : key_set) 
            word_count += temp_map.get(k);
        
        return word_count;
        
    }

    public int iterate_hashmap(HashMap<String, Integer> hm) {
        //similar to above i suppose
        //function can be reused in above solution
        Set<String> key_set = hm.keySet();
        int word_count = 0;

        for (String k : key_set) 
            word_count += hm.get(k);
        return word_count;
    }

    //if number, convert to string
    public boolean is_palindrome(String s) {
    
        //convert string to list
        List<char> temp_list = new ArrayList<char>(s.toCharArray());
        //create another list that is the reversed string
        List<char> temp_reverse_list = new ArrayList<char>(temp_list);
        Collections.reverse(temp_reverse_list);
        //compare if equal
        return temp_list.equals(temp_reverse_list);
    }

    public int fibo(int n) {
        //initial n must be greater than 2; 
        if (n <= 2) {
            return n-1;
        }
        else {
            int temp = fibo(n-1);
            int temp2 = fibo(n-2);
            return temp + temp2;
        }
    }
    public List<char> find_dupe(String s) {

        //convert string to list
        List<char> temp_list = new ArrayList<char>(s.toCharArray());

        //using set to discern what is duplicate or not
        Set<char> temp_set = new Set<char();
        //list of duplicate chars to return
        List<char> dupe_list = new ArrayList<char>();

        //iterate through the string list to find duplicates
        for(char t : temp_list) {
            if (!temp_set.add(t)) { 
                //if return value is false, it indicates that string t is a duplicate entry
                //thus we add to dupe_list
                dupe_list.add(t);
            }
        }
        return dupe_list;

    }

    public Integer second_highest(Integer[] d) {
        //Listify Int array
        List<Integer> temp_list = Arrays.asList(d);

        //create priority queue with a custom comparator to have max-heap effect
        //using the Collections library's comparator
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(d.size(), Collections.reverseOrder());

        pq.addAll(temp_list);

        //remove largest element -- the head 
        pq.poll();

        //return the second largest element -- the current head
        return pq.peek();
    }

    public boolean is_armstrong(int d) {
        //convert int to number string
        String num_str = String.valueOf(d);
        //then convert number string to list
        List<String> temp_list = new ArrayList<String>(num_str.split(""));
        //find amount of digits by the list length
        int num_digit = temp_list.size();

        float cur_sum = 0;
        //iterate thru the list
        for (String s: temp_list) {
            //obtain each digit and power it appropriately, then sum
            int cur_digit = Integer.parseInt(s);
            cur_sum += Math.pow(cur_digit, num_digit);
        }

        return (d == cur_sum);

    }
}