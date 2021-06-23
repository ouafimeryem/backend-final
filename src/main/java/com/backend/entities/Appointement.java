package com.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(name = "RENDEZVOUS")
public @Data class Appointement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private LocalDateTime dt;

    private Date date1;
    private Date date2;
    private String objet;
    private String commentaire;
    private boolean confirmed = false;

    @ManyToOne
    Client client;

    @ManyToOne
    Agent agent;


}
