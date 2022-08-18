package services;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ApplicationService tool= new ApplicationService();
		
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			String[] commands = line.split(" ");
			int length = commands.length;
			if(commands[0].toUpperCase().equals("SHOW")) {
				if(length==3)
				{
					if(commands[1].toUpperCase().equals("BOARD"))
						tool.showBoard(UUID.fromString(commands[2]));
					else if(commands[1].toUpperCase().equals("LIST"))
						tool.showList(UUID.fromString(commands[2]));
					else
						tool.showCard(UUID.fromString(commands[2]));
				}
				else
					tool.showAll();
			}
			else if(commands[0].toUpperCase().equals("BOARD")) {
				if(length>1)
				{
					if(commands[1].toUpperCase().equals("CREATE")) {
						tool.createBoard(commands[2]);
					}
					else if(commands[1].toUpperCase().equals("DELETE")) {
						tool.deleteBoard(UUID.fromString(commands[2]));
					}
					else {
						if(commands[2].toUpperCase().equals("NAME"))
							tool.setBoardName(UUID.fromString(commands[1]), commands[3]);
						else if(commands[2].toUpperCase().equals("PRIVACY"))
							tool.changeBoardPrivacy(UUID.fromString(commands[1]), commands[3]);
						else if(commands[2].toUpperCase().equals("ADD_MEMBER"))
							tool.addMemberToBoard(UUID.fromString(commands[1]), commands[3]);
					}
				}
			}
			else if(commands[0].toUpperCase().equals("LIST")) {
				if(length>1) {
					StringBuilder sb=new StringBuilder("");
					for(int index=3;index<length;index++) {
						sb.append(commands[index]);
						if(index < length-1)
							sb.append(' ');
					}
					if(commands[1].toUpperCase().equals("CREATE"))
						tool.createList(UUID.fromString(commands[2]), new String(sb));
					else if(commands[1].toUpperCase().equals("DELETE"))
						tool.deleteList(UUID.fromString(commands[2]));
					else if(commands[2].toUpperCase().equals("NAME"))
						tool.setListName(UUID.fromString(commands[1]), new String(sb));
				}
			}
			else if(commands[0].toUpperCase().equals("CARD")) {
				if(length>1) {
					StringBuilder sb=new StringBuilder("");
					for(int index=3;index<length;index++) {
						sb.append(commands[index]);
						if(index < length-1)
							sb.append(' ');
					}
					if(commands[1].toUpperCase().equals("CREATE"))
						tool.createCard(UUID.fromString(commands[2]), new String(sb));
					else if(commands[1].toUpperCase().equals("DELETE"))
						tool.deleteCard(UUID.fromString(commands[2]));
					else {
						if(length>2) {
							if(commands[2].toUpperCase().equals("NAME"))
								tool.setCardName(UUID.fromString(commands[1]), new String(sb));
							else if(commands[2].toUpperCase().equals("DESCRIPTION"))
								tool.setCardDescription(UUID.fromString(commands[1]), new String(sb));
							else if(commands[2].toUpperCase().equals("UNASSIGN"))
								tool.unassignCard(UUID.fromString(commands[1]));
							else if(commands[2].toUpperCase().equals("ASSIGN"))
								tool.assignCardToMember(UUID.fromString(commands[1]), commands[3]);
							else if(commands[2].toUpperCase().equals("MOVE"))
								tool.moveCardToDifferentList(UUID.fromString(commands[1]), UUID.fromString(commands[3]));
						}
					}
				}
			}
		}
		input.close();
	}

}
