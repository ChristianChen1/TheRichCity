package cn.amychris.therichcity.validator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.util.StringUtil;
import cn.amychris.therichcity.validator.UserValidator;

@Scope("singleton")
@Component("userValidator")
public class UserValidatorImpl implements UserValidator {

	@Override
	public List<String> validate(UserEntity user) {
		List<String> errorMesg = new ArrayList<String>();

		// validate the emailAddress
		if (!StringUtil.isEmailAddress(user.getEmail())) {
			errorMesg.add(user.getEmail()+"��һ�����Ϸ����ʼ���ַ��");
		}
		
		//validate the name
		if (null == user.getName()||user.getName().length() == 0) {
			errorMesg.add("�û�������Ϊ�ա�");
		}

		//validate the passwd
		if (null == user.getPassword() || user.getPassword().length() < 6 || user.getPassword().length() > 30) {
			errorMesg.add("��������Ҫ��λ��������ʮλ��");
		}
		
		
		return errorMesg;
	}



}
