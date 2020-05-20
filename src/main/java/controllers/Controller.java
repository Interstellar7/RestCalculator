package controllers;

import entities.Request;
import entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IService;
import services.ServiceImpl;
import utils.Utils;

@RestController
@RequestMapping(
        path = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class Controller {
    private final IService service;

    @Autowired
    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("hello")
    public Object sayHello(@RequestParam(value = "name", defaultValue = "User") String name) {
        return new ResponseEntity<>(service.sayHello(name), HttpStatus.OK);
    }

    @GetMapping("calculate")
    @ResponseBody
    public ResponseEntity<Result> calculateFromGet(
            @RequestParam(value = "action", defaultValue = "no action") String action,
            @RequestParam(value = "value1", defaultValue = "no value") String value1,
            @RequestParam(value = "value2", defaultValue = "no value") String value2
    ) {
        return calculate(action, value1, value2);
    }

    @PostMapping("calculate")
    public ResponseEntity<Result> calculateFromPost(@RequestBody Request request) {
        String action = "no action";
        String value1 = "no value";
        String value2 = "no value";
        if (request.getAction() != null) action = request.getAction();
        if (request.getValue1() != null) value1 = request.getValue1();
        if (request.getValue2() != null) value2 = request.getValue2();
        return calculate(action, value1, value2);
    }

    // Общий метод для GET и POST запросов, который проверяет все входные данные и собственно производит вычисление
    private ResponseEntity<Result> calculate(String action, String value1, String value2) {
        String checkedAction = Utils.checkAction(action);
        if (checkedAction.equals("ok")) {
            String argA = Utils.checkArgumentA(value1);
            String argB = Utils.checkArgumentB(value2);
            if (argA.equals("ok")) {
                if (argB.equals("ok")) {
                    double a = Double.parseDouble(value1);
                    double b = Double.parseDouble(value2);
                    if (action.equals("division") && b == 0) {
                        return new ResponseEntity<>(new Result(HttpStatus.METHOD_NOT_ALLOWED, "Division by zero!", 0), HttpStatus.METHOD_NOT_ALLOWED) ;
                    } else {

                        double res = Utils.round(service.calculate(action, a, b), service.getNumbersAfterComa());

                        return new ResponseEntity<>(new Result(HttpStatus.OK, "Action is " + action, res), HttpStatus.OK);
                    }
                } else {
                    return new ResponseEntity<>(new Result(HttpStatus.BAD_REQUEST, argB, 0), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(new Result(HttpStatus.BAD_REQUEST, argA, 0), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(new Result(HttpStatus.BAD_REQUEST, checkedAction, 0), HttpStatus.BAD_REQUEST);
        }
    }
}
