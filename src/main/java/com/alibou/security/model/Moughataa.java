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
@Table(name = "moughataa")
public class Moughataa extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idwilaya")
    private Wilaya wilaya;

    @OneToMany(mappedBy = "moughataa")
    private List<Commune> communes;
}
