package controllers;

import database.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = " StudentModifyController", urlPatterns = "/student-modify")
public class StudentModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idModifyStudent");
        Student student = DBManager.getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/WEB-INF/jsp/student-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String group = req.getParameter("group");
        String date = req.getParameter("date");
        date = date.replace('/', '-');
        String studentID = req.getParameter("idModifyStudent");
        DBManager.modifyStudent(studentID, name,surname,group,date);
        resp.sendRedirect("/students");
    }
}
