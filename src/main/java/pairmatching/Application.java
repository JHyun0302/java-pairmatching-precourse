package pairmatching;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import pairmatching.controller.PairController;
import pairmatching.repository.MatchingRepository;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;

public class Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        CrewService crewService = new CrewService();
        PairController pairController = new PairController(
                crewService,
                new MatchingService(crewService, new MatchingRepository())
        );
        pairController.run();
    }
}
