package com.demo.continuoustests.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MovieId implements Serializable {

    @Column(name = "id_movie")
    private Integer idMovie;
}
