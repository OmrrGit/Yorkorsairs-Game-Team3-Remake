package com.mygdx.game.Entitys;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.mygdx.game.Components.Pirate;
import com.mygdx.game.Components.Renderable;
import com.mygdx.game.Components.Transform;
import com.mygdx.game.Faction;
import com.mygdx.game.Managers.GameManager;
import com.mygdx.game.Managers.RenderLayer;
import com.mygdx.game.Managers.ResourceManager;
import com.mygdx.utils.Utilities;

import java.util.ArrayList;

/**
 * Defines a college and its associated buildings.
 */
public class College extends Entity {

    private static ArrayList<String> buildingNames;
    private final ArrayList<Building> buildings;
    private Healthbar healthbar;

    private float buildingCount;
    private float aliveCount;


    public College() {
        super();
        buildings = new ArrayList<>();
        buildingNames = new ArrayList<>();
        buildingNames.add("big");
        buildingNames.add("small");
        buildingNames.add("clock");
        Transform t = new Transform();
        Pirate p = new Pirate();
        int healthbar_id = ResourceManager.getId("healthbar.png");
        Renderable r = new Renderable(healthbar_id, RenderLayer.Five);
        addComponents(t, p);

        healthbar = new Healthbar(RenderLayer.Above);
    }

    /**
     * Creates a college at the location associated with the given faction id.
     *
     * @param factionId numerical id of the faction
     */
    public College(int factionId) {
        this();
        Faction f = GameManager.getFaction(factionId);
        Transform t = getComponent(Transform.class);
        t.setPosition(f.getPosition());
        Pirate p = getComponent(Pirate.class);
        p.setFactionId(factionId);
        spawn(f.getColour(), factionId);

        healthbar.setPosition(t.getPosition().add(0, -15f));
    }

    /**
     * Randomly populates the college radius with buildings.
     *
     * @param colour used to pull the appropriate flag sprite
     */
    private void spawn(String colour, int factionId) {
        JsonValue collegeSettings = GameManager.getSettings().get("college");
        float radius = collegeSettings.getFloat("spawnRadius");
        // radius = Utilities.tilesToDistance(radius) * BUILDING_SCALE;
        final Vector2 origin = getComponent(Transform.class).getPosition();
        ArrayList<Vector2> posList = new ArrayList<>();
        posList.add(new Vector2(0, 0));

        buildingCount = 0;
        for (int i = 0; i < collegeSettings.getInt("numBuildings"); i++) {
            Vector2 pos = Utilities.randomPos(-radius, radius);
            pos = Utilities.floor(pos);

            if (!posList.contains(pos)) {
                posList.add(pos);
                buildingCount++;

                pos = Utilities.tilesToDistance(pos).add(origin);

                Building b = new Building(factionId);
                buildings.add(b);

                String b_name = Utilities.randomChoice(buildingNames, 0);

                b.create(pos, b_name);
            }
        }

        Building flag = new Building(factionId, true);
        buildings.add(flag);
        flag.create(origin, colour);

        healthbar.setMaxValue(buildingCount);
    }

    /**
     * True as long as unharmed buildings remain, false otherwise.
     */
    public void isAlive() {
        boolean res = false;
        aliveCount = 0;
        for (int i = 0; i < buildings.size() - 1; i++) {
            Building b = buildings.get(i);
            if (b.isAlive()) {
                res = true;
                aliveCount++;
            } else {
            }
        }
        this.healthbar.setValue(aliveCount);
        if (!res) getComponent(Pirate.class).kill();
    }

    @Override
    public void update() {
        super.update();
        isAlive();
    }
}
