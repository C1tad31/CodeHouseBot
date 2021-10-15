package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import me.c1tad31.chb.utils.MessageEmbed;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MemeCommand extends Command {

    public MemeCommand() {
        this.name = "meme";
        this.help = "Displays a random meme from reddit";
    }

    @Override
    protected void execute(CommandEvent event) {

        String postLink = "";
        String title = "";
        String url = "";

        JSONParser parser = new JSONParser();
        try {
            URL memeURL = new URL("https://meme-api.herokuapp.com/gimme");
            BufferedReader reader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

            String lines;
            while ((lines = reader.readLine()) != null) {
                JSONArray array = new JSONArray();
                array.add(parser.parse(lines));
                for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;

                    postLink = (String) jsonObject.get("postLink");
                    title = (String) jsonObject.get("title");
                    url = (String) jsonObject.get("url");
                }
            }
            reader.close();

            event.getMessage().delete().queue();
            MessageEmbed.createEmbed(event, event.getTextChannel(), event.getMember(), title, url, postLink, "Made by: Citadel", Color.BLACK);
        } catch (Exception e) {
            event.reply("Something went wrong!");
            e.printStackTrace();
        }
    }
}
