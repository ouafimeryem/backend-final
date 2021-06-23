package com.backend.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name="AGENT")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ID_AGENT")),
    @AttributeOverride(name = "nom", column = @Column(name = "NOM_AGENT")),
    @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_AGENT")),
    @AttributeOverride(name = "cin", column = @Column(name = "CIN_AGENT")),
    @AttributeOverride(name = "adresse", column = @Column(name = "ADRESSE_AGENT")),
    @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_AGENT")),
    @AttributeOverride(name = "email", column = @Column(name = "EMAIL_AGENT")),
    @AttributeOverride(name = "username", column = @Column(name = "USERNAME_AGENT")),
    @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_AGENT")),
    @AttributeOverride(name = "role", column = @Column(name = "ROLE_AGENT"))
})
public @Data class Agent extends Utilisateur{
	
	@ManyToOne
	@JoinColumn(name="CREATION_ADMIN_AGENT")
	Admin creationAdmin;
	
	@JoinColumn(name="AGENCE_AGENT")
	@ManyToOne
	Agence agence;
	
	@JsonIgnore
	@Column(name="APPOINTEMENT_AGENT")
	@OneToMany(mappedBy="agent",cascade=CascadeType.ALL)
	List<Appointement> appointements;
	
	
}
