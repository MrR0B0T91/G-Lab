package main.api.response;

import lombok.Data;
import main.api.response.interfaces.Response;

@Data
public class TwoAnswersResponse implements Response {

    private Double x1;

    private Double x2;

}
