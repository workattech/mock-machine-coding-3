from entities import user, board, list, card
import pdb

class Manager(object):
	def __init__(self):

		# initialize stuff here
		self.boards = []
		self.users = []
		self.lists = []
		self.cards = []

	def process_main_input(self, main_input):

		tokens = main_input.split(" ")

		if tokens[0] == "SHOW":
			self.show(tokens[1:])

		if tokens[0] == "BOARD":
			self.process_board_input(tokens[1:])

		if tokens[0] == "LIST":
			self.process_list_input(tokens[1:])

		if tokens[0] == "CARD":
			self.process_card_input(tokens[1:])

	def show(self, input_data):

		if len(input_data) == 0:
			res = []
			for board in self.boards:
				res.append(board.json())

			print(res)

		else:
			input_type_to_show = input_data[0]
			input_type_id = input_data[1]

			if input_type_to_show == "BOARD":
				self.show_board(input_type_id)

			if input_type_to_show == "CARD":
				self.show_card(input_type_id)

			if input_type_to_show == "LIST":
				self.show_list(input_type_id)

	def show_board(self, id):
		# TODO
		pass

	def show_card(self, id):
		# TODO
		pass

	def show_list(self, id):
		# TODO
		pass

	def process_board_input(self, input_data):
		id_or_command = input_data[0]

		if id_or_command == "CREATE":
			self.create_board(input_data[1:])
		else:
			self.modify_board(input_data)

	def create_board(self, properties):
		board_name = properties[0]
		new_board = board.Board(board_name)
		self.boards.append(new_board)
		print("Created Board : " + new_board.id)


	def modify_board(self, properties):

		if len(properties) < 3:
			print("Incorrect params for Board.")
			return

		id, key, val = properties

		board = self.get_board_by_id(id)

		if board is None:
			print("Board with id : " + id + " does not exist.")
			return

		if key.upper() == "NAME":
			new_name = val
			board.name = new_name
			print("Name updated")

		elif key.upper() == "PRIVACY":
			new_privacy = val
			board.privacy = new_privacy
			print("Privacy updated")

		else:
			print("Incorrect param")
			return

		print(board.json())
		return

	def get_board_by_id(self, id):
		for board in self.boards:
			if board.id == id:
				return board
		return None

	def process_list_input(self, input_data):
		id_or_command = input_data[0]

		if id_or_command == "CREATE":
			self.create_list(input_data[1:])
		else:
			self.modify_list(input_data[1:])

	def create_list(self, properties):
		# TODO
		pass

	def modify_list(self, properties):
		# TODO
		pass

	def process_card_input(self, input_data):
		id_or_command = input_data[0]

		if id_or_command == "CREATE":
			self.create_card(input_data[1:])
		else:
			self.modify_card(input_data[1:])

	def create_card(self, properties):
		# TODO
		pass

	def modify_card(self, properties):
		# TODO
		pass


if __name__ == "__main__":
	m = Manager()
	main_input = None

	# Initialize with some Data
	m.process_main_input("SHOW")
	m.process_main_input("BOARD CREATE board1")

	while True:

		main_input = str(input("Enter Input : "))
		if main_input == "QUIT":
			break

		m.process_main_input(main_input)

	print("Exiting.")




