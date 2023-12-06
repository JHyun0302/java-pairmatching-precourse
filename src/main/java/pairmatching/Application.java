package pairmatching;

import pairmatching.controller.InitCrewController;
import pairmatching.controller.PairController;
import pairmatching.model.Crews;
import pairmatching.service.CrewService;
import pairmatching.validation.PairMatchingValidation;
import pairmatching.view.input.InputView;
import pairmatching.view.input.template.InputValidatorTemplate;

public class Application {
    public static void main(String[] args) {
        // 객체 생성
        InputView inputView = createInputView();

        CrewService crewService = new CrewService(inputView, pairRepository);
        SelectFuncService selectFuncService = new SelectFuncService(inputView, findProcess);

        InitCrewController initCrewController = new InitCrewController(crewService);
        PairController pairController = new PairController(selectFuncService);

        pairMatching(initCrewController, pairController);
    }

    private static InputView createInputView() {
        PairMatchingValidation pairMatchingValidation = new PairMatchingValidation();
        ReadFileValidation readFileValidation = new ReadFileValidation();
        SelectFunctionValidation selectFunctionValidation = new SelectFunctionValidation();
        InputValidatorTemplate template = new InputValidatorTemplate();
        return new InputView(readFileValidation, selectFunctionValidation, pairMatchingValidation, template);
    }


    private static void pairMatching(InitCrewController initCrewController, PairController pairController) {
        Crews crews = initCrewController.initCrews();
        pairController.selectFunction(crews);

    }
}
