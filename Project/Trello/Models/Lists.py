from Trello.Models.Library import IdGenerator


class Lists(object):

    def __init__(self, name="", boardId=""):
        self.id = IdGenerator.generateUniqueId()
        self.name = name
        self.boardId = boardId
        self.cards = dict()

    def setName(self, name):
        self.name = name

    def addCard(self, cardId):
        self.cards[cardId] = True

    def removeCard(self, cardId):
        if cardId not in self.cards:
            print str(cardId) + " not present in List: " + str(self.id)
            return
        del self.cards[cardId]
