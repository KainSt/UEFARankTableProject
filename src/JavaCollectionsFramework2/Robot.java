package JavaCollectionsFramework2;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Robot implements  Comparable<Robot>{
    int power;
    String model;

    Robot(int pwr, String mdl){
        power = pwr;
        model = mdl;
          }

    @Override
    public String toString() {
        return "Robot{" + " model: " + model+
                ", power= " + power +
                '}';
    }

    @Override
    public int compareTo(Robot o) {
        if (this.model.compareToIgnoreCase(o.model)==0 ) {
           return this.power - o.power;
        } else {
            return this.model.compareToIgnoreCase(o.model);
        }

    }

    public static void main(String[] args){
        Map<Robot, Integer> robotTreeMap = new TreeMap<>();
        for (int i = 0; i < 5; i++) {

            robotTreeMap.put(new Robot((int) (50*Math.random()),String.valueOf((int) (15*Math.random()))), i);
        }

        Iterator<Map.Entry<Robot,Integer>> iterator = robotTreeMap.entrySet().iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getKey());
        }
    }
}
