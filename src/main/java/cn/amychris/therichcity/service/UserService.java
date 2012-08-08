package cn.amychris.therichcity.service;

import java.util.List;

import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.model.User;

public interface UserService {

	User register ( User user );

	User getUserByEmail ( String email );

	User updateUser ( User user );

	void removeUsers ( List<User> users );

	User getUserByName ( String name );
	
	/*
	 * Login a user.
	 * 
	 * @param user {@link cn.amychris.therichcity.entity.User}
	 */
	void login( User user ) throws ExceedingMaxLoginUsersException, SecurityServiceException;

	/*
	 * Logout a user {@link cn.amychris.therichcity.entity.User}
	 * 
	 * @param user {@link cn.amychris.therichcity.entity.User}
	 */
	void logout( User user );

	int sizeOfLoginedUsers();

	boolean isUserLogined( User user );

}
