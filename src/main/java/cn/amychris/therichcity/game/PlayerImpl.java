package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.game.card.ConstructureCard;
import cn.amychris.therichcity.game.card.RoleCard;
import cn.amychris.therichcity.model.User;

public class PlayerImpl implements Player {

	private Game game;

	private User user;

	private RoleCard role;

	private int money = 0;

	private boolean isManagedByServer = false;

	private List<ConstructureCard> constructureCards;

	public PlayerImpl(User user, Game game) {
		if (null == user || null == game) {
			throw new NullPointerException("Neither user nor game could be null.");
		}

		this.user = user;
		this.game = game;
	}

	@Override
	public RoleCard getRole() {
		return this.role;
	}

	@Override
	public boolean isManagedByServer() {
		return this.isManagedByServer;
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public List<ConstructureCard> getConstructures() {
		return this.constructureCards;
	}

	@Override
	public void acquireMoney() {
		this.role.doAcquireMoney();
	}

	@Override
	public void acquireConstucture() {
		this.role.doAcquireConstucture();
	}

	@Override
	public void buildConstructure(ConstructureCard constructureCard) {
		this.role.buildConstructure(constructureCard);
	}

	@Override
	public boolean isKilled() {
		return this.role.isKilled();
	}

	@Override
	public boolean isMoneyStolen() {
		return this.role.isMoneyStolen();
	}

	@Override
	public boolean isNowMyTurn() {
		return this.role.isNowMyTurn();
	}

	@Override
	public User getUser() {
		return this.user;
	}

	@Override
	public void setRole(RoleCard role) {
		this.role = role;
	}
}
