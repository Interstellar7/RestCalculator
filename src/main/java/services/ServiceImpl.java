package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService{

    private final int numbersAfterComa;

    @Autowired
    public ServiceImpl(@Value("${numbersAfterComa}") int numbersAfterComa) {
        this.numbersAfterComa = numbersAfterComa;
    }

    @Override
    public int getNumbersAfterComa() {
        return numbersAfterComa;
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "! The best Rest-Calculator greetings you!";
    }

    @Override
    public double calculate(String action, double value1, double value2) {
        double result = 0;
        switch (action) {
            case "addition" : result = addition(value1, value2);
                break;
            case "subtraction" : result = subtraction(value1, value2);
                break;
            case "multiplication" : result = multiplication(value1, value2);
                break;
            case "division" : result = division(value1, value2);
                break;
        }
        return result;
    }

    private double addition(double a, double b) {
        return a + b;
    }

    private double subtraction(double a, double b) {
        return a - b;
    }

    private double multiplication(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        return a / b;
    }
}
