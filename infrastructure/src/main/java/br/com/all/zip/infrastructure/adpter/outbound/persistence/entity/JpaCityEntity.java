package br.com.all.zip.infrastructure.adpter.outbound.persistence.entity;

import jakarta.persistence.*;

@Table(name = "cities")
@Entity
public class JpaCityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "slug")
    private String slug;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getStateId() {
        return stateId;
    }
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
