from Trello.TrelloManager import TrelloManager


class TrelloApplication(object):

    @classmethod
    def run(cls):
        trelloManager = TrelloManager()
        while True:
            try:
                userInput = raw_input()
                wordsSplit = userInput.split()
                if wordsSplit[0] == "BOARD":
                    if wordsSplit[1] == "CREATE":
                        trelloManager.boardService.createBoard(wordsSplit[2])
                    elif wordsSplit[1] == "DELETE":
                        trelloManager.boardService.deleteBoard(wordsSplit[2])
                    else:
                        boardId = wordsSplit[1]
                        if wordsSplit[2] == "name":
                            trelloManager.boardService.updateName(boardId, wordsSplit[3])
                        elif wordsSplit[2] == "privacy":
                            trelloManager.boardService.updateAccess(boardId, wordsSplit[3])
                        elif wordsSplit[2] == "ADD_MEMBER":
                            trelloManager.boardService.addMemberToBoard(boardId, wordsSplit[3])
                        elif wordsSplit[2] == "REMOVE_MEMBER":
                            trelloManager.boardService.removeMemberFromBoard(boardId, wordsSplit[3])
                elif wordsSplit[0] == "SHOW":
                    output = None
                    if len(wordsSplit) == 1:
                        output = trelloManager.boardService.showBoardDetail()
                    elif wordsSplit[1] == "BOARD":
                        output = trelloManager.boardService.showBoardDetailItem(wordsSplit[2])
                    elif wordsSplit[1] == "LIST":
                        output = trelloManager.listService.showListDetail(wordsSplit[2])
                    elif wordsSplit[1] == "CARD":
                        output = trelloManager.cardService.showCardDetail(wordsSplit[[2]])
                    else:
                        print "No such option, try again"
                    if output is None:
                        print "No Boards"
                    else:
                        print output
                elif wordsSplit[0] == "LIST":
                    if wordsSplit[1] == "CREATE":
                        boardId = wordsSplit[2]
                        listName = ' '.join(wordsSplit[3:])
                        trelloManager.listService.createList(boardId, listName)

                    elif wordsSplit[1] == "DELETE":
                        trelloManager.listService.deleteList(wordsSplit[2])
                elif wordsSplit[0] == "CARD":
                    if wordsSplit[1] == "CREATE":
                        listId = wordsSplit[2]
                        trelloManager.cardService.createCard(wordsSplit[3], listId)
                    elif wordsSplit[1] == "DELETE":
                        trelloManager.cardService.deleteCard(wordsSplit[2])
                    else:
                        cardId = wordsSplit[1]
                        if wordsSplit[2] == "name":
                            name = wordsSplit[3]
                            trelloManager.cardService.updateCardName(cardId, name)

                        elif wordsSplit[2] == "description":
                            trelloManager.cardService.updateDescription(cardId, wordsSplit[3])

                        elif wordsSplit[2] == "ASSIGN":
                            trelloManager.cardService.assignUserToCard(wordsSplit[3], cardId)
                        elif wordsSplit[2] =="UNASSIGN":
                            trelloManager.cardService.unAssignUserFromCard(cardId)
            except Exception as e:
                print "Exception raised: ", e.message

def main():
    TrelloApplication.run()


if __name__ == '__main__':
    main()