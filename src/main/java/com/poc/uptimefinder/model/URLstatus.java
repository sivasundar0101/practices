package com.poc.uptimefinder.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
@javax.persistence.Entity
public class URLstatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
    private String URL;
	private String Status;
	
	@CreationTimestamp
    @Column(updatable = false)
    private Timestamp statusDateTime;
	
	@JoinColumn(name="urlstatus_id")
	@OneToOne
	private URLstatus urLstatus;
}
