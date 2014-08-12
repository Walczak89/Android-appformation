package com.example.testapplication;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssParse {

	private String rssUrl;

	public RssParse(String rssUrl) {
		this.rssUrl = rssUrl;
	}

	public List<RssItem> getItems() throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		RssParseHandler handler = new RssParseHandler();

		saxParser.parse(rssUrl, handler);
		return handler.getItems();
	}
}
