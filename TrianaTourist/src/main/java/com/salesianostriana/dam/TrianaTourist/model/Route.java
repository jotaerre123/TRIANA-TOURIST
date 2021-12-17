package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    private List<POI> steps = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "route")
    private List<Interesa> interesas = new ArrayList<>();


}
