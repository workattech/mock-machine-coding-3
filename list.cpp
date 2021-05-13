#include <bits/stdc++.h>
#include "list.h"
#include "board.h"
#include "card.h"

using namespace std;

List::List(string name, string id, Board* parentBoard){
    this->name = name;
    this->id = id;
    this->parentBoard = parentBoard;
    parentBoard->addList(this);
    cout << "List created with name:" << name << " id:" << id << " parentBoard:" << parentBoard->getName() << endl;
}

void List::printList(){
    cout << "LIST name:" << name << " id:" << id << endl;
    cout << "*** CARDS ***" << endl;
    for(set<Card*>::iterator it=cards.begin(); it!=cards.end(); it++)
        (*it)->printCard();
}

void List::addCard(Card* card){
    cards.insert(card);
}

void List::removeCard(Card* card){
    if (cards.find(card)==cards.end())
        cout << "Card " << card->getName() << " isn't a part of List " << name << endl;
    else
        cards.erase(card);
}

void List::deleteFromParentBoard(){
    parentBoard->removeList(this);
}

set<Card*> List::getCards(){
    return cards;
}

string List::getId(){
    return id;
}

string List::getName(){
    return name;
}