package me.caszgamermd.noottag.filesystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ConfigurationFile {

    private ConfigurationType type;
    private Path dataFolder, filePath;
    private FileConfiguration fileConfiguration;

    ConfigurationFile(ConfigurationType type, Path dataFolder) {
        this.type = type;
        this.dataFolder = dataFolder;

        initialization();
    }

    private void initialization() {
        filePath = Paths.get(dataFolder.toString() + "/" + type.getFileName());

        if (Files.notExists(filePath)) {
            System.out.println(type.getFileName() + " does not exist. Creating!");

            try {
                Files.createFile(filePath);
                Files.copy(getClass().getResourceAsStream("/" + type.getFileName()), filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        fileConfiguration = YamlConfiguration.loadConfiguration(filePath.toFile());
    }

    public void save(boolean reload) {
        try {
            fileConfiguration.save(filePath.toFile());
        } catch (IOException ex) {
            System.out.println("Could not save" + type.getFileName() + " properly!");
        }

        if (reload) initialization();
    }

    FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }
}
