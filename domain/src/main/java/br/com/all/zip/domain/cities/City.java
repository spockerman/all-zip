package br.com.all.zip.domain.cities;

public class City {
    private final Integer id;
    private final String name;
    private final Integer stateId;
    private final String slug;

    public City(Integer id, String name, Integer stateId, String slug) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.slug = slug;
    }

    public static City newCities(Integer id, String name, Integer stateId, String slug) {
        return new City(null, name, stateId, slug);
    }

    public static City with(
            Integer id,
            String name,
            Integer stateId,
            String slug
    ){
        return new City(id, name, stateId, slug);
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getStateId() {
        return stateId;
    }
    public String getSlug() {
        return slug;
    }

}
