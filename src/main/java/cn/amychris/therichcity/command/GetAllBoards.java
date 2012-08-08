package cn.amychris.therichcity.command;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.amychris.therichcity.exception.CommandExecutingException;
import cn.amychris.therichcity.model.Board;
import cn.amychris.therichcity.service.BoardService;
import cn.amychris.therichcity.util.StringUtil;

public class GetAllBoards implements Command {
	private static final transient Log log = LogFactory.getLog( GetAllBoards.class );

	private BoardService	tableService;

	public GetAllBoards(BoardService tableService) {
		this.tableService = tableService;
	}

	@Override
	public String execute( Object arg ) {
		throw new CommandExecutingException( "There is no parameter needed for GetAllBoards." );
	}

	@Override
	public String execute() {
		log.debug( "Enter execute()..." );
		List<Board> boards = tableService.getAllBoards();
		
		if ( log.isDebugEnabled() ) {
			log.debug( "Got " + boards.size() + " boards." );
			
			for ( Board t : boards ) {
				log.debug( "Board: " + t );
			}
		}
		
		String result = StringUtil.toJSONString( boards );
		
		log.debug( "Return result: " + result );
		return result;
	}

}
