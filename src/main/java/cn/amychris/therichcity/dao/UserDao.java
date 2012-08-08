package cn.amychris.therichcity.dao;

import java.util.List;

import cn.amychris.therichcity.model.User;

public interface UserDao {
	
	
	User getByEmail(String email);
	
	User getByName(String name);

	Long insert(User user);

	void delete(List<Long> uuid);

	void update(User user);
}
