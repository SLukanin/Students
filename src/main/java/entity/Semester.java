package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Semester {
    private int id;
    private String semester;
    private String duration;
    private int status = 1;
    private List<Discipline> disciplines = new ArrayList<>();

    public Semester(int id, String semester, String duration, int status, List<Discipline> disciplines) {
        this.id = id;
        this.semester = semester;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public Semester() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "semester{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester1 = (Semester) o;
        return id == semester1.id &&
                status == semester1.status &&
                Objects.equals(semester, semester1.semester) &&
                Objects.equals(duration, semester1.duration) &&
                Objects.equals(disciplines, semester1.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semester, duration, status, disciplines);
    }
}
