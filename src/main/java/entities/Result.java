package entities;

public class Result {
    private String message;
    private double calcResult;

    public Result() {
    }

    public Result(String message, double calcResult) {
        this.message = message;
        this.calcResult = calcResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(double calcResult) {
        this.calcResult = calcResult;
    }
}
