package database;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public static void creatDiscipline(String newDisc){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&&characterEncoding=utf8","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES ('" + newDisc +"');");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Discipline> getAllActiveDiscipline() {

        ArrayList<Discipline> disciplines = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from discipline where status = 1");
            while(rs.next()){
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                disciplines.add(discipline);
            }
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void modifyDiscipline(String id, String newName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&&characterEncoding=utf8","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE `students`.`discipline` SET `discipline` = '" + newName + " 'WHERE (`id` = '" + id + "');");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getString("date"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static Discipline getDisciplineById(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from discipline where status = 1 AND id = " + id);
            while(rs.next()){
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setDiscipline(rs.getString("discipline"));
                return discipline;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createStudents(String newSurname,String newName,String newGroup,String newDate) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('"+newSurname+"', '"+newName+"', '"+newGroup+"', '"+newDate+"')\n;");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(getAllActiveDiscipline());
    }

    public static void deleteDiscipline(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE discipline SET status = '0' WHERE (id = '" + id + "');");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Account getAccoint(String login, String password, String role) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM account WHERE login = '"+login+"' and password = '"+password+"' and role = '"+role+"';");
            while (rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setLogin(rs.getString("login"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                return account;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static List<Semester> getAllActiveSemestrs() {
        ArrayList<Semester> semestrs = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from semster where status = 1");
            while (rs.next()) {
                Semester semestr = new Semester();
                semestr.setId(rs.getInt("id"));
                semestr.setSemester(rs.getString("semster"));
                semestr.setDuration(rs.getString("duration"));

                semestrs.add(semestr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return semestrs;
    }

    public static List<Discipline> getDisciplinesInSemestr(String idSem) {
        ArrayList<Discipline> disciplinesInSemestr = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM semester_discipline as sd\n" +
                    "left join discipline as d on sd.id_discipline = d.id\n" +
                    "Where sd.id_semester = " + idSem + " and d.status = 1;");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                int idDisc = rs.getInt("id_discipline");
                discipline.setId(idDisc);
                discipline.setDiscipline(rs.getString("discipline"));
                disciplinesInSemestr.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinesInSemestr;
    }

    public static Student getStudentById(String idStud) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where status = 1 and id = " + idStud);
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setGroup(rs.getString("group"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDate(rs.getString("date"));
                return student;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Mark> getMarksByStudentSemestr(String idStud, int idSemestr) {
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "akwredky");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students.mark \n" +
                    "LEFT JOIN semester_discipline AS sd ON mark.id_semestr_discipline = sd.id \n" +
                    "LEFT JOIN discipline  AS d ON sd.id_discipline = d.id = 1 \n" +
                    "LEFT JOIN semster AS s on sd.id_semester = s.id where mark.id_stud = "+idStud+"  \n" +
                    "AND sd.id_semester = "+idSemestr+" \n" +
                    "AND d.status = 1");

            while (rs.next()) {
                Mark mark = new Mark();
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_discipline"));
                discipline.setDiscipline(rs.getString("discipline"));
                discipline.setStatus(1);
                mark.setDiscipline(discipline);
                mark.setMark(rs.getString("mark"));
                marks.add(mark);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return marks;
    }

    public static void modifyStudent(String studentID, String name, String surname, String group, String date) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE student SET `surname` = '"+surname+"', `name` = '"+name+"', `group` = '"+group+"', `date` = '"+date+"' WHERE (`id` = "+studentID+");");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8","root","akwredky");
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE student SET status = '0' WHERE id = " + id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
