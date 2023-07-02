package edu.todotask.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.todotask.modell.TaskModel;

/**
 * Servlet implementation class GetIdTask
 */
@WebServlet("/GetIdTask")
public class GetIdTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request. getParameter("id");
		TaskModel model=new TaskModel();
		Task task=model.getTaskById(Integer.parseInt(id));
		
		request.setAttribute("taskDetails", task);
		RequestDispatcher dis=request.getRequestDispatcher("update-task.jsp");
		dis.forward(request, response);
	}

}
