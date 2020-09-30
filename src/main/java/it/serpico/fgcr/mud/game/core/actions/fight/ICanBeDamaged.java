package it.serpico.fgcr.mud.game.core.actions.fight;

import it.serpico.fgcr.mud.game.core.actions.ActionMessage;

public interface ICanBeDamaged {
    ActionMessage takeDamage(int damage);
}
