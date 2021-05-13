#include <bits/stdc++.h>
#include "board.h"
#include "list.h"
#include "user.h"

using namespace std;

Board::Board(string name, string id){
    this->name = name;
    this->id = id;
    this->privacy = "PUBLIC";
    cout << "Board created with name:" << name << " id:" << id << " and privacy:" << privacy << endl;
}

void Board::printBoard(){
    cout << "BOARD name:" << name << " id:" << id << " privacy:" << privacy << endl;
    cout << "*** Members ***" << endl;
    for(set<User*>::iterator it=members.begin(); it!=members.end(); it++)
        (*it)->printUser();
    for(set<List*>::iterator it=lists.begin(); it!=lists.end(); it++){
        cout << "*** Lists ***" << endl;
        (*it)->printList();
    }
    cout << endl;
}

void Board::setName(string newName){
    name = newName;
}

void Board::setPrivacy(string newPrivacy){
    privacy = newPrivacy;
}

void Board::addMember(User* member){
    members.insert(member);
    cout << "Added member " << member->getName() << " to Board " << name << endl;
}

void Board::removeMember(User* member){
    if (members.find(member)==members.end())
        cout << "User " << member->getName() << " isn't a part of Board " << name << endl;
    else
        members.erase(member);
}

void Board::addList(List* list){
    lists.insert(list);
    cout << "Added list " << list->getName() << " to Board " << name << endl;
}

void Board::removeList(List* list){
    if (lists.find(list)==lists.end())
        cout << "List " << list->getName() << " isn't a part of Board " << name << endl;
    else
        lists.erase(list);
}

set<List*> Board::getLists(){
    return lists;
}

string Board::getName(){
    return name;
}