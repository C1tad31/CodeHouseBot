package me.c1tad31.chb.utils;

import java.awt.Color;
import java.time.Instant;

import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.Invite.Channel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageEmbed {
    public static void createEmbed(CommandEvent event, TextChannel channel, Member member, String title, String desc, String footer, Color color) {
        EmbedBuilder newEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle(title)
            .setDescription(desc)
            .setColor(color)
            .setThumbnail(event.getGuild().getIconUrl())
            .setTimestamp(Instant.now())
            .setFooter(footer);

        channel.sendMessage(newEmbed.build()).queue();
    }

    public static void createEventEmbed(GuildMessageReceivedEvent event, TextChannel channel, Member member, String title, String desc, String footer, Color color) {
        EmbedBuilder newEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle(title)
            .setDescription(desc)
            .setColor(color)
            .setThumbnail(event.getGuild().getIconUrl())
            .setTimestamp(Instant.now())
            .setFooter(footer);

        channel.sendMessage(newEmbed.build()).queue();
    }

    public static void createDMEmbed(CommandEvent event, PrivateChannel channel, Member member, String title, String desc, String footer, Color color) {
        EmbedBuilder newEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle(title)
            .setDescription(desc)
            .setColor(color)
            .setThumbnail(event.getGuild().getIconUrl())
            .setTimestamp(Instant.now())
            .setFooter(footer);

        channel.sendMessage(newEmbed.build()).queue();
    }
}
