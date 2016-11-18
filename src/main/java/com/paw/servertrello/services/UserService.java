package com.paw.servertrello.services;

import java.util.ArrayList;

import org.hibernate.Session;

import com.paw.servertrello.database.Database;
import com.paw.servertrello.models.BoardModel;
import com.paw.servertrello.models.BoardaccesstableModel;
import com.paw.servertrello.models.UserModel;

public class UserService 
{

	public static UserModel find(Long id) 
	{
		return selectUserById(id);
	}

	public static UserModel selectUserByName(String name)
	{
		try
		{
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where name = '"+name+"'").getResultList();
			UserModel user = usersList.get(0);
			user.setBoardsList(getUserBoards(user.getUserId()));
			session.close();
			return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static UserModel selectUserById(Long userId) 
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where userId ="+userId).getResultList();
			UserModel user = usersList.get(0);
			user.setBoardsList(getUserBoards(user.getUserId()));
			session.close();
			return user;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static UserModel selectUserByEmail(String email)
	{
    	try
        {
			Session session = Database.openSession();
			@SuppressWarnings("unchecked")
			ArrayList<UserModel> usersList = (ArrayList<UserModel>) session.createQuery("from Users p where email ='"+email+"'").getResultList();
			UserModel user = usersList.get(0);
			user.setBoardsList(getUserBoards(user.getUserId()));
			session.close();
			return user;
        }
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private static ArrayList<BoardModel> getUserBoards(long userId) throws Exception
	{
		ArrayList<BoardaccesstableModel> bat = BoardaccesstableService.getBoardAccessTableByUserId(userId);
		ArrayList<BoardModel> boardsList = new ArrayList<BoardModel>();
		for(int i =0; i<bat.size(); i++)
		{
			if(bat.get(i).getUserId() == userId)
			{
				boardsList.add(BoardService.selectBoardByIdWithoutLists(bat.get(i).getBoardId()));
			}
		}
		return boardsList;
	}
}
