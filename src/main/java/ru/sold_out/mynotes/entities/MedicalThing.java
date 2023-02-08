package ru.sold_out.mynotes.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicalThing implements Serializable {
	@Serial
	private static final long serialVersionUID = 100L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer consultationPrice;

	@Column(nullable = false)
	private Integer treatmentPrice;
}
