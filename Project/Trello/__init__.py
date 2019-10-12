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
                        "No Boards"
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
            except Exception as e:
                print "Exception raised: ", e.message

def main():
    TrelloApplication.run()


if __name__ == '__main__':
    main()