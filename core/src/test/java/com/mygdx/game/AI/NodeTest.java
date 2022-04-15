package com.mygdx.game.AI;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node testNode;

    @BeforeEach
    void setUp () {
        testNode = new Node(40, -40);
    }

    @Test
    public void NodePositionTest () {
        Vector2 pos1 = new Vector2(40, -40);
        Vector2 pos2 = new Vector2(30, -30);
        assertEquals(pos1, testNode.getPosition());
        testNode.set(30, -30);
        assertEquals(pos2, testNode.getPosition());
    }

}