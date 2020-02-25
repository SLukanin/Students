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

@WebServlet(name = "TermsController", urlPatterns = "/semestrs")
public class TermsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedTermId = req.getParameter("selectedTermId");

        List<Semester> semesters = DBManager.getAllActiveSemestrs();
        req.setAttribute("semestrs", semesters);

        if(selectedTermId == null){
            req.setAttribute("selectedTerm", semesters.get(0));
            List<Discipline> disciplinesBySelectedTerm = DBManager.getDisciplinesInSemestr(semesters.get(0).getId() + "");
            req.setAttribute("disciplinesByTerm", disciplinesBySelectedTerm);
        } else {
            for (Semester semester: semesters){
                String semesterID = semester.getId() +"";
                if(semesterID.equals(selectedTermId)){
                    req.setAttribute("selectedTerm", semester);
                    List<Discipline> disciplinesBySelectedTerm = DBManager.getDisciplinesInSemestr(semesterID);
                }
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/semestrs.jsp").forward(req, resp);
    }
}
