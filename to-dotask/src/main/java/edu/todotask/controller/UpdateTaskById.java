package edu.todotask.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.todotask.modell.TaskModel;

/**
 * Servlet implementation class UpdateTaskById
 */
@WebServlet("/UpdateTaskById")
public class UpdateTaskById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		String scheduledOn = request.getParameter("ScheduledOn");
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		Date date = null;
		try {
			date = format.parse(scheduledOn);
		} catch (ParseException e) {
			e.printStackTrace();

		}
		// set the data into dto
		
		Task task = new Task();

		task.setTitle(title);
		task.setStatus(status);
		task.setScheduledOn(date);
		TaskModel model=new TaskModel();
		model.updateTaskId(task);
		response.sendRedirect("show-my-task");
	}

}
