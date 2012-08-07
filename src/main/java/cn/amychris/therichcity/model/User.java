package cn.amychris.therichcity.model;

import cn.amychris.therichcity.util.MathUtil;
import cn.amychris.therichcity.util.StringUtil;

public class User extends BaseModel {
	private Long		uuid;
	private String		name;
	private String		password;
	private String		email;
	private Long		score;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid( Long uuid ) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	public Long getScore() {
		return score;
	}

	public void setScore( Long score ) {
		this.score = score;
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || !(o instanceof Board) ) {
			return false;
		}

		User u = ( User ) o;

		if ( !MathUtil.equals( this.uuid, u.uuid ) ) {
			return false;
		}

		if ( !StringUtil.equals( this.name, u.name ) ) {
			return false;
		}

		if ( !StringUtil.equals( this.email, u.email ) ) {
			return false;
		}

		if ( !StringUtil.equals( this.password, u.password ) ) {
			return false;
		}

		if ( !MathUtil.equals( this.score, u.score ) ) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		if ( null != uuid ) {
			return uuid.hashCode();
		}

		return super.hashCode();
	}
}
