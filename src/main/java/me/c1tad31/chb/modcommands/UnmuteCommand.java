package me.c1tad31.chb.modcommands;

import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class UnmuteCommand extends Command {

    public UnmuteCommand() {
        this.name = "unmute";
        this.help = "Unmute a user in the chat";
        this.aliases = new String[]{};
        this.userPermissions = new Permission[]{Permission.MANAGE_ROLES};
        this.botPermissions = new Permission[]{Permission.MANAGE_ROLES};
        this.cooldown = 10;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        Message message = event.getMessage();
        Member target = event.getMessage().getMentionedMembers().get(0);
        Role role = (Role) event.getGuild().getRolesByName("Muted", true);

        if (member == null) {
            channel.sendMessage("Please Mention a member to mute!").complete().delete().queueAfter(10, TimeUnit.SECONDS);
        }

        target.getGuild().addRoleToMember(target, role).queue();
        channel.sendMessage(" " + target.getAsMention() + " has been muted by: " + member.getAsMention()).queue();

    }
}
