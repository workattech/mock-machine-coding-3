from Trello.Models.Library import IdGenerator


class Cards(object):
    def __init__(self, name="", listId=None):
        self.id = IdGenerator.generateUniqueId()
        self.name = name
        self.description = None
        self.userAssigned = None
        self.listId = listId

    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name

    def setDescription(self, description):
        self.description = description

    def getDescription(self):
        if self.description is not None:
            return self.description
        return None

    def assignUser(self, userId):
        self.userAssigned = userId

    def removeUser(self):
        self.userAssigned = None

    def getUserName(self):
        if self.userAssigned is not None:
            return self.userAssigned
        return None