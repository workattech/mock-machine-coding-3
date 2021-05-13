#ifndef USER_H
#define USER_H

#include <bits/stdc++.h>

using namespace std;

class Card;

class User {
    string id, name, email;
    set<Card*> cardsAssigned;
    public:
        User(string name, string email, string id);
        void myCards();
        void printUser();
        void addCard(Card* card);
        void unassignCard(Card* card);
        string getName();
        string getId();
};

#endif