package com.ssafy.happyhouse.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Board  implements Serializable {
	private int articleno;
	private String id;
	private String subject;
	private String content;
	private int hit;
	private String regtime;

	public int getArticleno() {
		return articleno;
	}

	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public Board(int articleno, String id, String subject, String content, int hit, String regtime) {
		super();
		this.articleno = articleno;
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
	}

}
