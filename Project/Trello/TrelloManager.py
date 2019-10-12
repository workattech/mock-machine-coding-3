from Trello.Services.BoardService import BoardService

from Trello.Services.ListService import ListService

from Trello.Services.CardService import CardService


class TrelloManager(object):
    def __init__(self):
        boardService = BoardService()
        listService = ListService()
        cardService = CardService()

        # Initialize each of these objects in other service class.
        boardService.setServices(listService, cardService)
        listService.setServices(boardService, cardService)
        cardService.setServices(boardService, listService)

