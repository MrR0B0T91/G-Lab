package main.service;

import main.api.response.CalculateResponse;
import main.model.DisData;
import main.model.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    private final DataRepository dataRepository;

    public CalculateService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public CalculateResponse getResult(Double a, Double b, Double c) {

        CalculateResponse response = new CalculateResponse();
        DisData data = new DisData();

        Double dis = Math.pow(b, 2) - (4 * a * c);

        if (dis < 0) {
            response.setError("Дискриминант меньше нуля, корней нет");
        }
        if (dis == 0) {
            Double result = (-1 * b) / (2 * a);
            response.setX1(result);
        }
        if (dis > 0) {
            Double x1 = ((-1 * b) + Math.sqrt(dis)) / (2 * a);
            Double x2 = ((-1 * b) - Math.sqrt(dis)) / (2 * a);

            response.setX1(x1);
            response.setX2(x2);

            data.setX1(x1);
            data.setX2(x2);
        }

        data.setA(a);
        data.setB(b);
        data.setC(c);

        dataRepository.save(data);

        return response;
    }
}
