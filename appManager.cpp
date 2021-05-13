#include <bits/stdc++.h>
#include "appManager.h"
#include "board.h"
#include "list.h"
#include "card.h"
#include "user.h"

using namespace std;

AppManager::AppManager(){
    board = 0;
    card = 0;
    list = 0;
    user = 0;
}

void AppManager::show(){
    if(boards.size()==0){
        cout << "No Board" << endl;
        return;
    }
    for(map<string,Board*>::iterator it=boards.begin(); it!=boards.end(); it++)
        (it->second)->printBoard();
}

void AppManager::showBoard(string boardId){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else 
        boards[boardId]->printBoard();
    
}

void AppManager::showList(string listId){
    if(lists.find(listId)==lists.end())
        cout << "List " << listId << " doesn't exist!" << endl;
    else 
        lists[listId]->printList();
}

void AppManager::showCard(string cardId){
    if(cards.find(cardId)==cards.end())
        cout << "Card " << cardId << " doesn't exist!" << endl;
    else
        cards[cardId]->printCard();
}

void AppManager::showUserCards(string userId){
    if(users.find(userId)==users.end())
        cout << "User " << userId << " doesn't exist!" << endl;
    else
        users[userId]->myCards();
}

void AppManager::createBoard(string name){
    board++;
    string id = "Board" + to_string(board);
    Board* b = new Board(name, id);
    boards[id] = b;
    return;
}
void AppManager::removeBoard(string id){
    if(boards.find(id)==boards.end())
        cout << "Board " << id << " doesn't exist!" << endl;
    else {
        cout << "Deleting Board" << endl;
        Board* b = boards[id];
        set<List*> listSet = b->getLists();
        while(begin(listSet) != end(listSet)){
            set<List*>::iterator it_list = listSet.begin();
            set<Card*> cardSet = (*it_list)->getCards();
            while(begin(cardSet)!=end(cardSet)){
                set<Card*>::iterator it_card = cardSet.begin();
                cards.erase((*it_card)->getId());
                delete *it_card;
            }
            lists.erase((*it_list)->getId());
            delete *it_list;
        }
        boards.erase(id);
        delete(b);
    }
    return;
}

void AppManager::addMemberToBoard(string boardId, string memberId){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else if(users.find(memberId)==users.end())
        cout << "User " << memberId << " doesn't exist!" << endl; 
    else
        (boards[boardId])->addMember(users[memberId]);
    return;
}

void AppManager::removeMemberFromBoard(string boardId, string memberId){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else if(users.find(memberId)==users.end())
        cout << "User " << memberId << " doesn't exist!" << endl; 
    else
        (boards[boardId])->removeMember(users[memberId]);
    return;
}

void AppManager::updateBoardName(string boardId, string newName){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else
        (boards[boardId])->setName(newName);
}
void AppManager::updateBoardPrivacy(string boardId, string newPrivacy){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else
        (boards[boardId])->setPrivacy(newPrivacy);
}

void AppManager::createList(string boardId, string listName){
    if(boards.find(boardId)==boards.end())
        cout << "Board " << boardId << " doesn't exist!" << endl;
    else {
        list++;
        string id = "List" + to_string(list);
        List* list = new List(listName, id, boards[boardId]);
        lists[id] = list;
    }
}

void AppManager::removeList(string listId){
    if(lists.find(listId) == lists.end())
        cout << "List " << listId << " doesn't exist!" << endl;
    else {
        cout << "Deleting list" << endl;
        List* l = lists[listId];
        set<Card*> cardSet = l->getCards();
        while(begin(cardSet)!=end(cardSet)){
            set<Card*>::iterator it_card = cardSet.begin();
            cards.erase((*it_card)->getId());
            delete *it_card;
        }
        l->deleteFromParentBoard();
        lists.erase(listId);
        delete(l);
    }
}

void AppManager::createCard(string listId, string cardName){
    if(lists.find(listId) == lists.end())
        cout << "List " << listId << " doesn't exist!" << endl;
    else {
        card++;
        string id = "Card" + to_string(card);
        Card* c = new Card(cardName, id, lists[listId]);
        cards[id] = c;
    }
}

void AppManager::removeCard(string cardId){
    if(cards.find(cardId)==cards.end())  
        cout << "Card " << cardId << " doesn't exist!" << endl;
    else {
        Card* c = cards[cardId];
        c->deleteThisCard();
        cards.erase(cardId);
        delete(c);
    } 
}

void AppManager::assignCard(string cardId, string memberId){
    if(cards.find(cardId)==cards.end())
        cout << "Card " << cardId << " doesn't exist!" << endl;
    else if(users.find(memberId)==users.end())
        cout << "User " << memberId << " doesn't exist!" << endl;
    else 
        cards[cardId]->assignTo(users[memberId]);
}

void AppManager::updateCardName(string cardId, string newName){
    if(cards.find(cardId)==cards.end())
        cout << "Card " << cardId << " doesn't exist!" << endl;
    else
        cards[cardId]->setName(newName);
}

void AppManager::updateDescription(string cardId, string description){
    if(cards.find(cardId)==cards.end())
        cout << "Card " << cardId << " doesn't exist!" << endl;
    else
        cards[cardId]->setDescription(description);
}

void AppManager::createMember(string name, string email){
    user++;
    string id = "User" + to_string(user);
    User* user = new User(name, email, id);
    users[id] = user;
}