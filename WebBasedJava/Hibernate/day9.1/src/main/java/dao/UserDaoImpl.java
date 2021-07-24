package dao;

import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public String addUserDetails(User user) {
		// TODO Auto-generated method stub
		return user.toString();
	}

	@Override
	public User findByUser(int userId) {
		// TODO Auto-generated method stub
		User user=null;
		return user;
	}

}
