package pairmatching.service;

import org.xml.sax.SAXException;
import pairmatching.model.Crews;
import pairmatching.model.constant.Course;
import pairmatching.util.CrewParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class CrewService {

    public Crews initCrews() throws ParserConfigurationException, IOException, SAXException {
        CrewParser crewParser = new CrewParser();
        List<String> backend = crewParser.parseName(Course.BACKEND);
        List<String> frontend = crewParser.parseName(Course.FRONTEND);

        Crews crews = Crews.createCrews();
        crews.add(Course.BACKEND, backend);
        crews.add(Course.FRONTEND, frontend);

        return crews;
    }
}
