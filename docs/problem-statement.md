# Trello - Machine Coding

## Problem Statement
Create a project management application (like Trello).

A project management application (like Trello) is where you can manage your project by tracking smaller tasks.

![Trello](./trello.png)

- The app contains multiple boards to signify different projects
- Each board contains different lists to signify sub-project
- Each list contain different cards signifying smaller tasks
- Each card can be assigned to a user or may remain unassigned

## Requirements
- User: Each user should have a userId, name, email.
- Board: Each board should have a id, name, privacy (PUBLIC/PRIVATE), url, members, lists
- List: Each list should have a id, name and cards
- Card: Each card should have a id, name, description, assigned user
- We should be able to create/delete boards, add/remove people from the members list and modify attributes. Deleting a board should delete all lists inside it.
- We should be able to create/delete lists and modify attributes. Deleting a list should delete all cards inside it.
- We should be able to create/delete cards, assign/unassign a member to the card and modify attributes
- We should also be able to move cards across lists in the same board
- Ability to show all boards, a single board, a single list and a single card
- Default privacy should be public
- Cards should be unassigned by default
- Ids should be auto-generated for board/list/card
- URLs should get created based on the id

## Input

- You can create a few users in your main method. No need to take it as input.
- There will be different types of input:
    - BOARD CREATE <board_name>
    - BOARD <board_id> <name/privacy> <new_value> 
    - BOARD <board_id> <ADD_MEMBER/REMOVE_MEMBER> <user_id>
    - BOARD DELETE <board_id>
    - LIST CREATE <board_id> <list_name>
    - LIST <list_id> <name> <new_value>
    - LIST DELETE <list_id>
    - CARD CREATE <list_id> <card_name>
    - CARD <card_id> <name/description> <new_value> 
    - CARD <card_id> ASSIGN <user_id>
    - CARD <card_id> UNASSIGN
    - CARD <card_id> MOVE <target_list_id> 
    - CARD DELETE <card_id>
    - SHOW
    - SHOW BOARD <board_id>
    - SHOW LIST <list_id>
    - SHOW CARD <card_id>
- If you want you create these in the main method without taking user input.

## Output

- CREATE operations should print the id after creation
- SHOW should print all the boards with all the lists inside them and all the cards inside all the lists (including all the attributes)
- SHOW <BOARD/LIST> should print that specific entity and everything inside it (including all the attributes)
- SHOW CARD should print all the attributes of the card
- You can use any format to print these. Printing in json is not compulsory.

## Sample Input
```
SHOW
BOARD CREATE work@tech
SHOW BOARD 5da1583ec25d2a7e246b0375
SHOW
BOARD 5da1583ec25d2a7e246b0375 name workat.tech
BOARD 5da1583ec25d2a7e246b0375 privacy PRIVATE
SHOW BOARD 5da1583ec25d2a7e246b0375
BOARD CREATE workat
SHOW
BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user1
BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user2
BOARD 5da1583ec25d2a7e246b0375 ADD_MEMBER user3
BOARD 5da1583ec25d2a7e246b0375 REMOVE_MEMBER user2
SHOW BOARD 5da1583ec25d2a7e246b0375
BOARD DELETE 5da1586caaaad00d9b2d7aa6
SHOW BOARD 5da1586caaaad00d9b2d7aa6
SHOW
LIST CREATE 5da1583ec25d2a7e246b0375 Mock Interviews
SHOW LIST 5da1583547c78c15a1408df2
LIST 5da1583547c78c15a1408df2 name Mock Interviews - Applied
SHOW LIST 5da1583547c78c15a1408df2
LIST CREATE 5da1583ec25d2a7e246b0375 Mock Interviews - Scheduled
SHOW BOARD 5da1583ec25d2a7e246b0375
CARD CREATE 5da1583547c78c15a1408df2 abcd@gmail.com
CARD CREATE 5da1583547c78c15a1408df2 abcda@gmail.com
SHOW LIST 5da1583547c78c15a1408df2
CARD 5da1583547c78c15a14kj78g name abcde@gmail.com
CARD 5da1583547c78c15a14kj78g description At 7PM
SHOW LIST 5da1583547c78c15a1408df2
CARD 5da1583547c78c15a14kjsd8 ASSIGN gaurav@workat.tech
SHOW CARD 5da1583547c78c15a14kjsd8
CARD 5da1583547c78c15a14kjsd8 MOVE 5da1583547c78c15a143hj34
SHOW LIST 5da1583547c78c15a1408df2
SHOW LIST 5da1583547c78c15a143hj34
CARD 5da1583547c78c15a14kjsd8 UNASSIGN
SHOW CARD 5da1583547c78c15a14kjsd8
SHOW
```

## Sample Output
```
No boards
Created board: 5da1583ec25d2a7e246b0375
{"id": "5da1583ec25d2a7e246b0375", "name": "work@tech", "privacy": "PUBLIC"}
[{"id": "5da1583ec25d2a7e246b0375", "name": "work@tech", "privacy": "PUBLIC"}]
{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE"}
Created board: 5da1586caaaad00d9b2d7aa6
[{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE"}, {"id": "5da1586caaaad00d9b2d7aa6", "name": "workat", "privacy": "PUBLIC"}]
{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "members": [{"id": "user1", "name": "Gaurav Chandak", "email": "gaurav@workat.tech"}, {"id": "user3", "name": "Sagar Jain", "email": "sagar@workat.tech"}]}
Board 5da1586caaaad00d9b2d7aa6 does not exist
[{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "members": [{"id": "user1", "name": "Gaurav Chandak", "email": "gaurav@workat.tech"}, {"id": "user3", "name": "Sagar Jain", "email": "sagar@workat.tech"}]}]
Created list: 5da1583547c78c15a1408df2
{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews"}
{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied"}
Created list: 5da1583547c78c15a143hj34
{"id": "5da1583ec25d2a7e246b0375", "name": "workat.tech", "privacy": "PRIVATE", "lists"": [{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied"}, {"id": "5da1583547c78c15a143hj34", "name": "Mock Interviews - Scheduled"}] "members": [{"id": "user1", "name": "Gaurav Chandak", "email": "gaurav@workat.tech"}, {"id": "user3", "name": "Sagar Jain", "email": "sagar@workat.tech"}]}
Created card: 5da1583547c78c15a14kjsd8
Created card: 5da1583547c78c15a14kj78g
{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com"}, {"id": "5da1583547c78c15a14kj78g", "name": "abcda@gmail.com"}]}
{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com"}, {"id": "5da1583547c78c15a14kj78g", "name": "abcde@gmail.com", "description": "At 7PM"}]}
{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com", "assignedTo": "gaurav@workat.tech"}
{"id": "5da1583547c78c15a1408df2", "name": "Mock Interviews - Applied", "cards": [{"id": "5da1583547c78c15a14kj78g", "name": "abcde@gmail.com", "description": "At 7PM"}]}
{"id": "5da1583547c78c15a143hj34", "name": "Mock Interviews - Scheduled", "cards": [{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com", "assignedTo": "gaurav@workat.tech"}]}
{"id": "5da1583547c78c15a14kjsd8", "name": "abcd@gmail.com"}

```

## Expectations
- Make sure that you have a working and demonstrable code
- Make sure that the code is functionally correct
- Code should be modular and readable
- Separation of concern should be addressed
- Please do not write everything in a single file
- Code should easily accommodate new requirements and minimal changes
- There should be a main method from where the code could be easily testable
- [Optional] Write unit tests, if possible
- No need to create a GUI

## Optional Requirements
**Please do these only if you’ve time left**. You can write your code such that these could be accommodated without changing your code much.
- Ability to clone a list with all the cards in it. All of these should have a different id.
- Ability to delete all the cards in a list without deleting the list
- Option to add tags to a card and ability to get cards based on assigned tags 
- Ability to find all the cards assigned to a particular user
  

## Setup process
Please go through the setup process <a href="https://workattech.github.io/mock-machine-coding-3/#setup" target="_blank">here</a>.

## Submission
- You've 3 hours to submit the solution. Please submit by 7 PM if you start at 4 PM.
- Please go through the submission process <a href="https://workattech.github.io/mock-machine-coding-3/#submission" target="_blank">here</a>.
