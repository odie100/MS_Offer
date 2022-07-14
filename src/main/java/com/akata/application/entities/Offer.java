package com.akata.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offer_id;
    private String theme;
    private String details;
    private LocalDate deadline;
    private String type;
    private String technology;
    private LocalDate post_date;
    private int applicant_number;

    @ManyToOne
    Client client;

    @OneToMany(mappedBy = "offer")
    Set<Apply> apply;
}
