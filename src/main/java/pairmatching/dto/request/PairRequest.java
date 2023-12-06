package pairmatching.dto.request;

import pairmatching.model.constant.Course;
import pairmatching.model.constant.Level;
import pairmatching.model.constant.Mission;

public class PairRequest {
    private Course course;
    private Level level;
    private Mission mission;

    public PairRequest(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
    
}
