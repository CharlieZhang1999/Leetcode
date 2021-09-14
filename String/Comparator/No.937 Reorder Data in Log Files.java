class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int index1 = o1.indexOf(' ');
                int index2 = o2.indexOf(' ');
                
                if(o1.charAt(index1+1) <= '9'){
                    if(o2.charAt(index2+1) <= '9'){
                        return 0;
                    }
                    else return 1;
                }

                if(o2.charAt(index2+1) <= '9'){
                    return -1;
                }

                int result = o1.substring(index1+1, o1.length()).compareTo(o2.substring(index2+1,   o2.length()));
                if(result == 0){
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                }

                return result;

            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}