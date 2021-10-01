package me.c1tad31.chb.commands;

import java.nio.channels.Channel;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class MoveVCCommand extends Command {

    public MoveVCCommand() {
        this.name = "move";
        this.help = "Move a user to a different VC";
        this.userPermissions = new Permission[]{Permission.VOICE_MOVE_OTHERS};
        this.botPermissions = new Permission[]{Permission.VOICE_MOVE_OTHERS};
        this.cooldown = 10;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        Member member = event.getMember();
        VoiceChannel voiceChannel = event.getGuild().getVoiceChannelById(args[2]);
        Member user = event.getMessage().getMentionedMembers().get(0);
        TextChannel channel = event.getTextChannel();
        getVC(event, channel, member, voiceChannel, user);
    }

    private void getVC(CommandEvent event, TextChannel textChannel, Member member, VoiceChannel channel, Member user) {

        event.getGuild().moveVoiceMember(member, channel);
        textChannel.sendMessage("Moved User: " + user.getAsMention());
    }

}