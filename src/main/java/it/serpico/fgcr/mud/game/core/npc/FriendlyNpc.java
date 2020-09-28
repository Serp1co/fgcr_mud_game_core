package it.serpico.fgcr.mud.game.core.npc;

public class FriendlyNpc extends Npc {

    public FriendlyNpc(String name) {
        super(name);
    }

    public String sayMessage() {
        return "Anche io un giorno voglio diventare forte come Jotaro!";
    }

    @Override
    public String hiIAm() {
        return NbcDialogues.FRIENDLY_HELLO + super.hiIAm();
    }
}
