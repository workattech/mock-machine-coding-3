package com.machine.coding.model;

import java.util.ArrayList;
import java.util.List;

public class Board extends Base{

	private String name;
	private String privacy =Privacy.PUBLIC.toString();
	private String url;
	private List<User> members;
	private List<CardList> cardLists;

	public Board() {
		this.members = new ArrayList<>();
		this.cardLists = new ArrayList<>();
	}
	public Board(String name) {
		this();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<CardList> getCardLists() {
		return cardLists;
	}

	public void setCardLists(List<CardList> cardLists) {
		this.cardLists = cardLists;
	}
	
	
	public void addMember(User member) {
		getMembers().add(member);
	}

	public void removeMember(User member) {
		getMembers().remove(member);
	}

	public void addCardList(CardList cardList) {
		getCardLists().add(cardList);
	}
	public void removeCardList(CardList cardList) {
		getCardLists().remove(cardList);
	}
	
	@Override
	public String toString() {
		return String.format("Board [id=%s, name=%s, privacy=%s, url=%s, members=%s, cardLists=%s]", getId(), name, privacy,
				url, members, cardLists);
	}

	
}
