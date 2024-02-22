package com.alibou.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cabinemedical")
public class CabineMedical extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "starthour")
    private String starthour;
    @Column(name ="endhour")
    private String endhour;
    @Column(name = "latlong")
    private String latlong;

    @ManyToOne
    @JoinColumn(name = "idcommune")
    private Commune commune;
}
