class Solution {
    public boolean isRobotBounded(String instructions) {
        String direction = "N";
        int x_coor = 0, y_coor = 0;
        // HashMap store the next direction after the instruction
        HashMap<String, String> lmap = new HashMap<>();
        lmap.put("E", "N");
        lmap.put("N", "W");
        lmap.put("W", "S");
        lmap.put("S", "E");
        
        HashMap<String, String> rmap = new HashMap<>();
        rmap.put("E", "S");
        rmap.put("S", "W");
        rmap.put("W", "N");
        rmap.put("N", "E");
        for(int i = 0; i < instructions.length(); i++){
            // case 'L':
            if(instructions.charAt(i) == 'L'){
                direction = lmap.get(direction);
            }
            // case 'R':
            else if(instructions.charAt(i) == 'R'){
                direction = rmap.get(direction);
            }
            // case "G":
            else{
                if(direction=="E"){
                    x_coor++;
                }
                else if(direction == "N"){
                    y_coor++;
                }
                else if(direction=="W"){
                    x_coor--;
                }
                else y_coor--;
            }
        }
        if(direction != "N" || (x_coor == 0 && y_coor == 0)){
            return true;
        }
        
        return false;
        
    }
}
/*
The only one thing to know is that if the direction has changed or it doesn't change the direction but the point goes back the origin, then it will definitely be in a circle(since it has to go back to the origin in a few sequences)
https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC%2B%2BPython-Let-Chopper-Help-Explain
*/