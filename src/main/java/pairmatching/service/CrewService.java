package pairmatching.service;

import java.util.List;
import pairmatching.model.Crews;
import pairmatching.model.constant.Course;
import pairmatching.view.input.InputView;

public class CrewService {
    private final InputView inputView;

    public CrewService(InputView inputView) {
        this.inputView = inputView;
    }

    public Crews initCrews() {
        List<String> backend = inputView.readBackendData();
        List<String> frontend = inputView.readFrontendData();

        Crews crews = Crews.createCrews();
        crews.add(Course.BACKEND, backend);
        crews.add(Course.FRONTEND, frontend);

        return crews;
    }
}
