package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.game.card.ConstructureCard;
import cn.amychris.therichcity.game.card.RoleCard;
import cn.amychris.therichcity.model.User;

public interface Player {
	
	boolean isKilled();
	
	boolean isMoneyStolen();
	
	boolean isNowMyTurn();
	
	boolean isManagedByServer();
	
	User getUser();

	RoleCard getRole();
	
	void setRole(RoleCard role);

	int getMoney();

	List<ConstructureCard> getConstructures();

	void acquireMoney();

	void acquireConstucture();

	void buildConstructure(ConstructureCard constructureCard);
}
