class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> data = map.get(key);
        return findClosestValue(data, timestamp);
    }
    
    private String findClosestValue(List<Data> data, int timestamp) {
        int l = 0, r = data.size() - 1;
        String result = "";
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data.get(mid).timestamp == timestamp) {
                return data.get(mid).value; // exact match
            } else if (data.get(mid).timestamp < timestamp) {
                result = data.get(mid).value; // candidate
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return result;
    }
    
    class Data {
        String value;
        int timestamp;
        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
