package controllers;

import database.DBManager;
import entity.Mark;
import entity.Semester;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")
public class StudentProgressController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStud = req.getParameter("idStudentProgress");

        Student student = DBManager.getStudentById(idStud);

        List<Semester> semesters = DBManager.getAllActiveSemestrs();
        Semester selectedSemester = semesters.get(0);

        List<Mark> marks = DBManager.getMarksByStudentSemestr(idStud, selectedSemester.getId());

        req.setAttribute("marks", marks);
        req.setAttribute("selectedSemester", selectedSemester);
        req.setAttribute("student", student);
        req.setAttribute("semesters", semesters);

        req.getRequestDispatcher("/WEB-INF/jsp/student-porgress.jsp").forward(req, resp);
    }
}
