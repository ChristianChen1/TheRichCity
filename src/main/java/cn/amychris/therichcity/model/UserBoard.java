package cn.amychris.therichcity.model;

import cn.amychris.therichcity.util.MathUtil;

public class UserBoard extends BaseModel {

	private Integer	uuid;

	private User	user;

	private Board	board;

	private boolean	isHost;

	public User getUser() {
		return user;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard( Board board ) {
		this.board = board;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost( boolean isHost ) {
		this.isHost = isHost;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid( Integer uuid ) {
		this.uuid = uuid;
	}

	@Override
	public int hashCode() {
		if ( null != uuid ) {
			return uuid.hashCode();
		}

		return super.hashCode();
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || !(o instanceof Board) ) {
			return false;
		}

		UserBoard ub = ( UserBoard ) o;
		
		if ( ! MathUtil.equals( this.uuid, ub.uuid ) ) {
			return false;
		}

		if ( null != this.user ) {
			if ( !this.user.equals( ub.user ) ) {
				return false;
			}
		} else if ( null != ub.user ) {
			return false;
		}

		if ( null != this.board ) {
			if ( !this.board.equals( ub.board ) ) {
				return false;
			}
		} else if ( null != ub.board ) {
			return false;
		}

		return this.isHost == ub.isHost;
	}
}
