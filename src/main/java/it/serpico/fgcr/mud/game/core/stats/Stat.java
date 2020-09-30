package it.serpico.fgcr.mud.game.core.stats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Stat {

    private int value = 1;
    private int maxValue = 10;

    public int getValue(){
        return this.value;
    }

    public void setValue(int value) throws StatValueException {
        if(value > maxValue) throw new StatValueException(StatValueException.StatTooHighExceptionMessage(this.getClass(), value));
    }

}
