package fr.tathan.mom;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.tathan.mom.mechanics.effect.EffectMechanic;
import io.th0rgal.oraxen.utils.PotionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Utils {

    public static Boolean isPlayerPremium(Player player) throws MalformedURLException {
        String playerName = player.getName();

        System.out.println(Bukkit.getOfflinePlayer(playerName).getUniqueId().toString());
        String playerUUId = player.getUniqueId().toString();
        playerUUId = playerUUId.replace("-", "");

        JsonParser parser = new JsonParser();
        URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName + "?at=" + System.currentTimeMillis() / 1000L);
        JsonObject onlineJSON = (JsonObject) parser.parse(getJsonFromUrl(url));
        System.out.println(url);

        String mojangUUId = onlineJSON.get("id").getAsString();

        System.out.println("Player UUID :" + playerUUId);
        System.out.println("Player UUID by MOJANG :" + mojangUUId);


        return Objects.equals(playerUUId, mojangUUId);
    }

    public static String getJsonFromUrl(URL url) {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPremium( String name )
    {
        try {
            URL url = new URL("https://api.ashcon.app/mojang/v2/user/" + name );
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            return ( connection.getResponseCode() == HttpURLConnection.HTTP_OK );
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public static PotionEffect getPotionEffect(EffectMechanic mechanic) {
        String effect = mechanic.getEffect();
        int duration = mechanic.getDuration();
        int amplifier = mechanic.getAmplifier();
        if (PotionUtils.getEffectType(effect) == null) return null;

        return new PotionEffect(PotionUtils.getEffectType(effect), duration, amplifier);
    }


}
