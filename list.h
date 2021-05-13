#ifndef LIST_H
#define LIST_H

#include <bits/stdc++.h>

using namespace std;

class Board;
class Card;

class List {
    string id, name;
    Board* parentBoard;
    set<Card*> cards;
    public:
        List(string name, string id, Board* parentBoard);
        void printList();
        void addCard(Card* card);
        void removeCard(Card* card);
        void deleteFromParentBoard();
        set<Card*> getCards();
        string getId();
        string getName();
};

#endif