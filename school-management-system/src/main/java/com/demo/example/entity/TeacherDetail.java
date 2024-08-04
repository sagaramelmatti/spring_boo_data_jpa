package com.demo.example.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the teacher_details database table.
 * 
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher_details")
public class TeacherDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "contact_number", nullable = false, length = 12)
	private String contactNumber;

	@Column(nullable = false, length = 50)
	private String education;

	@Column(nullable = false, length = 100)
	private String name;

	// bi-directional many-to-many association to StandardDetail
	@ManyToMany
	@JoinTable(name = "teacher_standard_details", 
				joinColumns = {@JoinColumn(name = "teacher_id", nullable = false) }, 
				inverseJoinColumns = {@JoinColumn(name = "standard_id", nullable = false) })
	private List<StandardDetail> standardDetails;

}