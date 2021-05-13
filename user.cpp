#include <bits/stdc++.h>
#include "card.h"
#include "user.h"

using namespace std;

User::User(string name, string email, string id){
    this->name = name;
    this->email = email;
    this->id = id;
    cout << "User created with name:" << name << " id:" << id << " email:" << email << endl;
}

void User::myCards(){
    cout << "User " << name << " has following cards assigned:" << endl;
    for(set<Card*>::iterator it=cardsAssigned.begin(); it!=cardsAssigned.end(); it++)
        (*it)->printCard();
}

void User::printUser(){
    cout << "User name:" << name << " id:" << id << " email:" << email << endl;
}

void User::addCard(Card* card){
    cardsAssigned.insert(card);
}

void User::unassignCard(Card* card){
    cardsAssigned.erase(card);
}

string User::getId(){
    return id;
}

string User::getName(){
    return name;
}