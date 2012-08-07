package cn.amychris.therichcity.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.amychris.therichcity.exception.BoardServiceException;
import cn.amychris.therichcity.model.Board;
import cn.amychris.therichcity.model.User;
import cn.amychris.therichcity.service.BoardService;

@Scope("singleton")
@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private int						maxPlayersPerBoard	= 6;

	private Map<Integer, Board>		boards				= new HashMap<Integer, Board>();

	private Map<User, Board>	userBoards			= new HashMap<User, Board>();

	@Override
	public List<Board> getAllBoards() {
		List<Board> re = new ArrayList<Board>();

//		for ( Board t : boards.values() ) {
//			re.add( ( Board ) t.clone() );
//		}

		return re;
	}

	@Override
	public Board getBoard( int boardNumber ) {
		return boards.get( boardNumber );
	}

	@Override
	public Board createBoard( User boardCreator ) {
		byte boardNumber = getNewBoardNumber();

		Board board = new Board();
		board.setBoardNumber( boardNumber );
		
		board.setMaxPlayers( (byte)this.getMaxPlayersPerBoard() );

		//boards.put( boardNumber, board );
		userBoards.put( boardCreator, board );
		return board;
	}

	@Override
	public void joinBoard( int boardNumber, User user ) {

		if ( userBoards.containsKey( user ) ) {
			throw new BoardServiceException( "User[" + user
					+ "] has already joined a board, if he/she want to join another board, he/she has to quite current board first." );
		}
		
		Board board = this.getBoard( boardNumber );
		
		
	}

	@Override
	public void startGame( int boardNumber, User boardCreator ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void quitBoard( User user ) {
		Board board = this.userBoards.get( user );
		
		if ( null == board ) {
			throw new BoardServiceException( "User[" + user + " has not joined any boards." );
		}
		
		
		this.userBoards.remove( user );

	}

	public void setMaxPlayersPerBoard( int maxPlayersPerBoard ) {
		this.maxPlayersPerBoard = maxPlayersPerBoard;
	}

	@Override
	public int getMaxPlayersPerBoard() {
		return maxPlayersPerBoard;
	}

	// return an available board number which starts from 1
	private byte getNewBoardNumber() {
		byte re = 0;
		
		while ( boards.containsKey( ++re ) ) {
		}
		
		return re;
	}

}
