package it.serpico.fgcr.mud.game.core.npc;

public class EnemyNpc extends Npc {

    private final int damage = 10;

    public EnemyNpc(String name) {
        super(name);
    }

    private int doDamage() {
        return this.damage;
    }

    @Override
    public String hiIAm() {
        return NbcDialogues.ENEMY_HELLO + getName();
    }

}
