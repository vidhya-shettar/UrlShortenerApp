package com.lowes.org.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Url value can not be empty")
	@Size(min = 10,message = "Length Should be more than 10 characters")
	private String urlVal;
	private String urlId;
	private int count;

	public Url() {
	}

	public Url(int id, String urlVal) {
		this.id = id;
		this.urlVal = urlVal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlVal() {
		return urlVal;
	}

	public void setUrlVal(String urlVal) {
		this.urlVal = urlVal;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
