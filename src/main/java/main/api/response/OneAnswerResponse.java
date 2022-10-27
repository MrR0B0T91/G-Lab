package main.api.response;

import lombok.Data;
import main.api.response.interfaces.Response;

@Data
public class OneAnswerResponse implements Response {

    private Double x1;
}
