package it.serpico.fgcr.mud.game.core.tests;

import it.serpico.fgcr.mud.game.core.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerTest {

    Player player;

    @BeforeAll
    void init() {
        player = new Player();
    }

    @Test
    void isPlayerAlive() {
        Assertions.assertEquals(Player.bIAmAlive(), true);
    }

}
