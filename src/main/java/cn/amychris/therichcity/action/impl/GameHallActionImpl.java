package cn.amychris.therichcity.action.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.amychris.therichcity.action.GameHallAction;
import cn.amychris.therichcity.model.Board;
import cn.amychris.therichcity.model.User;
import cn.amychris.therichcity.service.BoardService;
import cn.amychris.therichcity.service.UserService;

public class GameHallActionImpl extends BaseActionImpl implements GameHallAction {
	
	private static final transient Log log = LogFactory.getLog( GameHallActionImpl.class );
	
	private UserService userService;
	
	private BoardService boardService;

	public String createTable() {
		log.debug( "Enter createTable()..." );
		
		User user = userService.getUserByEmail( this.getUserForm().getName() );
		Board board = boardService.createBoard( user );
		
		if ( log.isDebugEnabled() ) {
			log.debug( "Created board:" + board + " by user: " + user.getName() );
		}
		
		return "Created Board Successfully";
	}
}
