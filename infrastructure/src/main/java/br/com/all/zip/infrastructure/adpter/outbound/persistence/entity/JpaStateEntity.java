package br.com.all.zip.infrastructure.adpter.outbound.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class JpaStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String initials;

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
    public String getInitials() {
        return initials;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }

}
