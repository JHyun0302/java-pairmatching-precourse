package pairmatching.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static pairmatching.validation.ReadDataValidation.isBlank;
import static pairmatching.validation.ReadFileValidation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.validation.CommonValidation;

public class InputView {

    public static List<String> readBackendData() {
        List<String> backendCrews = readData("src/main/resources/backend-crew.md");
        return isBlank(backendCrews);
    }

    public static List<String> readFrontendData() {
        List<String> frontendCrews = readData("src/main/resources/frontend-crew.md");
        return isBlank(frontendCrews);
    }

    public static String readFunc() {
        while (true) {
            try {
                String input = readLine();
                return CommonValidation.isBlank(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> readMissionInfo() {
        return template.InputWithValidation(this::pairMatchingValidator);
    }


    private static String selectFuncValidator(String input) {
        return selectFunctionValidation.isBlank(input);
    }

    private static List<String> pairMatchingValidator(String input) {
        pairMatchingValidation.isBlank(input);
        pairMatchingValidation.checkCommaError(input);
        pairMatchingValidation.checkErrorInput(input);
        return pairMatchingValidation.makePairMatchingInfo(input);
    }

    private static List<String> readData(String filePath) {
        List<String> crews = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            while ((line = br.readLine()) != null) {
                crews.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crews;
    }
}