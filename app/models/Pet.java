package models;

import black.door.hate.HalRepresentation;
import black.door.hate.HalResource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;

/**
 * Created by nfischer on 8/21/2016.
 */
@Entity
public class Pet implements HalResource{

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private String type;

	@Column
	private String status;

	@Column(name = "photo_url")
	private String photoUrl;

	public long getId() {
		return id;
	}

	public Pet setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Pet setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return type;
	}

	public Pet setType(String type) {
		this.type = type;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Pet setStatus(String status) {
		this.status = status;
		return this;
	}

	public URI getPhotoUrl() {
		return photoUrl == null ? null : URI.create(photoUrl);
	}

	public Pet setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
		return this;
	}

	@Override
	public HalRepresentation.HalRepresentationBuilder representationBuilder() {
		HalRepresentation.HalRepresentationBuilder builder = HalRepresentation.builder()
				.addProperty("name", name)
				.addProperty("type", type)
				.addProperty("status", status)
				.addLink("self", this);
		if(photoUrl != null)
			builder = builder.addLink("photo", getPhotoUrl());
		return builder;
	}

	@Override
	public URI location() {
		return URI.create(controllers.routes.ResourceController.showPet(id).url());
	}
}
