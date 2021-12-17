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
    private String descripcion;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

    @Builder.Default
    @OneToMany(mappedBy = "poi")
    private List<Interesa> interesas = new ArrayList<>();

}
