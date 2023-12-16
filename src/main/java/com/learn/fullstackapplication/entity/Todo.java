package com.learn.fullstackapplication.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "todo_title")
	private String title;

	@Column(name = "todo_description")
	private String description;

	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	@JsonIgnore
	private Date createdDate;

	@Column(name = "is_complete")
	private boolean isComplete;

	public Todo() {
	}

	public Todo(int id, String title, String description, boolean isComplete) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.isComplete = isComplete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}
