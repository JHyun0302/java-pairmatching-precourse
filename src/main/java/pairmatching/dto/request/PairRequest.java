package pairmatching.dto.request;

import pairmatching.model.constant.Course;
import pairmatching.model.constant.Level;
import pairmatching.model.constant.Mission;

public class PairRequest {
    private Course course;
    private Level level;
    private Mission mission;

    private PairRequest(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairRequest createPairRequest(Course course, Level level, Mission mission) {
        return new PairRequest(course, level, mission);
    }
}
