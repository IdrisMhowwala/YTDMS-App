package com.yash.ytdms.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import com.yash.ytdms.dao.GroupDAO;
import com.yash.ytdms.domain.Group;
import com.yash.ytdms.exception.GroupException;
import com.yash.ytdms.exception.GroupStatusException;
import com.yash.ytdms.factory.ObjectFactory;
import com.yash.ytdms.service.GroupService;
import com.yash.ytdms.util.JNDIUtil;

public class GroupServiceImpl extends JNDIUtil implements GroupService {

	GroupDAO groupdao;
	Group group;
	

	public GroupServiceImpl() {
		groupdao = (GroupDAO) ObjectFactory.getObject(GroupDAO.class);
		
	}
	

	@Override
	public void updateGroup(int idOfGroup,int idOfTrainee) {
		String sql="UPDATE users SET groupId =? WHERE id=?";
		PreparedStatement preparedStatement=preparedStatement(sql);
		try {
			preparedStatement.setInt(1,idOfGroup);
			preparedStatement.setInt(2,idOfTrainee);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			closeConnection();
		}
		
	}

	
	@Override
	public void editGroup(Group group){
		groupdao.update(group);
	}

	@Override
	public List<Group> listGroup(int userId) {
		List<Group> groups = groupdao.findAllGroups(userId);
		return groups;
	}
	
	/**
	 * this method will create a group and insert it into group table
	 * @param group group to be created
	 */
	@Override
	public void createMyGroup(Group group) {
		GroupDAO groupDAO=(GroupDAO) ObjectFactory.getObject(GroupDAO.class);
		groupDAO.insert(group);
		
	}
	/**
	 * this method will create a general group
	 * and check whether groups table is present or not
	 * if not present then it will create it first and then creat a general group in it.
	 */
	@Override
	public void createGeneralGroup() {
		boolean rowStatus=false;
		rowStatus=rowExist();
		if(rowStatus==false)
		{
			createGenralGroupInDB();
				
		}		
	}
	/**
	 * this method create a groups table in database if not present
	 */
	/*private void createGroupsTableInDB() {
		PreparedStatement preparedStatement;
		String sqlToCreateTable="create table groups(id int primary key NOT NULL AUTO_INCREMENT,name varchar(100),userId int,description varchar(255),createdBy varchar(100),updatedBy varchar(100),start_date date,end_date date,status int)";
		preparedStatement=preparedStatement(sqlToCreateTable);
		try {
			preparedStatement.execute();
			System.out.println("Table Created !");
		} catch (SQLException e) {
			System.out.println("Table is not created due to ERROR occurred !");
			System.out.println("ERROR : "+e);
		}
	}*/
	/**
	 * this method create a general group in a groups table in database
	 */
	private void createGenralGroupInDB() {
		String sqlToCreateRow;
		PreparedStatement preparedStatement;
		Calendar calendar = Calendar.getInstance();
		java.sql.Date javaDateObject = new java.sql.Date(calendar.getTime().getTime());
		sqlToCreateRow="insert into groups(name,userId,description,createdBy,updatedBy,start_date,end_date,status) values('General group',0,'This is general group','NA','NA',?,?,1)";
		preparedStatement=preparedStatement(sqlToCreateRow);		
		try {
			preparedStatement.setDate(1,javaDateObject);
			preparedStatement.setDate(2,javaDateObject);
			preparedStatement.execute();
			System.out.println("General group created !");
		} catch (SQLException e) {
			System.out.println("general group is  not created due to ERROR occurred !");
			System.out.println("ERROR : "+e);
		}
		finally 
		{
			closeConnection();
		}
	}
	/**
	 * check whether table exists or not
	 * @return status of table presence
	 */
	/*private boolean tableExist(){
	    boolean tExists = false;
	    PreparedStatement preparedStatement;
	    String sql="SHOW TABLES LIKE 'groups'";
	    preparedStatement=preparedStatement(sql);
	    
	    try{
	    	ResultSet resultSet=preparedStatement.executeQuery();
	        if(resultSet.next()) { 
	                tExists = true;	                
	            }
	        
	    } catch (SQLException e) {
	    	System.out.println("Unable to check table exists or not due to ERROR occured !");
	    	System.out.println("ERROR : "+e);
		}
	    return tExists;
	}*/
	/**
	 * this method is to check whether the general group exist or not
	 * @return status of general group i.e. true or false
	 * true if avail or false if not avail
	 */
	private boolean rowExist(){
	    boolean rExists = false;
	   
	    PreparedStatement preparedStatement=preparedStatement("select * from groups where name like 'General group'");
	    try {
	    	ResultSet resultSet=preparedStatement.executeQuery();
	    	if (resultSet.next()) {
	    	     rExists=true;
	    	    }
	    	
	    } catch (SQLException e) {
	    	System.out.println("Unable to check column exists or not due to ERROR occured !");
	    	System.out.println("ERROR : "+e);
		}
	    finally 
		{
			closeConnection();
		}
	    return rExists;
	}

	@Override
	public List<Group> listGroups( int role) {
		List<Group> groups = groupdao.findAll(role);		
		return groups;
	}
	
	//ritik
	@Override
	public void changeStatus(int status,int id) throws GroupStatusException {
		group=new Group();
		statusChange(status, id);
		
		
	}
	private void statusChange(int status, int id) {
		if(status==ACTIVE) {			
			String sql="UPDATE groups SET STATUS=? WHERE id=?";
			try{
			PreparedStatement preparedStatement=preparedStatement(sql);
			preparedStatement.setInt(1, BLOCKED);
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(status==BLOCKED) {
			String sql="UPDATE groups SET STATUS=? WHERE id=?";
			try{
			PreparedStatement preparedStatement=preparedStatement(sql);
			preparedStatement.setInt(1, ACTIVE);
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			}catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
}
