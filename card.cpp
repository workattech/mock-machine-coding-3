#include <bits/stdc++.h>
#include "card.h"
#include "list.h"
#include "user.h"

using namespace std;

Card::Card(string name, string id, List* parentList){
    this->name = name;
    this->id = id;
    assignedTo = nullptr;
    this->parentList = parentList;
    parentList->addCard(this);
    cout << "Card created with name:" << name << " id:" << id << " parentList:" << parentList->getName() << endl;
}

void Card::printCard(){
    cout << "CARD name:" << name << " id:" << id << " assignedTo:" << ((assignedTo==nullptr)?"None":assignedTo->getName()) << " description:" << description << endl;
}

void Card::assignTo(User* user){
    //apply check whether user is a part of this board or not.
    assignedTo = user;
    user->addCard(this);
}

void Card::deleteThisCard(){
    parentList->removeCard(this);
    if(assignedTo){
        assignedTo->unassignCard(this);
    }
}

string Card::getId(){
    return id;
}

string Card::getName(){
    return name;
}

void Card::setName(string newName){
    name = newName;
}

void Card::setDescription(string newDescription){
    description = newDescription;
}