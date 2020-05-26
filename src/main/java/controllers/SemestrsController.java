package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Semester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SemestrsController", urlPatterns = "/semestrs1")
public class SemestrsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Semester> semestrs = DBManager.getAllActiveSemestrs();

        req.setAttribute("semestrs",semestrs);

//        String idSem = req.getParameter("idSem");
//        List<Discipline> disciplinesInSemestr = DBManager.getDisciplinesInSemestr(idSem);
//        req.setAttribute("disciplinesInSemestr",disciplinesInSemestr);
        req.getRequestDispatcher("/WEB-INF/jsp/semestrs.jsp").forward(req,resp);
    }

}
