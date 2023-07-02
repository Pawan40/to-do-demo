package edu.todotask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.todotask.modell.TaskModel;

/**
 * Servlet implementation class ViewTaskControler
 */
@WebServlet("/viewTaskControler")
public class ViewTaskControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TaskModel model=new TaskModel();
		List<Task>list=model.getAllTask();
		request.setAttribute("myTasks", list);
		RequestDispatcher dis=request.getRequestDispatcher("view-task.jsp");
		dis.forward(request, response);
	}

}
