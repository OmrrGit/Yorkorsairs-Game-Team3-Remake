package com.mygdx.game.Quests;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Entitys.Player;
import com.mygdx.game.Faction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KillQuestTest {
    Quest questT;

    @Mock
    Player player;

    @Mock
    Pirate targetP;

    @Mock
    Faction fac;

    @BeforeEach
    void setUp() {
        when(targetP.getFaction()).thenReturn(fac);
        when(fac.getName()).thenReturn("factionMock");
        questT = new KillQuest(targetP);
    }

    @Test
    public void KillQuestCompletionTest () {
        when(targetP.isAlive()).thenReturn(true);
        assertFalse(questT.checkCompleted(player));
        when(targetP.isAlive()).thenReturn(false);
        assertTrue(questT.checkCompleted(player));
    }

    @Test
    public void KillQuestIsCompleteTest () {
        assertFalse(questT.isCompleted());
    }

    @Test
    public void KillQuestPlunderTest () {
        assertEquals(75, questT.getPlunderReward());
    }

    @Test
    public void KillQuestXPTest () {
        assertEquals(80, questT.getXpReward());
    }

    @Test
    public void KillQuestAmmoTest () {
        assertEquals(20, questT.getAmmoReward());
    }

    @Test
    public void KillQuestNameTest () {
        assertEquals("Kill the college", questT.getName());
    }

    @Test
    public void KillQuestDescTest () {
        assertEquals("factionMock", questT.getDescription());
    }

}