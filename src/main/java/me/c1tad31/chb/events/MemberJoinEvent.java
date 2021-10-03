package me.c1tad31.chb.events;

import java.awt.Color;
import java.time.Instant;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoinEvent extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel channel = event.getGuild().getTextChannelById(894048228775981116l);
        Member member = event.getMember();

        EmbedBuilder memberJoinEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle("New Member Joined")
            .setDescription("Welcome to Coding House " + member.getUser().getName())
            .setColor(Color.decode("#000000"))
            .setThumbnail(event.getGuild().getIconUrl())
            .setTimestamp(Instant.now())
            .setFooter("Developed by: Citadel#1829 and Carter_Rogers#0052");

        channel.sendMessage(memberJoinEmbed.build()).queue();
    }
    
}
