package edu.todotask.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(servletNames = { "edu.todotask.controller.CreateTask" })
public class Filter extends HttpFilter implements javax.servlet.Filter {
       
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		//get the parameter from the request
		String title=req.getParameter("title");
		String scheduledOn=req.getParameter("scheduledOn");
		//this list to add error msg
		ArrayList<String>erros=new ArrayList<String>();
		if(title==null||title.isEmpty())
		{
			erros.add("Please provide the title");
		}
		if(scheduledOn==null||scheduledOn.isEmpty())
		{
			erros.add("Please provide the scheduledOn date");
		}
		if(erros.isEmpty())
		{
		
		chain.doFilter(req,res);
	    }
		else {
			req.setAttribute("errorList", erros);
			RequestDispatcher dis=req.getRequestDispatcher("create-task.jsp");
			dis.forward(req, res);
		}

	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
