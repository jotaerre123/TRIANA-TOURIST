package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class POI implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    @Lob
    private String description;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGORY"))
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

    public void addToRoute(Route route){
        route.getSteps().add(this);
    }
    public void deleteFromRoute(Route route){
        route.getSteps().remove(this);
    }





}
