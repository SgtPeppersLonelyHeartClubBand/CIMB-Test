package id.aldin.cimb.test.entity;

import java.util.Date;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
	
	@jakarta.persistence.Id
	@Column(name = "Id", nullable = false)
	private UUID id;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "quantity")
    private Integer quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 29)
    private Date createdAt;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", length = 29)
    private Date updateAt;
    
    public Product() {
    	
    }

	public Product(UUID id, String name, Double price, Integer quantity, Date createdAt, Date updateAt) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	
    
    

}
