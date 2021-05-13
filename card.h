#ifndef CARD_H
#define CARD_H

#include <bits/stdc++.h>

using namespace std;

class List;
class User;

class Card {
    string id, name, description;
    User* assignedTo;
    List* parentList;
    public:
        Card(string name, string id, List* parentList);
        void printCard();
        void assignTo(User* user);
        void deleteThisCard();
        string getId();
        string getName();
        void setName(string newName);
        void setDescription(string newDesciption);
};

#endif