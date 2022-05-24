from Trello.Services.BoardService import BoardService

from Trello.Services.ListService import ListService

from Trello.Services.CardService import CardService


class TrelloManager(object):
    def __init__(self):
        self.boardService = BoardService()
        self.listService = ListService()
        self.cardService = CardService()

        # Initialize each of these objects in other service class.
        self.boardService.setServices(self.listService, self.cardService)
        self.listService.setServices(self.boardService, self.cardService)
        self.cardService.setServices(self.boardService, self.listService)
