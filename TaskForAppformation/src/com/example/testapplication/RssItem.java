package com.example.testapplication;


public class RssItem {

	private String title;
	private String link;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String toString() {
		return title;
	}

	public String toString2() {
		return content.substring(0, 50);
	}

}
