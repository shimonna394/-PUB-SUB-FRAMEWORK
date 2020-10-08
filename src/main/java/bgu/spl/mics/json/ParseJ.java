
package bgu.spl.mics.json;

import java.util.List;

import bgu.spl.mics.application.passiveObjects.Agent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParseJ {

    @SerializedName("inventory")
    @Expose
    private String[] inventory = null;
    @SerializedName("services")
    @Expose
    private JsonServices services;
    @SerializedName("squad")
    @Expose
    private Agent[] squad = null;

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    public JsonServices getServices() {
        return services;
    }

    public void setServices(JsonServices services) {
        this.services = services;
    }

    public Agent[] getSquad() {
        return squad;
    }

    public void setSquad(Agent[] squad) {
        this.squad = squad;
    }

}
