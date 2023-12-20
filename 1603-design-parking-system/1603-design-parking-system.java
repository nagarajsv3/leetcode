class ParkingSystem {
    int bigCount = 0;
    int mediumCount = 0;
    int smallCount = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.bigCount = big;
        this.mediumCount = medium;
        this.smallCount = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            if(this.bigCount > 0 ){
                this.bigCount--;
                return true;
            }else{
                return false;
            }
        }else if(carType==2){
            if(this.mediumCount > 0){
                this.mediumCount--;
                return true;
            }else{
                return false;
            }
        }else if(carType==3){
            if(this.smallCount > 0){
                this.smallCount--;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */