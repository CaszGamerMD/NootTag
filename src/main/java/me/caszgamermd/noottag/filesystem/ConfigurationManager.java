package me.caszgamermd.noottag.filesystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    private Path dataFolder;
    private Map<ConfigurationType, ConfigurationFile> mappedConfigurations;

    public ConfigurationManager(Plugin plugin) {
        dataFolder = plugin.getDataFolder().toPath();
        mappedConfigurations = new HashMap<>();

        loadConfigurations();
    }

    public void loadConfigurations() {
        mappedConfigurations.clear();

        if (!Files.exists(dataFolder)) {
            try {
                Files.createDirectories(dataFolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (ConfigurationType type : ConfigurationType.values()) {
            mappedConfigurations.put(type, new ConfigurationFile(type, dataFolder));
        }
    }

    public FileConfiguration getConfig(ConfigurationType type) {
        return mappedConfigurations.get(type).getFileConfiguration();
    }

    public ConfigurationFile getConfigurationFile(ConfigurationType type) {
        return mappedConfigurations.get(type);
    }
}
