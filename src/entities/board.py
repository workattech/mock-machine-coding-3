from utils.uid import get_unique_id

class Board(object):

	def __init__(self, name):

		self.id = get_unique_id()
		self.name = name
		self.privacy = "PUBLIC"
		self.url = "https://trello.com/" + self.id
		self.members = []
		self.lists = []

	def json(self):
		return self.__dict__

