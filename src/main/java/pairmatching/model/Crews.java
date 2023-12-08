package pairmatching.model;

import static pairmatching.exception.ErrorMessage.PROCESS_IS_NOT_EXISTED;
import static pairmatching.model.constant.Course.BACKEND;
import static pairmatching.model.constant.Course.FRONTEND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.exception.CustomException;
import pairmatching.model.constant.Course;

public class Crews {
    private final List<String> backend;
    private final List<String> frontend;

    private Crews() {
        this.backend = new ArrayList<String>();
        this.frontend = new ArrayList<>();
    }

    public static Crews createCrews() {
        return new Crews();
    }

    public List<String> getBackend() {
        return Collections.unmodifiableList(backend);
    }

    public List<String> getFrontend() {
        return Collections.unmodifiableList(frontend);
    }

    public void add(Course course, List<String> names) {
        if (course.equals(Course.BACKEND)) {
            backend.addAll(names);
        }
        if (course.equals(Course.FRONTEND)) {
            frontend.addAll(names);
        }
    }

    public List<String> getCrews(Course course) {
        if (course.equals(BACKEND)) {
            return backend;
        }
        if (course.equals(FRONTEND)) {
            return frontend;
        }
        
        throw CustomException.errorMessage(PROCESS_IS_NOT_EXISTED);
    }
}
