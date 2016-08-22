package models;

import black.door.hate.JacksonHalResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;

/**
 * Created by nfischer on 8/21/2016.
 */
@Entity
public class Item implements JacksonHalResource{

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	public long getId() {
		return id;
	}

	public Item setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public URI location() {
		return URI.create(controllers.routes.ResourceController.showItem(id).url());
	}
}
