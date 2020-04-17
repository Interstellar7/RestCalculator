package entities;

public class Request {
    private String action;
    private double value1;
    private double value2;

    public Request() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }
}
