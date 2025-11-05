package br.com.all.zip.domain;

public class States {

    private final Integer id;
    private final String name;
    private final String initials;

    public States(Integer id, String name, String initials) {
        this.id = id;
        this.name = name;
        this.initials = initials;
    }

    public static States newStates(Integer id, String name, String initials) {
        return new States(null, name, initials);
    }

    public static States with(
            Integer id,
            String name,
            String initials
    ){
        return new States(id, name, initials);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }
}
