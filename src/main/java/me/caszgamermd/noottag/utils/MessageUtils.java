package me.caszgamermd.noottag.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class MessageUtils {

    public String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message); }

    public List<String> colorize(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, colorize(list.get(i)));
        }

        return list;
    }

}
