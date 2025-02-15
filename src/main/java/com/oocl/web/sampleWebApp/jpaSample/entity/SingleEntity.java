package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

@Entity
public class SingleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToOne
    RelatedEntity relatedEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RelatedEntity getRelatedEntity() {
        return relatedEntity;
    }

    public void setRelatedEntity(RelatedEntity relatedEntity) {
        this.relatedEntity = relatedEntity;
    }
}
