package com.hp1.demo.Controller;



public class SpellsResultDTO {

    private String id;
    private String name;
    private String type;
    private String effect;
    private String category; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCategory() {
        return category; 
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
