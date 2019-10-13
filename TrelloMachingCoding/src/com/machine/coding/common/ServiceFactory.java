package com.machine.coding.common;

import com.machine.coding.model.Board;
import com.machine.coding.model.Card;
import com.machine.coding.model.CardList;
import com.machine.coding.service.BoardService;
import com.machine.coding.service.CardListService;
import com.machine.coding.service.CardService;
import com.machine.coding.service.GenericService;

/**
 * @author Hakim.s
 *
 */
public class ServiceFactory {

	private ServiceFactory() {
	}

	@SuppressWarnings("rawtypes")
	public static GenericService getService(String type) {
		switch (type) {
		case "BOARD_SERVICE":
			return new BoardService<String, Board>();

		case "CARDLIST_SERVICE":
			return new CardListService<String, CardList>();
		case "CARD_SERVICE":

			return new CardService<String, Card>();
		default:
			break;
		}
		return null;
	}
}
