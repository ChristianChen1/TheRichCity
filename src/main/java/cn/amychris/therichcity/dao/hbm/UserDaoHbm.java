package cn.amychris.therichcity.dao.hbm;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.amychris.therichcity.dao.UserDao;
import cn.amychris.therichcity.entity.UserEntity;

/*
 * @author Zhang Yanxia
 * 
 * Implementation of <code>UserDao</code>, using Hibernate framework.
 */

@Scope("prototype")
@Repository("userDao")
public class UserDaoHbm implements UserDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity getByEmail(String email) {

		if (null == email) {
			throw new NullPointerException("email cann't be null.");
		}

		UserEntity user = new UserEntity();
		user.setEmail(email);
		List<UserEntity> list = (List<UserEntity>) this.hibernateTemplate.findByExample(user);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Long insert(UserEntity user) {
		if (null == user.getEmail() || null == user.getName()
				|| null == user.getPassword()) {
			throw new NullPointerException(
					"email and name and password cann't be null.");
		}

		user.setUuid(null);
		user.setRegisterDate(new Date());
		return (Long)this.hibernateTemplate.save(user);
	}

	@Override
	public void delete(Long uuid) {
		UserEntity user = new UserEntity();
		user.setUuid(uuid);
		this.hibernateTemplate.delete(user);
	}

	@Override
	public void update(UserEntity user) {
		user.setLastUpdateTime(null);
		user.setRegisterDate(null);
		this.hibernateTemplate.update(user);
	}

}
