package com.mygdx.game.AI;

import com.mygdx.game.AI.Node;
import com.mygdx.game.AI.NodeHeuristic;
import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NodeHeuristicTest {

    NodeHeuristic heuristicT;

    @Mock
    Node node1;

    @Mock
    Node node2;

    @BeforeEach
    void setup () {
        heuristicT = new NodeHeuristic();
    }

    @Test
    public void EuclideanHeuristicTest() {
        Vector2 v1 = new Vector2(2, 3);
        Vector2 v2 = new Vector2(4, 5);
        when(node1.getPosition()).thenReturn(v1);
        when(node2.getPosition()).thenReturn(v2);
        assertEquals(8, heuristicT.estimate(node1, node2));
    }

}