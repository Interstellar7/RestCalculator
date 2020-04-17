package controllers;

import entities.Request;
import entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.IService;
import services.ServiceImpl;

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
    public Result sayHello(@RequestParam(value = "name", defaultValue = "User") String name) {
        return new Result(service.sayHello(name), 0);
    }

    @GetMapping("calculate")
    public Result calculateFromGet(
            @RequestParam(value = "action", defaultValue = "addition") String action,
            @RequestParam(value = "value1", defaultValue = "1") double value1,
            @RequestParam(value = "value2", defaultValue = "1") double value2
    ) {
        double res = service.calculate(action, value1, value2);
        return new Result("Action is " + action, res);
    }

    @PostMapping("/calculate")
    public Result calculateFromPost(@RequestBody Request request) {
        double res = service.calculate(request.getAction(), request.getValue1(), request.getValue2());
        return new Result("Action is " + request.getAction(), res);
    }
}
