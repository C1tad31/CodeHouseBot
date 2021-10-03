package me.c1tad31.chb.modcommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class MuteCommand extends Command {

    public MuteCommand() {
        this.name = "mute";
        this.help = "Mute a user in the chat";
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
        StringBuilder reason = new StringBuilder();
        List<Role> role = event.getGuild().getRolesByName("Muted", true);

        for (Role r : role) {
            if (!role) {
                channel.sendMessage("Muted role not found... Creating one now!")
                event.getGuild().createRole().setPermissions(Permission.EMPTY_PERMISSIONS).setColor(Color.GRAY).setName(args[1]).setHoisted(true).queue();
            }
        } else {
            channel.sendMessage(" " + target.getUser().getAsMention() + " has been muted by: " + member.getUser().getAsMention() + "\nReason: " + reason).queue();
        }
    }
}
