package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "routes",
            inverseJoinColumns = @JoinColumn(name = "poi_id", foreignKey = @ForeignKey(name = "FK_ROUTES_POI")),
            joinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_ROUTES_ROUTE")))
    private List<POI> steps = new ArrayList<>();



}
