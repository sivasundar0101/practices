package com.poc.uptimefinder.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class URLentity {

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	Long id;
	@Column

	String URL;
	@Column
	int TimeInterval;

	@CreationTimestamp
	@Column(updatable = false)
	Timestamp createdDateTime;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "URL", referencedColumnName = "URL")
	private URLstatus urlstatus;
}
