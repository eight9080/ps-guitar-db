package com.guitar.db.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NamedQuery(name="Model.findAllModelsByType", query="select m from Model m where m.modelType.name = :name")
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Version
	private int version;

	private String name;	
	private BigDecimal price;
	private int frets;
	private String woodType;
	private Date yearFirstMade;
	
	@ManyToOne
	private Manufacturer manufacturer;

	@ManyToOne
	private ModelType modelType;

	@CreatedBy
	@ManyToOne
	private User createdByUser;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedBy
	@ManyToOne
	private User lastModifiedByUser;

	@LastModifiedDate
	private LocalDateTime lastModifiedByDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getFrets() {
		return frets;
	}

	public void setFrets(int frets) {
		this.frets = frets;
	}

	public String getWoodType() {
		return woodType;
	}

	public void setWoodType(String woodType) {
		this.woodType = woodType;
	}

	public Date getYearFirstMade() {
		return yearFirstMade;
	}

	public void setYearFirstMade(Date yearFirstMade) {
		this.yearFirstMade = yearFirstMade;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	public Long getId() {
		return id;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getLastModifiedByUser() {
		return lastModifiedByUser;
	}

	public void setLastModifiedByUser(User lastModifiedByUser) {
		this.lastModifiedByUser = lastModifiedByUser;
	}

	public LocalDateTime getLastModifiedByDate() {
		return lastModifiedByDate;
	}

	public void setLastModifiedByDate(LocalDateTime lastModifiedByDate) {
		this.lastModifiedByDate = lastModifiedByDate;
	}
}
