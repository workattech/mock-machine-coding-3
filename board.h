#ifndef BOARD_H
#define BOARD_H
#include <bits/stdc++.h>

using namespace std;

class List;
class User;

class Board {
    string id, name, privacy;
    set<User*> members;
    set<List*> lists;
    public:
        Board(string name, string id);
        void printBoard();
        void setName(string name);
        void setPrivacy(string privacy);
        void addMember(User* member);
        void removeMember(User* member);
        void addList(List* list);
        void removeList(List* list);
        set<List*> getLists();
        string getName();
};
#endif