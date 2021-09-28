package com.stackroute.favouriteservice.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Articles")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5443962551589117394L;

	@Id
	private String id;
	private String author;
	private String title;
	private String description;
	private String url;
	private String content;
	private String publishedAt;
	private String userId;
	private Source source;
	private String isAdded;
	private String urlToImage;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrltoImage() {
		return urlToImage;
	}

	public void setUrltoImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	
	  public Source getSource() { return source; }
	  
	  public void setSource(Source source) { this.source =
			  source; }
	 

	
	public String getIsAdded() {
		return isAdded;
	}

	public void setIsAdded(String isAdded) {
		this.isAdded = isAdded;
	}

	@Override
	public String toString() {
		return "ArticleEntity [id=" + id + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", content=" + content + ", publishedAt="
				+ publishedAt + ", userId=" + userId + ", source=" + source + ", isAdded=" + isAdded + "]";
	}

	

	

	

}
