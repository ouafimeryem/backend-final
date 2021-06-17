package com.backend.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BENEFICIAIRE")
public @Data class Beneficiaire extends Compte {
	
	@JoinColumn(name="PARENT_COMPTE")
	@ManyToOne
	Client parent;
}
