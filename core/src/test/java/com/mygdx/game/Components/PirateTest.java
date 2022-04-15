package com.mygdx.game.Components;

import com.mygdx.game.Entitys.Ship;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PirateTest {

    Pirate pirateT;

    @Mock
    Ship tship1;


    @BeforeEach
    void setUp() {
        pirateT = new Pirate();
    }

    @Test
    public void uno () {
        assertEquals(1, 1);
    }

    @Test
    public void PirateFactionTest () {
        assertEquals(1, pirateT.getFaction().id,
                "Instantiated as being part of Halifax(faction id 1)");
        pirateT.setFactionId(2);
        assertEquals(2, pirateT.getFaction().id,
                "Faction id has been set to 2/an enemy faction");
    }

    @Test
    public void PirateDamageTest () {
        assertEquals(100, pirateT.getHealth());
        pirateT.takeDamage(50);
        assertEquals(50, pirateT.getHealth());
    }

    @Test
    public void PirateKillTest () {
        assertEquals(100, pirateT.getHealth());
        assertTrue(pirateT.isAlive());
        pirateT.kill();
        assertEquals(0, pirateT.getHealth());
        assertFalse(pirateT.isAlive());
    }

    @Test
    public void PirateTargetTest () {
        assertNull(pirateT.getTarget());
        pirateT.addTarget(tship1);
        assertEquals(tship1, pirateT.getTarget());
        pirateT.removeTarget();
        assertNull(pirateT.getTarget());
    }


}