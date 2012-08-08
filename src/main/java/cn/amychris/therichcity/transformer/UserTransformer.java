package cn.amychris.therichcity.transformer;

import org.apache.commons.beanutils.BeanUtils;

import cn.amychris.therichcity.exception.UserTransformingException;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.model.User;

public class UserTransformer {

	public static User transform( UserForm userForm ) {
		User re = new User();
		
		try {
			BeanUtils.copyProperties( re, userForm );
		} catch ( Exception e ) {
			throw new UserTransformingException( e );
		}

		return re;
	}

}
