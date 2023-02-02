package com.kevin;

public class Base {

    float getBoat(){
        return 1.0f;
    }

    double getTanker(){
        return Double.MAX_VALUE;
    }
}

class Submarine extends Base {

    @Override
    float getBoat() {
        return super.getBoat();
    }

    @Override
    double getTanker() {
        return super.getTanker();
    }
}
