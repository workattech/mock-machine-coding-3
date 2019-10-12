from Trello.Models.Cards import Cards


class CardService(object):
    def __init__(self):
        self.cards = dict()
        self.listService = None
        self.boardService = None

    def setServices(self, boardService, listService):
        self.listService = listService
        self.boardService = boardService

    def createCard(self, cardName, listId):
        card = Cards(name=cardName, listId=listId)
        self.cards[card.id] = card
        self.listService.addCardToList(listId, card.id)

    def updateCardName(self, cardId, name):
        card = self.cards[cardId]
        card.setName(name)

    def updateDescription(self, cardId, description):
        card = self.cards[cardId]
        card.setDescription = description

    def assignUserToCard(self, userId, cardId):
        card = self.cards[cardId]
        card.assignUser(userId)

    def unAssignUserFromCard(self, cardId):
        card = self.cards[cardId]
        card.removeUser()

    def moveCardToAnotherList(self, cardId, newListId):
        card = self.cards[cardId]
        if card.listId==newListId:
            print "Same list id"
            return
        self.listService.removeCardFromList(card.listId,  cardId)
        self.listService.addCardToList(newListId, cardId)

    def deleteCard(self, cardId):
        card = self.card[cardId]
        self.listService.removeCardFromList(card.listId, cardId)
        del self.cards[cardId]

    def showCardDetail(self, cardId):
        card = self.cards[cardId]
        cardInfo = ""
        cardInfo += "Id: ", cardId
        cardInfo += " Name: ", card.getName()
        if card.getDescription():
            cardInfo += " Description: ", card.getDescription()
        if card.getUserName():
            cardInfo += " UserName: " + card.getUserName()
        return cardInfo
