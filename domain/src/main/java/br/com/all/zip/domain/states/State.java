package br.com.all.zip.domain.states;

public class State {

    private final Integer id;
    private final String name;
    private final String initials;

    public State(Integer id, String name, String initials) {
        this.id = id;
        this.name = name;
        this.initials = initials;
    }

    public static State newStates(Integer id, String name, String initials) {
        return new State(null, name, initials);
    }

    public static State with(
            Integer id,
            String name,
            String initials
    ){
        return new State(id, name, initials);
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
