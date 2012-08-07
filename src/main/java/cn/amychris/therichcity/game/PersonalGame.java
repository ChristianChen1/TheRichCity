package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.exception.IllegalOperationException;
import cn.amychris.therichcity.game.card.ConstructureCard;
import cn.amychris.therichcity.game.card.RoleCard;
import cn.amychris.therichcity.model.User;

public class PersonalGame implements Game {

	private List<Player> players;

	private List<ConstructureCard> constructureCards;

	private List<RoleCard> availableRoles;

	private List<RoleCard> selectedRoles;

	public PersonalGame(List<User> users, List<ConstructureCard> constructureCards, List<RoleCard> availableRoles) {
		this.constructureCards = constructureCards;
		this.availableRoles = availableRoles;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoleCard> getAvailableRoles() {
		return this.availableRoles;
	}

	@Override
	public List<RoleCard> getSelectedRoles() {
		return this.selectedRoles;
	}

	@Override
	public ConstructureCard[] getTop2Constructures() {
		if (this.constructureCards.isEmpty()) {
			return null;
		}

		return this.constructureCards.size() == 1 ? new ConstructureCard[] { this.constructureCards.get(0) } 
				: new ConstructureCard[] { this.constructureCards.get(0), this.constructureCards.get(1) };
	}

	@Override
	public void pickConstructure(ConstructureCard constructureCard) {
		if ( ! this.constructureCards.contains(constructureCard) ) {
			throw new IllegalOperationException("Couldn't pick ConstructureCard[" + constructureCard
					+ "], because it does not belong to constructureCards left in this game.");
		}
		
		this.constructureCards.remove(constructureCard);
	}

	@Override
	public List<Player> getPlayers() {
		return this.players;
	}

}
