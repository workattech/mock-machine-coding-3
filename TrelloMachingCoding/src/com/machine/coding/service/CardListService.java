package com.machine.coding.service;

import java.io.Serializable;

import com.machine.coding.common.ServiceFactory;
import com.machine.coding.model.Base;
import com.machine.coding.model.Card;
import com.machine.coding.model.CardList;
import com.machine.coding.repository.CardListRepository;

public class CardListService<K extends Serializable, V extends Base> extends GenericService<K, V> {

	private CardService cardService;

	public CardListService() {
		this.repository = CardListRepository.getInstance();
		this.cardService = (CardService) ServiceFactory.getService("CARD_SERVICE");
	}

	public void addCard(K cardListId, String cardId) {
		CardList cardList = (CardList) getById(cardListId);
		Card card = (Card) cardService.getById(cardId);
		cardList.addCard(card);
	}

	@SuppressWarnings("unchecked")
	public void delete(K id, boolean isCascadeDelete) {
		V object = getById(id);
		super.delete(id);
		CardList cardList = (CardList) object;

		cardList.getBoard().removeCardList(cardList);
		
		if (isCascadeDelete) {
			for (Card card : cardList.getCards()) {
				cardService.delete(card);
			}
		}
		
	}


	public void moveCard(K cardId, K cardListId) {
		Card card = (Card) cardService.getById(cardId);
		card.getCardList().removeCard(card);

		CardList newCardList = (CardList) getById(cardListId);
		newCardList.addCard(card);
		card.setCardList(newCardList);
	}
}
