package it.serpico.fgcr.mud.game.core.actions.speak;

import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.IAction;

public interface ICanTalk {
    String doAsk(long questionCode);
    String doAnswer(String question);
    ActionMessageStack doSpeak(ICanTalk speak);
}
