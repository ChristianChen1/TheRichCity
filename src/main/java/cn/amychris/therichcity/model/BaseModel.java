package cn.amychris.therichcity.model;

import java.util.Date;

public abstract class BaseModel {
	
	private Date	lastUpdateTime;

	private Date	creationDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate( Date creationDate ) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime( Date lastUpdateTime ) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
