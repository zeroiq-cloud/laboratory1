import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@Getter
public class Student {
    public String name;
    public int group;
    public int course;
    public List<Integer> assessments;

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public Student(String name, int group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.assessments = new ArrayList<>();
    }

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public void addAssessments(int assessment) {
        this.assessments.add(assessment);
    }

    public double getAverageAssessment() {
        if (assessments == null || assessments.isEmpty()) {
            return 0.0;
        }
        return assessments.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void nextCourse() {
        this.course++;
    }

}


