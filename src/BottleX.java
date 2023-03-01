public class BottleX {
    public static void main(String[] args) {
        Bottle[] bottles = new Bottle[33];
        double j = 2.5;
        for (int i = 0; i < bottles.length; i++) {
            bottles[i] = new Bottle(j);
            j += 2.5;

        }
        System.out.println(bottles[0].getBottleCapacity());
        System.out.println(bottles[1].getBottleCapacity());
        System.out.println(bottles[32].getBottleCapacity());

        bottles[0].pour(2.5);
        bottles[1].pour(3);
        bottles[0].transfer(0.5, bottles[1]);
        System.out.println(bottles[1].getCurrentState());
        System.out.println(bottles[0].getCurrentState());


    }
}

class Bottle {
    double bottleCapacity;
    //int bottleNumber;
    private double currentState;

    Bottle(double bottleCapacity) {
        this.bottleCapacity = bottleCapacity;
    }

    double getBottleCapacity() {
        return bottleCapacity;
    }

    double getCurrentState() {
        return currentState;
    }

    double pour(double howManyLiteres) {
        if ((this.currentState + howManyLiteres) <= bottleCapacity) {
            this.currentState += howManyLiteres;
            return howManyLiteres;
        } else
            return 0;

    }

    boolean pourOut(double howManyLiteres) {
        if (this.currentState >= howManyLiteres) {
            this.currentState -= howManyLiteres;
            return true;
        } else {
            this.currentState = 0;
            return false;
        }
    }

    void transfer(double howManyLiteres, Bottle whereToTranfser) {
        if (howManyLiteres <= currentState) {
            this.pourOut(howManyLiteres);
        } else
            this.pourOut(currentState);
        whereToTranfser.pour(howManyLiteres);
    }
}
