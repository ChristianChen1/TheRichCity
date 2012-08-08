package cn.amychris.therichcity.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.exception.ExceedingMaxLoginUsersException;
import cn.amychris.therichcity.exception.SecurityServiceException;
import cn.amychris.therichcity.exception.UserNotfoundException;
import cn.amychris.therichcity.model.User;
import cn.amychris.therichcity.service.UserService;

@Scope("singleton")
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	private static final transient Log	log	= LogFactory.getLog( UserServiceImpl.class );

	private List<User>			loginUser;

	private int							maxLoginUsers;

	@Resource(name = "userDao")
	private UserDao						userDao;

	public UserServiceImpl(int maxLoginUsers) {
		this.maxLoginUsers = maxLoginUsers;
		loginUser = new LinkedList<User>();
	}

	@Override
	public User register( User user ) {
		log.debug( "Enter register(user[" + user + "])..." );

		userDao.insert( user );
		User result = userDao.getByEmail( user.getEmail() );
		log.debug( "Registered user[" + result + "] successfully." );

		return result;
	}

	@Override
	public User getUserByEmail( String email ) {
		log.debug( "Enter getByEmail(user[" + email + "])..." );
		User re = userDao.getByEmail( email );
		log.debug( "Got user[" + re + "] successfully." );
		return re;
	}

	@Override
	public User updateUser( User user ) {
		log.debug( "Enter updateUser(user[" + user + "])..." );

		if ( null == userDao.getByEmail( user.getEmail() ) ) {
			throw new UserNotfoundException( user + "not found" );
		}

		userDao.update( user );
		return userDao.getByEmail( user.getEmail() );
	}

	@Override
	public void removeUsers( List<User> users ) {
		log.debug( "Enter removeUsers()..." );
		if ( null == users ) {
			throw new NullPointerException( "userList is null" );
		}

		List<Long> uuidList = new ArrayList<Long>();
		for ( User user : users ) {
			uuidList.add( user.getUuid() );
		}

		userDao.delete( uuidList );

		if ( log.isDebugEnabled() ) {
			for ( User user : users ) {
				log.debug( "Removed user[" + user + "] successfully." );
			}
		}
	}

	@Override
	public User getUserByName( String name ) {
		log.debug( "Enter getByName(user[" + name + "])..." );
		User re = userDao.getByName( name );
		log.debug( "Got user[" + re + "] successfully." );
		return re;
	}

	@Override
	public void login( User user ) {
		if ( null == user ) {
			throw new NullPointerException( "User could not be null." );
		}

		if ( loginUser.contains( user ) ) {
			throw new SecurityServiceException( "User(" + user.toString() + ") has already logined." );
		}

		synchronized ( loginUser ) {
			if ( loginUser.size() == maxLoginUsers ) {
				throw new ExceedingMaxLoginUsersException( "The maximum number of users can login is " + maxLoginUsers );
			}

			loginUser.add( user );
		}
	}

	@Override
	public void logout( User user ) {
		if ( null == user ) {
			throw new NullPointerException( "User could not be null." );
		}

		if ( !loginUser.contains( user ) ) {
			throw new SecurityServiceException( "User(" + user.toString() + ") hasn't logined." );
		}

		loginUser.remove( user );

	}

	@Override
	public int sizeOfLoginedUsers() {
		return loginUser.size();
	}

	@Override
	public boolean isUserLogined( User user ) {
		// TODO Auto-generated method stub
		return false;
	}

}
