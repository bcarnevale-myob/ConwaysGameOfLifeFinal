package World;

public class MockConwayRandom implements ConwayRandom {

    private final int first;
    private final int second;
    private final int third;
    private int calledTimes = 0;

    public MockConwayRandom(int first, int second) {
        this.first = first;
        this.second = second;
        this.third = 0;
    }

    public MockConwayRandom(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public int nextInt(int upperBound) {
        if(calledTimes == 0) {
            calledTimes++;
            return this.first;
        } else if(calledTimes == 1 || calledTimes == 2) {
            calledTimes++;
            return this.second;
        }
        calledTimes++;
        return this.third;
    }

    public int getCalledTimes() {
        return this.calledTimes;
    }

}
