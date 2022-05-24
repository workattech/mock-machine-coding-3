from Library import IdGenerator
from Library import Access


class Board(object):

    def __init__(self, name="", url=""):
        self.id = IdGenerator.generateUniqueId()
        self.name = name
        self.privacy = Access.PUBLIC
        self.url = url
        self.members = set()
        self.lists = set()

    def setBoardName(self, name):
        self.name = name

    def setAccessSpecifier(self, access):
        self.privacy = access

    def getBoardName(self):
        return self.name

    def addMemberToBoard(self, userId):
        self.members.add(userId)

    def removeMemberFromBoard(self, userId):
        if userId not in self.members:
            print str(userId) + "not present in Board: " + str(self.id)
            return
        self.members.remove(userId)

    def addListToBoard(self, listId):
        self.lists.add(listId)

    def removeListFromBoard(self, listId):
        if listId not in self.lists:
            print str(listId) + " not present in Board: " + str(self.id)
            return
        self.lists.remove(listId)
