class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            double time = (target - position[i]) / ((double) speed[i]);
            cars[i] = new Car(position[i], speed[i], time);
        }
        
        Arrays.sort(cars, (c1, c2) -> c1.position - c2.position);
        int fleets = 0;
        double current = Integer.MIN_VALUE;
        for (int i = position.length - 1; i >= 0; i--) {
            if (cars[i].time > current) {
                current = cars[i].time;
                fleets++;
            }
        }
        
        return fleets;
    }
}

class Car {
    int position;
    int speed;
    double time;
    Car(int position, int speed, double time) {
        this.position = position;
        this.speed = speed;
        this.time = time;
    }
}