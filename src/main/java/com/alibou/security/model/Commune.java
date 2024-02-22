package com.alibou.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commune")
public class Commune extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idmoughataa")
    private Moughataa moughataa;

    @OneToMany(mappedBy = "commune")
    private List<Pharmacie> pharmacies;

    @OneToMany(mappedBy = "commune")
    private List<CabineMedical> cabineMedicals;
}
