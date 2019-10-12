from Library import IdGenerator
from Library import Access


class Board(object):

    def __init__(self, name="", url=""):
        self.id = IdGenerator.generateUniqueId()
        self.name = name
        self.privacy = Access.PUBLIC
        self.url = url
        self.members = dict()
        self.lists = dict()

    def setBoardName(self, name):
        self.name = name

    def setAccessSpecifier(self, access):
        self.privacy = access

    def getBoardName(self):
        return self.name

    def addMemberInBoard(self, userId):
        self.members[userId] = True

    def removeMemberFromBoard(self, userId):
        if userId not in self.members:
            print str(userId) + "not present in Board: " + str(self.id)
            return
        del self.members[userId]

    def addListInBoard(self, listId):
        self.lists[listId] = True

    def removeListFromBoard(self, listId):
        if listId not in self.lists:
            print str(listId) + " not present in Board: " + str(self.id)
        del self.lists[listId]
