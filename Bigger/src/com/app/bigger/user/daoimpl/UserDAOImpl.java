package com.app.bigger.user.daoimpl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.app.bigger.user.action.bean.UserLoginResult;
import com.app.bigger.user.dao.UserDAO;
import com.app.bigger.user.model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(u);
		return true;
	}

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		List<User> list = (List<User>) getHibernateTemplate().find(
				"from User where userphone=?", phone);
		if (list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public boolean deleteUserById() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserLoginResult findUserByPhoneAndPass(String phone, String password) {
		// TODO Auto-generated method stub
		UserLoginResult result = new UserLoginResult();
		List<User> list = (List<User>) getHibernateTemplate().find(
				"from User where userphone=? and userpassword=?", phone,
				password);
		if (list.size() == 0)
			return result;
		result.setUser(list.get(0));
		return result;
	}

}
