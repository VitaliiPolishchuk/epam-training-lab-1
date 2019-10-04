package the.best;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Properties {
    public static class Interval {
        private double start, end;
        Interval(double start, double end){
            Interval.this.start = start;
            Interval.this.end = end;
        }

        public double getStart(){
            return start;
        }

        public double getEnd(){
            return end;
        }

        public boolean inInterval(double val){
            return start <= val && val <= end;
        }
    }

    Map<Toy.Fields, Interval> properties;

    public Properties() {
        properties = new HashMap<>();
    }

    public boolean put(Toy.Fields key, Interval value){
        boolean isContains = false;
        if(properties.containsKey(key)){
            isContains = true;
        }

        properties.put(key, value);

        return isContains;
    }

    public Set<Toy.Fields> getFiels(){
        return properties.keySet();
    }

    public Interval getInterval(Toy.Fields key){
        return properties.get(key);
    }
}
