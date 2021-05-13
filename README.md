# mock-machine-coding-3
Welcome to the 3rd Mock Machine Coding Round by [workat.tech](http://workat.tech).

Please visit [this link](https://workat.tech/machine-coding/practice/trello-problem-t0nwwqt61buz) to participate.

NOTE: 
1. Currently the unique id isn't based on hash, but a counter that gets appended to type of element being creaated.
2. The output is just printing stuff line after line, instead of in a dict. I'll try to change that later.
3. I've added some of my own methods, like SHOW USER, CREATE USER, etc. 
4. Sample input is present in sample_input.txt 

TO RUN:
g++ user.cpp card.cpp list.cpp board.cpp appManager.cpp driver.cpp -o trello
./trello
