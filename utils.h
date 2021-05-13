#include <bits/stdc++.h>

using namespace std;

vector<string> tokenize(string input, char delimiter){
    vector<string> ans;
    int i=0;
    string current_word = "";
    while(i<input.length()){
        if(input[i]==delimiter){
            if(current_word.length() > 0)
                ans.push_back(current_word);
            current_word="";
        } else {
            current_word += input[i];
        }
        i++;
    }
    if(current_word.length()>0) 
        ans.push_back(current_word);
    return ans;
}