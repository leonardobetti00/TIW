package it.polimi.tiw.test.project.controllers;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class Document
 */
@WebServlet("/GetDocument")
public class Document extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	
    public void init() throws ServletException {
		ServletContext context = getServletContext();}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Document() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fold = req.getParameter("folder");
		String subfolder = req.getParameter("subfolder");
		String cdocument=req.getParameter("document");
		DocumentDao Ddao=new DocumentDao(connection);
		ServletContext context = getServletContext();
		String user = context.getInitParameter("User");
		if(cdocument.equals("null")) { 
		try {
		ArrayList<document> alldocument=Ddao.loadDocument(user, fold, subfolder);
		// Forward to appropriate JSP page sending the topic and messages
					String path = "/WEB-INF/document.jsp";
					req.setAttribute("document", alldocument);
					RequestDispatcher dispatcher = req.getRequestDispatcher(path);
					dispatcher.forward(req, res);

				} catch (SQLException e) {
					res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database access failed");}}
		
		else {
			try {	
				ArrayList<document> alldocument=Ddao.loadDocument(user, fold, subfolder);
				for(document docu:alldocument) {
					if(docu.getName()==cdocument){
						String path = "/WEB-INF/documentinfo.jsp";
						req.setAttribute("document", docu);
						RequestDispatcher dispatcher = req.getRequestDispatcher(path);
						dispatcher.forward(req, res);	
					}
					
					
				}
		} catch (SQLException e) {
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database access failed");}}
			
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
