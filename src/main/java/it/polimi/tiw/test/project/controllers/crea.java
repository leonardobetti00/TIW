package it.polimi.tiw.test.project.controllers;
import java.util.ArrayList;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.polimi.tiw.test.project.dao.*;
import it.polimi.tiw.test.project.beans.*;

/**
 * Servlet implementation class GetFeS
 */
@WebServlet("/crea")
public class crea extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public crea() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {

        ServletContext context = getServletContext();
        String user = context.getInitParameter("User");
        String password = context.getInitParameter("dbPassword");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       /* FSdao fsdao = new FSdao(connection);
        List<folder> fold;
        String path = "/WEB-INF/Crea.jsp";//da SOSTITUIRE CON IL FILE HTML CORRETTO
        ServletContext context = getServletContext();
        String user = context.getInitParameter("User");
        fold = fsdao.loadfolder(user);
        List<FoldORSub> allfolder = this.(fold);
        req.setAttribute("allfolder", allfolder);
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, res);*/
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }




    public void destroy() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqle) {
        }
    }
}
