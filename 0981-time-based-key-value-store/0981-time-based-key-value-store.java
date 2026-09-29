import java.util.*;

class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String answer = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                answer = list.get(mid).value;

                // Try to find a later valid timestamp
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return answer;
    }
}