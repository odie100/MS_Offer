package com.akata.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offer_id;
    private String theme;
    private String details;
    private LocalDate deadline;
    private LocalDate post_date;
    private int applicant_number;

    @ManyToOne
    Client client;

    @ManyToOne
    Category category;

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", theme='" + theme + '\'' +
                ", details='" + details + '\'' +
                ", deadline=" + deadline +
                ", post_date=" + post_date +
                ", applicant_number=" + applicant_number +
                ", client=" + client +
                ", categories=" + category +
                '}';
    }
}
