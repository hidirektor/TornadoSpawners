package me.t3sl4.tornadosp.serialize;

public class ItemSpawnerType {
    private String spawnerid;

    private CustomItem necikaracagi;

    private CustomItem kendisi;

    private int count;

    private int range;

    private int mindelay;

    private int maxdelay;

    private int requiredrange;

    public ItemSpawnerType(String spawner_id, CustomItem spawner_customitem, CustomItem dropped_item_customitem, int spawner_count, int spawner_range, int spawner_mindelay, int spawner_maxdelay, int spawner_requiredrange) {
        this.spawnerid = spawner_id;
        this.necikaracagi = dropped_item_customitem;
        this.kendisi = spawner_customitem;
        this.count = spawner_count;
        this.range = spawner_range;
        this.mindelay = spawner_mindelay;
        this.maxdelay = spawner_maxdelay;
        this.requiredrange = spawner_requiredrange;
    }

    public int getCount() {
        return this.count;
    }

    public int getRange() {
        return this.range;
    }

    public int getMindelay() {
        return this.mindelay;
    }

    public int getMaxdelay() {
        return this.maxdelay;
    }

    public int getRequiredrange() {
        return this.requiredrange;
    }

    public String getSpawnerid() {
        return this.spawnerid;
    }

    public CustomItem getNecikaracagi() {
        return this.necikaracagi;
    }

    public CustomItem getKendisi() {
        return this.kendisi;
    }
}
