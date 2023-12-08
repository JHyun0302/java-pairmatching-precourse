package pairmatching.service;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import pairmatching.model.Crews;
import pairmatching.model.constant.Course;
import pairmatching.util.CrewParser;

public class CrewService {
    private final Crews crews;

    public CrewService() throws ParserConfigurationException, IOException, SAXException {
        this.crews = initCrews();
    }

    private Crews initCrews() throws ParserConfigurationException, IOException, SAXException {
        CrewParser crewParser = new CrewParser();
        List<String> backend = crewParser.parseName(Course.BACKEND);
        List<String> frontend = crewParser.parseName(Course.FRONTEND);

        Crews crews = Crews.createCrews();
        crews.add(Course.BACKEND, backend);
        crews.add(Course.FRONTEND, frontend);

        return crews;
    }

    public List<String> getCrews(Course course) {
        return crews.getCrews(course);
    }

}
