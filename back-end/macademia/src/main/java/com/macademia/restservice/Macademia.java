package com.macademia.restservice;

public class Macademia {

	private final long id;
	private final String content;

	public Macademia(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}