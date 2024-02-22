package com.alibou.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wilaya")
public class Wilaya extends AbstractEntity{
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "wilaya")
    private List<Moughataa> moughataas;
}
