package me.arrows.eventtp;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("EventTP had loaded");
        loadConfing();
        new SetEvent(this);
        new delEvent(this);
        new tpEvent(this);
    }

    private void loadConfing(){
        getConfig().options().copyDefaults(false);
        saveConfig();
    }

}


