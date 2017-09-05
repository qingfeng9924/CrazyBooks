package com.crazybooks.base.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import net.sf.json.JSONObject;

import com.crazybooks.base.AdminDao;
import com.crazybooks.base.BaseHibernateDao;
import com.crazybooks.dao.HibernateSessionFactory;
import com.crazybooks.etity.Borrow;
import com.crazybooks.etity.Managers;
import com.crazybooks.etity.Users;

public class AdminDaoImpl extends BaseHibernateDao implements AdminDao{

	@Override
	public JSONObject AdminLogin(Managers manager) {
		// TODO Auto-generated method stub
		JSONObject json=new JSONObject();
		List list=super.search(Managers.class, manager);
		if(list.size()>0){
			json.put("result", "success");
		}
		else {
			json.put("result", "error");
		}
		return json;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> list=null;
		Session session=HibernateSessionFactory.getSession();
		try {
			Query query=session.createQuery("from Users");
			list=query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Users> getFreezeUsers() {
		// TODO Auto-generated method stub
		List<Users> list=null;
		Session session=HibernateSessionFactory.getSession();
		try {
			Query query=session.createQuery("select u from Users u where u.freezeState=1");
			list=query.list();
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String freezeUser(Users user) {
		// TODO Auto-generated method stub	
		Users targetUser=(Users)super.search(Users.class, user).get(0);
		targetUser.setFreezeState(1);
		update(targetUser);
		return "success";
	}

	@Override
	public String unFreezeUser(Users user) {
		// TODO Auto-generated method stub
		Users targetUser=(Users)super.search(Users.class, user).get(0);
		targetUser.setFreezeState(0);
		update(targetUser);
		return "success";
	}

}
