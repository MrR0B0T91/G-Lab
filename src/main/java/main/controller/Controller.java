package main.controller;

import main.api.request.Request;
import main.api.response.interfaces.Response;
import main.service.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calculate")
public class Controller {

    private final CalculateService calculateService;

    public Controller(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public Response getResult(
            @RequestBody Request request) {
        return calculateService.getResult(request.getFirstArgument(), request.getSecondArgument(), request.getThirdArgument());
    }

}
