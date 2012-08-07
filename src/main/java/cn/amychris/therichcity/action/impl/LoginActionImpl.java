package cn.amychris.therichcity.action.impl;

import cn.amychris.therichcity.action.LoginAction;
import cn.amychris.therichcity.form.UserForm;
import cn.amychris.therichcity.model.User;
import cn.amychris.therichcity.service.UserService;

public class LoginActionImpl extends BaseActionImpl implements LoginAction {

	private UserService userService;

	private UserForm userForm = new UserForm();

	@Override
	public String login () {

		User user = userService.getUserByEmail( userForm.getEmail() );
		userService.login( user );
		return "Login Successfully";
	}

	public UserForm getUserForm () {
		return userForm;
	}

	public void setLoginService ( UserService userService ) {
		this.userService = userService;
	}

	public void setUserService ( UserService userService ) {
		this.userService = userService;
	}

}
