package it.serpico.fgcr.mud.game.core.rooms;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public abstract class Room {

    private String name;
    private Map<String, Room> location;

    public Room(String name, Room... locations) {
        this.setName(name);
        this.setLocation(Arrays.stream(locations).collect(Collectors.toMap(Room::getName, identity())));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Room> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Room> location) {
        this.location = location;
    }

}
