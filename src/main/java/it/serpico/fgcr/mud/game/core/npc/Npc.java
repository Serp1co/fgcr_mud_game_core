package it.serpico.fgcr.mud.game.core.npc;

public abstract class Npc {

    private String name;

    public Npc(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String hiIAm() {
        return NbcDialogues.GENERIC_HELLO + name;
    }

}
