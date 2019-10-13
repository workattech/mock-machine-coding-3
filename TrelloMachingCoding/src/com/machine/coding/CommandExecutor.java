package com.machine.coding;

import com.machine.coding.common.ServiceFactory;
import com.machine.coding.model.Board;
import com.machine.coding.model.Card;
import com.machine.coding.model.CardList;
import com.machine.coding.service.BoardService;
import com.machine.coding.service.CardListService;
import com.machine.coding.service.CardService;

@SuppressWarnings("unchecked")
public class CommandExecutor {

	// TODO : Change it to interface later.
	private BoardService<String, Board> boardService = (BoardService) ServiceFactory.getService("BOARD_SERVICE");
	private CardListService<String, CardList> cardListService = (CardListService) ServiceFactory
			.getService("CARDLIST_SERVICE");
	private CardService<String, Card> cardService = (CardService) ServiceFactory.getService("CARD_SERVICE");

	public void execute(String inputCommand) {
		String[] commands = inputCommand.split(" ");
		switch (commands[0]) {
		// BOARD.
		case "BOARD":
			switch (commands[1]) {
			case "CREATE":
				boardService.create(new Board(commands[2]));
				break;

			case "DELETE":
				boardService.delete(commands[2], true);
				break;

			default:
				switch (commands[2]) {
				case "ADD_MEMBER":
					boardService.addMember(commands[1], commands[3]);
					break;

				case "REMOVE_MEMBER":
					boardService.removeMember(commands[1], commands[3]);
					break;

				default:

					try {
						boardService.updateField(commands[2], commands[3], commands[1]);
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException e) {
						e.printStackTrace();
					}

					break;
				}
				break;
			}
			break;

		// List
		case "LIST":
			switch (commands[1]) {
			case "CREATE":
				CardList cardList = new CardList(commands[3]);
				cardList.setBoard(boardService.getById(commands[2]));
				String id = cardListService.create(cardList);
				boardService.addCardList(commands[2], id);
				break;

			case "DELETE":
				cardListService.delete(commands[2], true);
				break;

			default:
				switch (commands[2]) {

				default:

					try {
						cardListService.updateField(commands[2], commands[3], commands[1]);
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException e) {
						e.printStackTrace();
					}

					break;
				}
				break;
			}
			break;

		// List
		case "CARD":
			switch (commands[1]) {
			case "CREATE":
				Card card = new Card(commands[3]);
				card.setCardList(cardListService.getById(commands[2]));
				String id = cardService.create(card);
				cardListService.addCard(commands[2], id);
				break;

			case "DELETE":
				cardService.delete(commands[2]);
				break;

			default:
				switch (commands[2]) {

				case "ASSIGN":
					cardService.assign(commands[1], commands[3]);
					break;

				case "UNASSIGN":
					cardService.unAssign(commands[1]);
					break;

				case "MOVE":
					cardListService.moveCard(commands[1], commands[3]);
					break;

				default:

					try {
						cardService.updateField(commands[2], commands[3], commands[1]);
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
							| SecurityException e) {
						e.printStackTrace();
					}

					break;
				}
				break;
			}
			break;

		// show
		case "SHOW":
			String output;
			if (commands.length == 1) {
				output = new Formattor<Board>().format(boardService.getAll());
				System.out.println(output);
			} else {

				switch (commands[1]) {
				case "BOARD":
					// Due to time constraint using toString format.
					output = new Formattor<Board>().format(boardService.getById(commands[2]));
					System.out.println(output);
					break;
				case "LIST":
					// Due to time constraint using toString format.
					output = new Formattor<CardList>().format(cardListService.getById(commands[2]));
					System.out.println(output);
					break;
				case "CARD":
					// Due to time constraint using toString format.
					output = new Formattor<Card>().format(cardService.getById(commands[2]));
					System.out.println(output);
					break;

				default:
					break;
				}
			}
			break;

		default:
			break;
		}
	}
}
