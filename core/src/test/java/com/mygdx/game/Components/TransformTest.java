package com.mygdx.game.Components;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.utils.Utilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransformTest {
    Transform transT;

    @BeforeEach
    void setUp() {
        transT = new Transform();
    }

    @Test
    public void TransformSetPosTest () {
        Vector2 v1 = new Vector2(40, -40);
        transT.setPosition(v1);
        assertEquals(v1, transT.getPosition());
    }

    @Test
    public void TransformSetScaleTest () {
        Vector2 v1 = new Vector2(2, -2);
        transT.setScale(v1);
        assertEquals(v1, transT.getScale());

        Vector2 v2 = new Vector2(3, -3);
        transT.setScale(3, -3);
        assertEquals(v2, transT.getScale());
    }

    @Test
    public void TransformSetRotateTest () {
        transT.setRotation(1);
        assertEquals(1, transT.getRotation());
    }

    @Test
    public void TransformSetOrientationTest () {
        transT.setOrientation(0);
        assertEquals(0, transT.getOrientation());
    }

    @Test
    public void TransformVecToAngleTest () {
        Vector2 v1 = new Vector2(2, -2);
        assertEquals(-2.356194496154785, transT.vectorToAngle(v1));
    }

    @Test
    public void TransformAngleToVecTest () {
        Vector2 v1 = new Vector2(2, -2);
        assertEquals(-0.9092974066734314, transT.angleToVector(v1, 2).x);
        assertEquals(-0.416146844625473, transT.angleToVector(v1, 2).y);
    }

}