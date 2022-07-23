class UndergroundSystem {
    class Passenger{
        int id;
        String startStation;
        String endStation;
        int startTime, endTime;
        Passenger(int id, String stationName, int startTime){
            this.id = id;
            this.startStation = stationName;
            this.startTime = startTime;
        }
        
        public void checkout(String endStation, int endTime){
            this.endStation = endStation;
            this.endTime = endTime;
            String key = this.startStation+"_"+this.endStation;
            if(!routeMap.containsKey(key)){
                routeMap.put(key, new Route(this.startStation, this.endStation, 1, this.endTime - this.startTime));
            }
            else{
                Route route = routeMap.get(key);
                route.totalTime += (this.endTime - this.startTime);
                route.numPeople += 1;
                
            }
        }
        
    }
    
    class Route{
        String startStation;
        String endStation;
        double numPeople;
        double totalTime;
        
        Route(String startStation, String endStation, int numPeople, int totalTime){
            this.startStation = startStation;
            this.endStation = endStation;
            this.numPeople = numPeople;
            this.totalTime = totalTime;
        }
        
        public double average(){
            return (double) totalTime / numPeople;
        }
        
    }
    public HashMap<Integer, Passenger> idMap;
    public HashMap<String, Route> routeMap;
    public Passenger temp;
    public UndergroundSystem() {
        idMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        temp = new Passenger(id, stationName, t);
        idMap.put(id, temp);
    }
    
    public void checkOut(int id, String stationName, int t) {
        idMap.get(id).checkout(stationName, t);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+"_"+endStation;
        return routeMap.get(key).average();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

/*
这道题比较tricky的两个点
1\每个数据到底该用什么类概括，该建什么类
2\用startStation_endStation作为key来调取，比较难想到
*/