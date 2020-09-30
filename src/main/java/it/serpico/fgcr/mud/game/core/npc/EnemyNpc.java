package it.serpico.fgcr.mud.game.core.npc;

import it.serpico.fgcr.mud.game.core.actions.ActionMessage;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanBeDamaged;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanDamageNotify;

public class EnemyNpc extends Npc implements ICanDamageNotify, ICanBeDamaged {

    public EnemyNpc(String name) {
        super(name);
    }

    @Override
    public String hiIAm() {
        return NbcDialogues.ENEMY_HELLO + getName();
    }

    public ActionMessage takeDamage(ICanDamageNotify damage) {
        return null;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public ActionMessage takeDamage(int damage) {
        return null;
    }

    @Override
    public ActionMessage doDamage(ICanBeDamaged taker) {
        return null;
    }
}
