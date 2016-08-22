package models;

import black.door.hate.HalRepresentation;
import black.door.hate.HalResource;

import javax.persistence.*;
import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by nfischer on 8/21/2016.
 */
@Entity
@Table(name = "orders")
public class Order implements HalResource{

	@Id
	@GeneratedValue
	private long id;

	@JoinColumn(name = "pet_id")
	@ManyToOne
	private Pet pet;

	@JoinColumn(name = "item_id")
	@ManyToOne
	private Item item;

	@Column
	private int quantity;

	@Column(name = "order_date")
	private Timestamp orderDate = Timestamp.from(Instant.now());

	public long getId() {
		return id;
	}

	public Order setId(long id) {
		this.id = id;
		return this;
	}

	public Pet getPet() {
		return pet;
	}

	public Order setPet(Pet pet) {
		this.pet = pet;
		return this;
	}

	public Item getItem() {
		return item;
	}

	public Order setItem(Item item) {
		this.item = item;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public Order setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public Order setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
		return this;
	}

	@Override
	public HalRepresentation.HalRepresentationBuilder representationBuilder() {
		return HalRepresentation.builder()
				.addProperty("quantity", quantity)
				.addProperty("orderDate", orderDate)
				.addLink("self", this)
				.addLink("pet", pet)
				.addEmbedded("item", item);
	}

	@Override
	public URI location() {
		return URI.create(controllers.routes.ResourceController.showOrder(id).url());
	}
}
