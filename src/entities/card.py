from utils.uid import get_unique_id

class Card(object):

	def __init__(self, name, description, assigned_user):

		self.id = get_unique_id
		self.name = name
		self.description = description
		self.assigned_user = assigned_user


