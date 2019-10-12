from Trello.Models.Library import IdGenerator


class User(object):
    def __init__(self, name="", email=""):
        self.id = IdGenerator.generateUniqueId()
        self.name = name
        self.email = email

    def setName(self, name):
        self.name = name

    def getName(self):
        return self.name

    def setEmail(self, email):
        self.email = email
