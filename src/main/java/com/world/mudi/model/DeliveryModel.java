package com.world.mudi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "DeliveryEntity")
@Table(name = "delivery")
public class DeliveryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id", nullable = false)
	private Long deliveryId;

	@Column(name = "delivery_date", nullable = false)
	private LocalDate deliveryDate;

	@Column(name = "price_concerted", nullable = false)
	private BigDecimal priceConcerted;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "delivery")
	private List<ProductModel> products;

	public DeliveryModel() {
	}

	public DeliveryModel(Long deliveryId, LocalDate deliveryDate,
						 BigDecimal priceConcerted,
						 StateDelivery stateDelivery, List<ProductModel> products) {
		this.deliveryId = deliveryId;
		this.deliveryDate = deliveryDate;
		this.priceConcerted = priceConcerted;
		this.products = products;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public BigDecimal getPriceConcerted() {
		return priceConcerted;
	}

	public void setPriceConcerted(BigDecimal priceConcerted) {
		this.priceConcerted = priceConcerted;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Delivery{" +
				"deliveryId:" + deliveryId +
				", deliveryDate:" + deliveryDate +
				", priceConcerted:" + priceConcerted +
				", products:" + products +
				'}';
	}
}