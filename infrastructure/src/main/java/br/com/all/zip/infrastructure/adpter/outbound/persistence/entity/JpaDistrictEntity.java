package br.com.all.zip.infrastructure.adpter.outbound.persistence.entity;
import jakarta.persistence.*;

@Table(name = "districts")
@Entity
public class JpaDistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private JpaCityEntity city;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JpaCityEntity getCity() {
        return city;
    }

    public void setCity(JpaCityEntity city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
