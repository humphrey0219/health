package com.ebrace.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = -4214407514708064600L;
	@Id
	@GeneratedValue
	private Integer id;	 
	private String title;
	private String content;
	@Column(name = "author")
	private String creater;
	@Column(name = "create_date")
	private Date createDate;
	private String lastupdater;
	@Column(name = "last_update_date")
	private Date lastUpdateDate;	

}
