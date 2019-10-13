package com.machine.coding.service;

import java.io.Serializable;

import com.machine.coding.common.ServiceFactory;
import com.machine.coding.common.UserBase;
import com.machine.coding.model.Base;
import com.machine.coding.model.Card;
import com.machine.coding.model.CardList;
import com.machine.coding.repository.CardRepository;

public class CardService<K extends Serializable, V extends Base> extends GenericService<K, V> {

	public CardService() {
		this.repository = CardRepository.getInstance();
	}

	@Override
	public void delete(K id) {
		V object = getById(id);
		super.delete(id);

		Card card = (Card) object;
		card.getCardList().removeCard(card);
	}

	public void assign(K cardId, String userId) {
		Card card = (Card) getById(cardId);
		card.setAssignedUser(UserBase.getUser(userId));

	}

	public void unAssign(K cardId) {
		Card card = (Card) getById(cardId);
		card.setAssignedUser(null);
	}

}
