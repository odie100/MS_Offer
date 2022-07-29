package com.akata.application.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Client extends User{
    String name;
    String type;
    String description;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
