package me.c1tad31.chb.events;

import java.awt.Color;

import me.c1tad31.chb.utils.MessageEmbed;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().getIdLong() != 892899456574435348l) {
            Member member = event.getMember();
            TextChannel channel = event.getGuild().getTextChannelById(892907856725172226l);
            String[] message = event.getMessage().getContentRaw().split(" ");

            MessageEmbed.createEventEmbed(event, channel, member, "Message Sent by: " + member.getUser().getName(), "```Message Content:```\n" + message, "Made by Citadel", Color.decode("#000000"));
        } 
    }
    
}
