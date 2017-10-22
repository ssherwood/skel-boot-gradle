package io.undertree.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HELLO")
public class HelloRecord {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	protected HelloRecord() {
	}

	public HelloRecord(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
