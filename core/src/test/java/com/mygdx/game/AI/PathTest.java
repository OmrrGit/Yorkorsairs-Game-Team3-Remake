package com.mygdx.game.AI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PathTest {
    Path pathT;

    @Mock
    Node nodeT;

    @Mock
    Node nodeF;

    @BeforeEach
    void setUp () {
        pathT = new Path(nodeF, nodeT);

    }

    @Test
    void PathNodeTest() {
        assertEquals(nodeT, pathT.getToNode());
        assertEquals(nodeF, pathT.getFromNode());
    }

    @Test
    void PathCostTest() {
        assertEquals(nodeT.cost, pathT.getCost());
    }

}