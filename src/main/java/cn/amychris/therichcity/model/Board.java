package cn.amychris.therichcity.model;


/**
 * 
 * @author Christian Chen
 * 
 *         A table is place holding some users(or players) and it can start a
 *         game.
 * 
 */
public class Board extends BaseModel implements Comparable<Board> {

	private Short	boardNumber;

	private boolean	isStarted	= false;

	// The maximum number of users(players) can sit at this table.
	private byte		maxPlayers	= 6;


	public Short getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber( short boardNumber ) {
		this.boardNumber = boardNumber;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted( boolean started ) {
		this.isStarted = started;
	}

	public byte getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers( byte maxPlayers ) {
		this.maxPlayers = maxPlayers;
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || !(o instanceof Board) ) {
			return false;
		}

		Board b = ( Board ) o;
		return this.boardNumber == b.boardNumber && this.isStarted == b.isStarted && this.maxPlayers == b.maxPlayers;
	}

	@Override
	public int hashCode() {
		return this.boardNumber;
	}

	@Override
	public int compareTo( Board o ) {
		return this.boardNumber - o.boardNumber;
	}

}
