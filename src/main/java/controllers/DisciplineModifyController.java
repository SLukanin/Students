package controllers;

import database.DBManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@WebServlet(name = "DisciplineModifyController", urlPatterns = "/modify-discipline")

public class DisciplineModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDisc = req.getParameter("idModifyDisc");
        Discipline discipline = DBManager.getDisciplineById(idDisc);
        req.setAttribute("discipline", discipline);
        req.getRequestDispatcher("/WEB-INF/jsp/discipline-modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("secondName");
        String discID = req.getParameter("idModifyDisc");
        DBManager.modifyDiscipline(discID, name);
        resp.sendRedirect("/disciplines");
    }
}
