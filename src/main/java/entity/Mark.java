package entity;

import java.util.Objects;

public class Mark {
    private int id;
    private Student student;
    private Semester semester;
    private Discipline discipline;
    private String mark;

    public Mark() {
    }

    public Mark(int id, Student student, Semester semester, Discipline discipline, String mark) {
        this.id = id;
        this.student = student;
        this.semester = semester;
        this.discipline = discipline;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return id == mark1.id &&
                Objects.equals(student, mark1.student) &&
                Objects.equals(semester, mark1.semester) &&
                Objects.equals(discipline, mark1.discipline) &&
                Objects.equals(mark, mark1.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, semester, discipline, mark);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student +
                ", semester=" + semester +
                ", discipline=" + discipline +
                ", mark='" + mark + '\'' +
                '}';
    }
}
