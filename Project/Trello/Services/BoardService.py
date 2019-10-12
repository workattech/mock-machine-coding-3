from Trello.Models.Board import Board


class BoardService(object):

    def __init__(self):
        self.boards = dict()
        self.listService = None
        self.cardService = None

    def setServices(self, listService, cardService):
        self.listService = listService
        self.cardService = cardService

    def validatePresent(self, boardId):
        if boardId not in self.boards:
            print "Board Id not present"
            return False
        return True

    def createBoard(self, name):
        board = Board(name)
        self.boards[board.id] = board

    def updateName(self, boardId, name):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.setBoardName(name)

    def updateAccess(self, boardId, access):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.setAccessSpecifier(access)

    def addMemberInBoard(self, boardId, userId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.addMemberInBoard(userId)

    def removeMemberInBoard(self, boardId, userId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.removeMemberFromBoard(userId)

    def addListInBoard(self, boardId, listId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.addListInBoard(listId)

    def removeListFromBoard(self, boardId, listId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        board.removeListFromBoard(listId)

    def deleteBoard(self, boardId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        for memberId in  board.members:
            self.removeMemberInBoard(boardId, memberId)
        for listId in board.lists:
            # self.removeListFromBoard(boardId, listId)
            self.listService.deleteList(listId)
        del self.boards[boardId]

    def showBoardDetailItem(self, boardId):
        if not self.validatePresent(boardId):
            return
        board = self.boards[boardId]
        boardItemInfo = ""
        boardItemInfo += "ID: ", board.id
        boardItemInfo += ", Name: ", board.name
        boardItemInfo += ", privacy: ", board.privacy

        listInfo = ""
        isListPresent = False
        for listId in board.lists:
            isListPresent = True
            if len(listInfo)  > 0:
                listInfo += ", "
            listInfo += "{ ", self.listService.showListDetail(listId), " }"
        if isListPresent:
            boardItemInfo += "Lists: ", listInfo
        # TODO List
        isMembersPresent = False
        membersInfo = ""
        for members in board.members:
            isMembersPresent = True
            membersInfo += "{ Name: ", str(members), "}"
        if isMembersPresent:
            boardItemInfo += "{ members: " + membersInfo , "}"
        return boardItemInfo

    def showBoardDetail(self):
        boardInfo = ""
        for boardId in self.boards:
            boardInfo += "{ ",self.showBoardDetailItem(boardId), "}\n"
        return boardInfo

