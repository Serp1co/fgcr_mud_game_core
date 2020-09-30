package it.serpico.fgcr.mud.game.core.actions.fight;

import it.serpico.fgcr.mud.game.core.actions.ActionMessage;

public interface ICanDamageNotify extends ICanDamage {
    ActionMessage doDamage(ICanBeDamaged taker);
}
