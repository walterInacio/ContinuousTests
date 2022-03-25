package com.demo.continuoustests.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @EmbeddedId
    private MovieId id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
