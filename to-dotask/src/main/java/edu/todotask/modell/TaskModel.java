package edu.todotask.modell;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.todotask.controller.Task;
public class TaskModel 
{
  final String insert="insert into task(id,title,status,scheduledOn)values(task_seq.nextVal,?,?,?)";
  final String select="select * from task";
  public boolean save(Task task) {
	  boolean result=false;
	  try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","pranjal");
		  PreparedStatement stmt=con.prepareStatement(insert);
		  stmt.setString(1,task.getTitle());
		  stmt.setString(2,task.getStatus());
		  stmt.setDate(3, new java.sql.Date(task.getScheduledOn().getTime()));
		  int count=stmt.executeUpdate();
		  result=count>0;
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  
  return result;
  }


public List<Task>getAllTask(){
	ArrayList<Task>list=new ArrayList<Task>();
	
		try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","pranjal");
			  PreparedStatement stmt=con.prepareStatement(select);
			  ResultSet rs=stmt.executeQuery();
			  while(rs.next()) {
				  Task task=new Task();
			  task.setId(rs.getInt("id"));
			  task.setTitle(rs.getString("title"));
			  task.setStatus(rs.getString("status"));
			  task.setScheduledOn(rs.getDate("scheduledOn"));
			  task.setUpdateOn(rs.getDate("UpdateOn"));
			  list.add(task);
			  }
		}
		
	
		  
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  return list;
}

public Task getTaskById(int id)
{
 Task task=null;
 try
 {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","pranjal");
	  PreparedStatement stmt=con.prepareStatement("select * from task where id=?");
	  stmt.setInt(1, id);
	  ResultSet rs=stmt.executeQuery();
	  if(rs.next())
	  {
		  Task task1 =new Task();
	  task1.setId(rs.getInt("id"));
	  task1.setTitle(rs.getString("title"));
	  task1.setStatus(rs.getString("status"));
	  task1.setScheduledOn(rs.getDate("scheduledOn"));
	  task1.setUpdateOn(rs.getDate("UpdateOn"));
	 	  }
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 
 return task;

 }


public boolean updateTaskId(Task task) {
	// TODO Auto-generated method stub
	 boolean result=false;
	  try {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","pranjal");
		  PreparedStatement stmt=con.prepareStatement("update task set title=?,status=?,scheduledOn=?,updateon=sysdate where id=?");
		  stmt.setString(1,task.getTitle());
		  stmt.setString(2,task.getStatus());
		  stmt.setDate(3, new java.sql.Date(task.getScheduledOn().getTime()));
		  int count=stmt.executeUpdate();
		  result=count>0;
		  con.close();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
 
 return result;
}
	
}

