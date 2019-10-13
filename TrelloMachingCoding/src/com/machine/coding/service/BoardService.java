package com.machine.coding.service;

import java.io.Serializable;

import com.machine.coding.common.ServiceFactory;
import com.machine.coding.common.UserBase;
import com.machine.coding.model.Base;
import com.machine.coding.model.Board;
import com.machine.coding.model.CardList;
import com.machine.coding.model.User;
import com.machine.coding.repository.BoardRepository;

public class BoardService<K extends Serializable, V extends Base> extends GenericService<K, V> {

	@SuppressWarnings("rawtypes")
	private CardListService cardListService;

	public BoardService() {
		this.repository = BoardRepository.getInstance();
		this.cardListService = (CardListService) ServiceFactory.getService("CARDLIST_SERVICE");
	}

	@SuppressWarnings("unchecked")
	public void delete(K id, boolean isCascadeDelete) {
		V object = getById(id);
		super.delete(id);
		if (isCascadeDelete) {
			Board board = (Board) object;
			for (CardList cardList : board.getCardLists()) {
				cardListService.delete(cardList);
			}
		}
	}

	public void addMember(K boardId, String memberId) {

		Board board = (Board) getById(boardId);
		User member = UserBase.getUser(memberId);
		board.addMember(member);

	}

	public void removeMember(K boardId, String memberId) {

		Board board = (Board) getById(boardId);
		User member = UserBase.getUser(memberId);
		board.removeMember(member);

	}

	public void addCardList(K boardId, String cardListId) {
		Board board = (Board) getById(boardId);
		CardList cardList = (CardList) cardListService.getById(cardListId);
		board.addCardList(cardList);
	}

}
