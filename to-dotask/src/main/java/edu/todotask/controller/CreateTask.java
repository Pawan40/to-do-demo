package edu.todotask.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.todotask.modell.TaskModel;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		// pass the data into model class
		TaskModel model = new TaskModel();
		boolean result = model.save(task);
		String code = result ? "200" : "500";
		// redirect to a page(response)
		response.sendRedirect("create-task.jsp?c=" + code);
	}
}
