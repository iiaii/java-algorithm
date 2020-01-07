package programmers.level_2.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(weight, bridge_length);
        Queue<Truck> pending = new LinkedList<>();
        Queue<Truck> moving = new LinkedList<>();
        
        for (int w : truck_weights) {
            pending.add(new Truck(0,w));
        }
        
        int count = 0;
        do {
            for(Truck truck : moving) {
                truck.moveForward();
            }

            if(!moving.isEmpty() && bridge.doesTruckPassed(moving.peek())) {
                bridge.exit(moving.remove());
            }
            
            if(!pending.isEmpty() && bridge.isEnterable(pending.peek())) {
                Truck truck = pending.remove();
                truck.moveForward();
                bridge.enter(truck);
                moving.add(truck);
            }
    
            count++;
        } while(!moving.isEmpty());

        return count;
    }
}

class Bridge {
    private int maximum_load;
    private int bridge_length;

    Bridge(int maximum_load, int bridge_length) {
        this.maximum_load = maximum_load;
        this.bridge_length = bridge_length;
    }

    boolean isEnterable(Truck truck) {
        return this.maximum_load-truck.getWeight() >= 0 ? true : false;
    }

    void enter(Truck truck) {
        this.maximum_load -= truck.getWeight();
    }

    void exit(Truck truck) {
        this.maximum_load += truck.getWeight();
    }

    boolean doesTruckPassed(Truck truck) {
        return truck.getPosition() > bridge_length;
    }
}

class Truck {
    private int position;
    private int weight;

    Truck(int position, int weight) {
        this.position = position;
        this.weight = weight;
    }

    void moveForward() {
        this.position++;
    }

    int getPosition() {
        return this.position;
    } 

    int getWeight() {
        return this.weight;
    }
}