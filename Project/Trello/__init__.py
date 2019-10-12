from Trello.TrelloManager import TrelloManager


class TrelloApplication(object):

    @classmethod
    def run(cls):
        treloManager = TrelloManager()
        while True:
            try:
                userInput = raw_input()
                wordsSplit = userInput.split()
                if wordsSplit[0] == "BOARD":
                    if wordsSplit[1] == "CREATE":
                        treloManager.boardService.createBoard(wordsSplit[2])
                    elif wordsSplit[1] == "DELETE":
                        treloManager.boardService.deleteBoard(wordsSplit[2])
                elif wordsSplit[0] == "SHOW":
                    output = None
                    if len(wordsSplit) == 1:
                        output = treloManager.boardService.showBoardDetail()
                    elif wordsSplit[1] == "BOARD":
                        output = treloManager.boardService.showBoardDetailItem(wordsSplit[2])
                    elif wordsSplit[1] == "LIST":
                        output = treloManager.listService.showListDetail(wordsSplit[2])
                    elif wordsSplit[1] == "CARD":
                        output = treloManager.cardService.showCardDetail(wordsSplit[[2]])
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
                        treloManager.listService.createList(boardId, listName)

                    elif wordsSplit[1] == "DELETE":
                        treloManager.listService.deleteList(wordsSplit[2])
                elif wordsSplit[0] == "CARD":
                    if wordsSplit[1] == "CREATE":
                        listId = wordsSplit[2]
                        treloManager.cardService.createCard(wordsSplit[3], listId)
                    elif wordsSplit[1] == "DELETE":
                        treloManager.cardService.deleteCard(wordsSplit[2])
            except Exception as e:
                print "Exception raised: ", e.message

def main():
    TrelloApplication.run()


if __name__ == '__main__':
    main()