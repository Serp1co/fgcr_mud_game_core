package it.serpico.fgcr.mud.game.core.actions;

import it.serpico.fgcr.mud.game.core.enums.ActionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ActionMessage {
    ActionEnum requestEnum;
    String requestMessage;
}
