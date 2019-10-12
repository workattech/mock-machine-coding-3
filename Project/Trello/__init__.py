from Trello.TrelloManager import TrelloManager


class TrelloApplication(object):
    def __init__(self):
        try:
            self.trelloManager = TrelloManager()
        except Exception as e:
            print "Exception raised: ", e.message()

    @classmethod
    def run(cls):
        while True:
            try:
                userInput = raw_input()
                pass
            except Exception as e:
                print "Exception raised: ", e.message()

def main():
    TrelloApplication.run()


if __name__ == '__main__':
    main()