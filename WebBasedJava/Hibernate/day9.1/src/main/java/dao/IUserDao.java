package dao;

import pojos.User;

public interface IUserDao {
	String addUserDetails(User user);
	User findByUser(int userId);
}
