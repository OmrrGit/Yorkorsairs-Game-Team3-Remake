package com.mygdx.game.Quests;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entitys.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocateQuestTest {

    LocateQuest questT;
    LocateQuest questT2;

    @Mock
    Player player;

    @BeforeEach
    void setUp() {
        Vector2 qPos = new Vector2(40, -40);
        questT = new LocateQuest(qPos, 10);
    }

    @Test
    public void LocateQuestCompletionTest () {
        Vector2 playerPos1 = new Vector2(30, -40);
        when(player.getPosition()).thenReturn(playerPos1);
        assertFalse(questT.checkCompleted(player));

        Vector2 playerPos2 = new Vector2(31, -40);
        when(player.getPosition()).thenReturn(playerPos2);
        assertTrue(questT.checkCompleted(player));
    }

    @Test
    public void LocateQuestPosTest () {
        Vector2 qP = new Vector2(40, -40);
        assertEquals(qP, questT.getLocation());
    }

    @Test
    public void LocateQuestIsCompleteTest () {
        assertFalse(questT.isCompleted());
    }

    @Test
    public void LocateQuestPlunderTest () {
        assertEquals(135, questT.getPlunderReward());
    }

    @Test
    public void LocateQuestXPTest () {
        assertEquals(50, questT.getXpReward());
    }

    @Test
    public void LocateQuestAmmoTest () {
        assertEquals(5, questT.getAmmoReward());
    }

    @Test
    public void LocateQuestNameTest () {
        assertEquals("Find a chest", questT.getName());
    }

    @Test
    public void LocateQuestDescTest () {
        assertEquals("South East", questT.getDescription());
        Vector2 qPos = new Vector2(-40, 40);
        questT2 = new LocateQuest(qPos, 10);
        assertEquals("North West", questT2.getDescription());
    }

}