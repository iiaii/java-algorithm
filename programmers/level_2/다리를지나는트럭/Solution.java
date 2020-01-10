import java.util.*;

class Solution {
    static Bridge bridge;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        bridge = new Bridge(weight, bridge_length);
        Queue<Truck> pending = new LinkedList<>();
        Queue<Truck> moving = new LinkedList<>();
        
        pending.addAll(addTrucks(truck_weights));
        
        int count = 0;
        do {
            moveTrucks(moving);
            checkTruckPassed(moving);
            movePendingTruck(pending, moving);
    
            count++;
        } while(!moving.isEmpty());

        return count;
    }

    Queue<Truck> addTrucks(int[] truck_weights) {
        Queue<Truck> pending = new LinkedList<>();
        
        for (int w : truck_weights) {
            pending.add(new Truck(0,w));
        }

        return pending;
    }

    void moveTrucks(Queue<Truck> moving) {
        for(Truck truck : moving) {
            truck.moveForward();
        }
    }

    void checkTruckPassed(Queue<Truck> moving) {
        if(moving.isEmpty()) {
            return;
        }
        
        if(bridge.isPassed(moving.peek())) {
            bridge.exit(moving.remove());
        }
    }

    void movePendingTruck(Queue<Truck> pending, Queue<Truck> moving) {
        if(pending.isEmpty()) {
            return;
        }

        if(bridge.isEnterable(pending.peek())) {
            Truck truck = pending.remove();
            truck.moveForward();
            bridge.enter(truck);
            moving.add(truck);
        }
    }
}

class Bridge {
    private int max_load;
    private int bridge_length;

    Bridge(int max_load, int bridge_length) {
        this.max_load = max_load;
        this.bridge_length = bridge_length;
    }

    boolean isEnterable(Truck truck) {
        return this.max_load-truck.getWeight() >= 0 ? true : false;
    }

    void enter(Truck truck) {
        this.max_load -= truck.getWeight();
    }

    void exit(Truck truck) {
        this.max_load += truck.getWeight();
    }

    boolean isPassed(Truck truck) {
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