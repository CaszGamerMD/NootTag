package me.caszgamermd.noottag.filesystem;

public enum ConfigurationType {
    CONFIG("config.yml"), LANG("lang.yml");

    private String fileName;

    ConfigurationType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
