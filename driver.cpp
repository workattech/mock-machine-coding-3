#include <bits/stdc++.h>
#include "appManager.h"
#include "board.h"
#include "list.h"
#include "card.h"
#include "user.h"
#include "utils.h"

using namespace std;

int main(){
    AppManager* appManager = new AppManager();
    // appManager->createMember("Emilia", "ec@gmail.com");
    // appManager->createMenber("Keilah", "kk@gmail.com");
    // appManager->createMember("Jennifer", "ja@gmail.com");
    // appManager->createMember("Mikaela", "m@gmail.com");
    string input;
    while(getline(cin, input)){
        if(input=="")
            break;
        vector<string> args = tokenize(input, ' ');
        if(args[0]=="SHOW"){
            if(args.size()==1)
                appManager->show();
            else if(args[1]=="BOARD")
                appManager->showBoard(args[2]); //id
            else if(args[1]=="LIST")
                appManager->showList(args[2]); //id
            else if(args[1]=="CARD")
                appManager->showCard(args[2]); //id
            else if(args[1]=="USER")
                appManager->showUserCards(args[2]);  //id
        } else if(args[0]=="BOARD"){
            if(args[1]=="CREATE")
                appManager->createBoard(args[2]); //name
            else if(args[1]=="REMOVE")
                appManager->removeBoard(args[2]); //id
            else if(args[2]=="ADD_MEMBER")
                appManager->addMemberToBoard(args[1], args[3]); //boardId, memberId
            else if(args[2]=="REMOVE_MEMBER")
                appManager->removeMemberFromBoard(args[1], args[3]); //boardId, memberId
            else if(args[2]=="NAME")
                appManager->updateBoardName(args[1], args[3]); //boardId, newName
            else if(args[2]=="PRIVACY")
                appManager->updateBoardPrivacy(args[1], args[3]); //boardId, privacy
        } else if(args[0]=="LIST"){
            if(args[1]=="CREATE")
                appManager->createList(args[2], args[3]); //boardId, listName
            else if(args[1]=="REMOVE")
                appManager->removeList(args[2]); //listId
        } else if(args[0]=="CARD"){
            if(args[1]=="CREATE")
                appManager->createCard(args[2], args[3]); //listId, cardName
            else if(args[1]=="REMOVE")
                appManager->removeCard(args[2]); //cardId
            else if(args[2]=="ASSIGN")
                appManager->assignCard(args[1], args[3]); //cardId, memberId
            else if(args[2]=="NAME")
                appManager->updateCardName(args[1], args[3]); //cardId, newName
            else if(args[2]=="DESCRIPTION"){
                string description = "";
                for(int i=3; i<args.size(); i++)
                    description += args[i] + " ";
                appManager->updateDescription(args[1], description); //cardId, description
            }
        } else if(args[0]=="USER"){
            //args[1] is always CREATE
            appManager->createMember(args[2], args[3]); //name, email
        }
    }
}