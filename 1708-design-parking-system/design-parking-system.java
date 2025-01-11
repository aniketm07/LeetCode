class ParkingSystem {

    Map<Integer, Integer> map = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }
    
    public boolean addCar(int carType) {
        int noOfCars = map.get(carType);
        if(noOfCars <= 0){
            return false;
        }
        map.put(carType, noOfCars-1);
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */