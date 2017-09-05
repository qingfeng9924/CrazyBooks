package com.crazybooks.base.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crazybooks.base.BaseHibernateDao;
import com.crazybooks.base.UserDao;
import com.crazybooks.dao.HibernateSessionFactory;
import com.crazybooks.etity.Books;
import com.crazybooks.etity.Borrow;
import com.crazybooks.etity.Collections;
import com.crazybooks.etity.Commentary;
import com.crazybooks.etity.Recharge;
import com.crazybooks.etity.Users;

public class UserDaoImpl extends BaseHibernateDao implements UserDao {

	@Override
	public void add(Users users) {
		// TODO Auto-generated method stub
		super.add(users);
	}

	public void addBorrow(Borrow borrow) {
		super.add(borrow);
	}

	@Override
	public void delete(Users users) {
		// TODO Auto-generated method stub
		super.delete(users);
	}

	@Override
	public void update(Users users) {
		// TODO Auto-generated method stub
		super.update(users);
	}

	@Override
	public Users get(int id) {
		// TODO Auto-generated method stub
		return (Users) super.get(Users.class, id);
	}

	@Override
	public String validateLogin(String loginName, String loginPwd) {// 验证登录
		// TODO Auto-generated method stub
		String flag = "none";
		Users condition = new Users();
		condition.setUserName(loginName);
		condition.setPassword(loginPwd);
		List list = super.search(Users.class, condition);
		if (list.size() > 0) {
			Users isFreezeUser = (Users) list.get(0);
			if (isFreezeUser.getFreezeState() == 1) {
				flag = "freeze";
			} else {
				flag = "success";
			}
		}
		return flag;
	}

	@Override
	public boolean validateRegister(String registerName) {// 验证注册
		// TODO Auto-generated method stub
		boolean flag = false;
		Users condition = new Users();
		condition.setUserName(registerName);
		List list = super.search(Users.class, condition);
		if (list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void register(Users users) {
		// TODO Auto-generated method stub
		add(users);
	}

	@Override
	public List get(Users user) {
		// TODO Auto-generated method stub
		List list = super.search(Users.class, user);
		return list;
	}

	@Override
	public JSONObject getUserCollection(Users user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		try {
			Query query = session
					.createQuery("from Users u,Collections c,Books b where u.id=c.users and c.books=b.id and u.userName=?");
			query.setString(0, user.getUserName());
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				JSONObject jsonSingle = new JSONObject();
				Books book = (Books) objects[2];
				jsonSingle.put("bookId", book.getId());
				jsonSingle.put("bookName", book.getName());
				jsonSingle.put("bookAuthor", book.getAuthor());
				jsonSingle.put("bookPublisher", book.getPubHouse());
				json.put(book.getId(), jsonSingle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject getUserComments(Users user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		try {
			Query query = session
					.createQuery("from Users u,Commentary c,Books b where u.id=c.users and c.books=b.id and u.userName=?");
			query.setString(0, user.getUserName());
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				JSONObject jsonSingle = new JSONObject();
				Commentary commentary = (Commentary) objects[1];
				Books book = (Books) objects[2];
				jsonSingle.put("bookId", book.getId());
				jsonSingle.put("bookName", book.getName());
				jsonSingle.put("comment", commentary.getCommentary());
				jsonSingle.put("commentTime", commentary.getCommentTime()
						.toString());
				json.put(commentary.getId(), jsonSingle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject getUserBorrow(Users user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		try {
			Query query = session
					.createQuery("from Users u,Borrow w,Books b where u.id=w.users and w.books=b.id and u.userName=?");
			query.setString(0, user.getUserName());
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				JSONObject jsonSingle = new JSONObject();
				Borrow borrow = (Borrow) objects[1];
				Books book = (Books) objects[2];
				jsonSingle.put("bookId", book.getId());
				jsonSingle.put("bookName", book.getName());
				jsonSingle.put("bookAuthor", book.getAuthor());
				jsonSingle.put("bookPublisher", book.getPubHouse());
				
				if(borrow.getBorrowTime()==null){
					jsonSingle.put("borrowTime", null);
				}
				else {
					jsonSingle.put("borrowTime", borrow.getBorrowTime().toString());
				}
				
				if(borrow.getDeadline()==null){
					jsonSingle.put("deadline", null);
				}
				else {
					jsonSingle.put("deadline", borrow.getDeadline().toString());
				}
				
				if (borrow.getReturnTime() == null) {
					jsonSingle.put("returnTime", null);
				} else {
					jsonSingle.put("returnTime", borrow.getReturnTime()
							.toString());
				}
				jsonSingle.put("borrowConsume", borrow.getConsumption());
				json.put(borrow.getId(), jsonSingle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject getUserConsume(Users user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		try {
			System.out.println("-------");
			// 查询借阅记录
			Query query = session
					.createQuery("from Users u,Borrow w,Books b where u.id=w.users and w.books=b.id and u.userName=?");
			query.setString(0, user.getUserName());
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				JSONObject jsonSingle = new JSONObject();
				Borrow borrow = (Borrow) objects[1];
				if (borrow.getReturnTime() != null) {
					jsonSingle.put("type", "borrow");
					jsonSingle.put("time", borrow.getReturnTime().toString());
					jsonSingle.put("money", "-" + borrow.getConsumption());
					json.put("borrow" + borrow.getId(), jsonSingle);
				}
			}

			// 查询充值记录
			Query query2 = session
					.createQuery("from Users u,Recharge r where u.id=r.users and u.userName=?");
			query2.setString(0, user.getUserName());
			List<Object[]> list2 = query2.list();
			for (Object[] objects : list2) {
				JSONObject jsonSingle = new JSONObject();
				Recharge recharge = (Recharge) objects[1];
				jsonSingle.put("type", "recharge");
				jsonSingle.put("time", recharge.getRechargeTime().toString());
				jsonSingle.put("money", "+" + recharge.getAmount());
				json.put("recharge" + recharge.getId(), jsonSingle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject addMoney(Users user) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		try {
			Transaction trans = session.beginTransaction();
			Query query = session
					.createQuery("update Users u set u.balance=?+u.balance where u.userName=?");
			query.setFloat(0, user.getBalance());
			query.setString(1, user.getUserName());
			int result = query.executeUpdate();
			trans.commit();
			if (result > 0) {
				json.put("type", "success");
			} else {
				json.put("type", "error");
			}
			session.close();

			// Session session2=HibernateSessionFactory.getSession();
			// Transaction transaction=session2.beginTransaction();
			// Recharge recharge=new Recharge();
			// Users condition=new Users();
			// condition.setUserName(user.getUserName());
			// List list=super.search(Users.class, condition);
			// Users targetUser=(Users)list.get(0);
			// recharge.setUsers(targetUser);
			// recharge.setAmount(targetUser.getBalance());
			// recharge.setRechargeTime(new Date());
			// session2.save(recharge);
			// transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public JSONObject alterPass(Users user, String newPass) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		JSONObject json = new JSONObject();
		Users condition = new Users();
		condition.setUserName(user.getUserName());
		condition.setPassword(user.getPassword());
		List list = super.search(Users.class, condition);
		if (list.size() > 0) {
			Users alterUser = (Users) list.get(0);
			try {
				Session session2 = HibernateSessionFactory.getSession();
				Transaction trans = session2.beginTransaction();
				Query query = session2
						.createQuery("update Users u set u.password=? where u.userName=?");
				query.setString(0, newPass);
				query.setString(1, alterUser.getUserName());
				int result = query.executeUpdate();
				trans.commit();
				if (result > 0) {
					System.out.println("resultok");
					json.put("type", "success");
				} else {
					json.put("type", "error");
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			json.put("type", "originError");
		}
		return json;
	}

	@Override
	public JSONObject alterUserInfo(Users user) {
		// TODO Auto-generated method stub
		Users condition = new Users();
		condition.setUserName(user.getUserName());
		List list = super.search(Users.class, condition);
		Users targetUser = (Users) list.get(0);
		targetUser.setName(user.getName());
		targetUser.setSex(user.getSex());
		targetUser.setAddress(user.getAddress());
		targetUser.setPhoneNum(user.getPhoneNum());
		targetUser.setEmail(user.getEmail());
		update(targetUser);
		JSONObject json = new JSONObject();
		json.put("type", "success");
		return json;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> userList = new ArrayList<Users>();
		Session session = HibernateSessionFactory.getSession();
		try {
			Query query = session
					.createQuery("select u from Users u where u.freezeState=0");
			userList = query.list();
			System.out.println(userList.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<Users> getUsersWithCondition(Users user) {
		// TODO Auto-generated method stub
		user.setFreezeState(0);
		List<Users> list = super.search(Users.class, user);
		return list;
	}

	public String insertIntoCollection(Users user, Books book,Date deadine) {
		try {
			//获得User实体类
			HibernateSessionFactory.getSession().getTransaction().begin();
			Users targetUser = (Users)HibernateSessionFactory.getSession().createQuery("from Users where userName=?").setString(0, user.getUserName()).list().get(0);
			HibernateSessionFactory.getSession().getTransaction().commit();
			
			//获得Book实体类
			HibernateSessionFactory.getSession().getTransaction().begin();
			Books targetBook = (Books)HibernateSessionFactory.getSession().createQuery("from Books where id=?").setInteger(0, book.getId()).list().get(0);
			HibernateSessionFactory.getSession().getTransaction().commit();
			
			//创建Borrow实体类
			Borrow borrow = new Borrow();
			borrow.setUsers(targetUser);
			borrow.setBooks(targetBook);
			borrow.setBorrowTime(new Date());
			borrow.setDeadline(deadine);
			
			//添加Borrow实体
			HibernateSessionFactory.getSession().getTransaction().begin();
			HibernateSessionFactory.getSession().save(borrow);
			HibernateSessionFactory.getSession().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}

	public void returnBook(Users user, int bookId) {
		try {
			System.out
					.println("--------------------kaishi--------------------");
			HibernateSessionFactory.getSession().getTransaction().begin();
			Books targetBook = (Books) (HibernateSessionFactory.getSession()
					.get(Books.class, bookId));
			if (targetBook == null) {
				return;
			}
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("bookId" + targetBook.getId());

			HibernateSessionFactory.getSession().getTransaction().begin();
			String hql = "from Users where userName=?";
			Users targetUser = (Users) HibernateSessionFactory.getSession()
					.createQuery(hql).setString(0, user.getUserName()).list()
					.get(0);
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("userId:" + targetUser.getId());

			Borrow borrow = new Borrow();
			borrow.setUsers(targetUser);
			borrow.setBooks(targetBook);

			HibernateSessionFactory.getSession().getTransaction().begin();
			String hql2 = "from Borrow where users=? and books=?";
			Borrow targetBorrow = (Borrow) HibernateSessionFactory.getSession()
					.createQuery(hql2).setInteger(0, targetUser.getId())
					.setInteger(1, targetBook.getId()).list().get(0);
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("borrowId:" + targetBorrow.getId());

			targetBorrow.setReturnTime(new Date());
			targetBorrow.setConsumption(Float.parseFloat(Math.random() * 50
					+ ""));

			HibernateSessionFactory.getSession().getTransaction().begin();
			HibernateSessionFactory.getSession().update(targetBorrow);
			HibernateSessionFactory.getSession().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public JSONObject addCollection(int bookId, String userName) {
		// 创建一个用于放回值的json
		JSONObject json = new JSONObject();
		// 查询到书籍实体类
		HibernateSessionFactory.getSession().getTransaction().begin();
		Books book = (Books) (HibernateSessionFactory.getSession().get(
				Books.class, bookId));
		HibernateSessionFactory.getSession().getTransaction().commit();

		// 查询用户实体类
		HibernateSessionFactory.getSession().getTransaction().begin();
		Users user = (Users) HibernateSessionFactory.getSession()
				.createQuery("from Users where userName = ?")
				.setString(0, userName).list().get(0);
		HibernateSessionFactory.getSession().getTransaction().commit();

		// 创建要插入的Collection类
		Collections collection = new Collections();
		collection.setUsers(user);
		collection.setBooks(book);
		collection.setCollectTime(new Date());

		// 查询Collections中是否已存在该收藏
		HibernateSessionFactory.getSession().getTransaction().begin();
		List list = HibernateSessionFactory.getSession()
				.createQuery("from Collections where users=? and books=?")
				.setInteger(0, user.getId()).setInteger(1, book.getId()).list();
		HibernateSessionFactory.getSession().getTransaction().commit();
		if (list.size() > 0) {
			json.put("type", "error");
			return json;
		}

		System.out.println(collection.getUsers().getId() + ":"
				+ collection.getBooks().getId() + ":"
				+ collection.getCollectTime().toString());

		// 插入
		HibernateSessionFactory.getSession().getTransaction().begin();
		HibernateSessionFactory.getSession().save(collection);
		HibernateSessionFactory.getSession().getTransaction().commit();
		System.out.println("ok");
		json.put("type", "success");
		return json;
	}

	public JSONObject deleteUserCollection(String userName, int bookId) {
		// 创建json返回类
		JSONObject json = new JSONObject();

		// 获取书籍实体
		HibernateSessionFactory.getSession().getTransaction().begin();
		Books book = (Books) (HibernateSessionFactory.getSession().get(
				Books.class, bookId));
		HibernateSessionFactory.getSession().getTransaction().commit();

		// 查询用户实体类
		HibernateSessionFactory.getSession().getTransaction().begin();
		Users user = (Users) HibernateSessionFactory.getSession()
				.createQuery("from Users where userName = ?")
				.setString(0, userName).list().get(0);
		HibernateSessionFactory.getSession().getTransaction().commit();

		// 查询收藏实体
		HibernateSessionFactory.getSession().getTransaction().begin();
		Collections collection = (Collections) HibernateSessionFactory
				.getSession()
				.createQuery("from Collections where users=? and books=?")
				.setInteger(0, user.getId()).setInteger(1, book.getId()).list()
				.get(0);
		HibernateSessionFactory.getSession().getTransaction().commit();
		
		System.out.println(collection.getId()+"---------------");
		//删除该收藏
		HibernateSessionFactory.getSession().getTransaction().begin();
		HibernateSessionFactory.getSession().delete(collection);
		HibernateSessionFactory.getSession().getTransaction().commit();
		json.put("type", "success");
		return json;
	}

}
