package com.salesianostriana.dam.TrianaTourist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Interesa implements Serializable {

    @Builder.Default
    @EmbeddedId
    private InteresaPK id = new InteresaPK();

    @JsonIgnore
    @ManyToOne
    @MapsId("poi_id")
    @JoinColumn(name="poi_id", foreignKey = @ForeignKey(name = "FK_INTERESA_POI"))
    private POI poi;

    @JsonIgnore
    @ManyToOne
    @MapsId("route_id")
    @JoinColumn(name="route_id", foreignKey = @ForeignKey(name = "FK_INTERESA_ROUTE"))
    private Route route;


}
