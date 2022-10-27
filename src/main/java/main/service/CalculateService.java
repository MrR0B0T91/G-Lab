package main.service;

import main.api.response.ErrorResponse;
import main.api.response.OneAnswerResponse;
import main.api.response.TwoAnswersResponse;
import main.api.response.interfaces.Response;
import main.model.Data;
import main.model.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private final DataRepository dataRepository;

    public CalculateService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Response getResult(Double firstArgument, Double secondArgument, Double thirdArgument) {

        OneAnswerResponse oneAnswerResponse = new OneAnswerResponse();
        TwoAnswersResponse twoAnswersResponse = new TwoAnswersResponse();
        ErrorResponse errorResponse = new ErrorResponse();
        Data data = new Data();

        if ((firstArgument == null) || (secondArgument == null) || (thirdArgument == null)) {

            errorResponse.setError("Заданы не все компоненты");
            return errorResponse;
        }

        Double dis = Math.pow(secondArgument, 2) - (4 * firstArgument * thirdArgument);

        if (dis < 0) {
            errorResponse.setError("Дискриминант меньше нуля, корней нет");
            return errorResponse;
        }
        if (dis == 0) {
            Double result = (-1 * secondArgument) / (2 * firstArgument);
            oneAnswerResponse.setX1(result);
            return oneAnswerResponse;
        }
        if (dis > 0) {
            Double x1 = ((-1 * secondArgument) + Math.sqrt(dis)) / (2 * firstArgument);
            Double x2 = ((-1 * secondArgument) - Math.sqrt(dis)) / (2 * firstArgument);

            twoAnswersResponse.setX1(x1);
            twoAnswersResponse.setX2(x2);

            data.setX1(x1);
            data.setX2(x2);
        }

        data.setFirstArgument(firstArgument);
        data.setSecondArgument(secondArgument);
        data.setThirdArgument(thirdArgument);

        dataRepository.save(data);

        return twoAnswersResponse;
    }
}
