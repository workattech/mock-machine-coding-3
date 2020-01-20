from utils.uid import get_unique_id

class List(object):

	def __init__(self, name):

		self.id = get_unique_id
		self.name = name
		self.cards = []
