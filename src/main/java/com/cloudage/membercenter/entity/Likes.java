package com.cloudage.membercenter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class Likes{
	
	@Embeddable
	public static class Key implements Serializable{
		User user;
		Article article;
		
		@ManyToOne(optional=false)
		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
		
		@ManyToOne(optional=false)
		public Article getArticle() {
			return article;
		}
		public void setArticle(Article article) {
			this.article = article;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Key){
				Key other = (Key)obj;
				return article.getId() == other.article.getId() && user.getId() == other.user.getId();
			}else{
				return false;
			}
		}
		
		@Override
		public int hashCode() {
			return article.getId();
		}
	}
	
	Key id;
	Date createDate;

	@Column(updatable=false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@EmbeddedId
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	@PrePersist
	void onPrePersist(){
		createDate = new Date();
	}

}
