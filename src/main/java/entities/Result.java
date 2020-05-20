package entities;

import org.springframework.http.HttpStatus;

public class Result {
    private HttpStatus status;
    private String message;
    private double calcResult;

    public Result() {
    }

    public Result(HttpStatus status, String message, double calcResult) {
        this.status = status;
        this.message = message;
        this.calcResult = calcResult;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
