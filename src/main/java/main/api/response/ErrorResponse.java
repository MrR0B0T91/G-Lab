package main.api.response;

import lombok.Data;
import main.api.response.interfaces.Response;

@Data
public class ErrorResponse implements Response {

    private String error;
}
