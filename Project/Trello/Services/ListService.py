from Trello.Models.Lists import Lists


class ListService(object):

    def __init__(self):
        self.lists = dict()
        self.boardService = None
        self.cardService = None

    def setServices(self, boardService, cardService):
        self.boardService = boardService
        self.cardService = cardService

    def createList(self, boardId, name):
        listWorks = Lists(name, boardId)
        self.lists[listWorks.id] = listWorks
        self.boardService.addListToBoard(boardId, listWorks.id)
        print "Created List: ", listWorks.id

    def addCardToList(self, listId, cardId):
        listWorks = self.lists[listId]
        listWorks.addCard(cardId)

    def removeCardFromList(self, listId, cardId):
        if listId not in self.lists:
            print "ListId not present"
            return
        listWorks = self.lists[listId]
        listWorks.removeCardFromList(cardId)

    def deleteList(self, listId):
        if listId not in self.lists:
            print "List Id not present"
            return
        listWorks = self.lists[listId]
        for cardId in listWorks.cards:
            self.cardService.deleteCard(cardId)
        del self.lists[listId]
        self.boardService.removeListFromBoard(listWorks.boardId, listId)

    def showListDetail(self, listId):
        if listId not in self.lists:
            return ""
        listWorks = self.lists[listId]
        listInfo = ""
        listInfo += "ListID: " +  str(listId)
        listInfo += " Name: "+ str(listWorks.name)
        isCardsPresent = False
        cardInfo = ""
        for cardId in listWorks.cards:
            isCardsPresent = True
            if len(cardInfo) > 0:
                cardInfo += ","
            cardInfo += " {" +  self.cardService.showCardDetail(cardId) +  "}"
        if isCardsPresent:
            listInfo += ", Cards: " + cardInfo
        return listInfo

