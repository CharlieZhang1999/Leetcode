class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String a_value = a+b;
                String b_value = b+a;
                return b_value.compareTo(a_value);
            }  
        });
        
        for(int n:nums){
            queue.offer(String.valueOf(n));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}