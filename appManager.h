#ifndef APPMANAGER_H
#define APPMANAGER_H
#include <bits/stdc++.h>

using namespace std;

class Board;
class List;
class Card;
class User;

class AppManager {
    map<string, Board*> boards;
    map<string, List*> lists;
    map<string, Card*> cards;
    map<string, User*> users;
    int board, list, card, user;
    public:
        AppManager();
        void show();
        void showBoard(string id);
        void showList(string id);
        void showCard(string id);
        void showUserCards(string id);

        void createBoard(string name);
        void removeBoard(string id);
        void addMemberToBoard(string boardId, string memberId);
        void removeMemberFromBoard(string boardId, string memberId);
        void updateBoardName(string boardId, string newName);
        void updateBoardPrivacy(string boardId, string newPrivacy);

        void createList(string boardId, string listName);
        void removeList(string id);

        void createCard(string listId, string cardName);
        void removeCard(string id);
        void assignCard(string cardId, string memberId);
        void updateCardName(string cardId, string newName);
        void updateDescription(string cardId, string description);

        void createMember(string name, string email);
};

#endif