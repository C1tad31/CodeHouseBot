package me.c1tad31.chb.modcommands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.awt.Color;

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

        Role role = event.getGuild().getRolesByName("Muted", true).get(0);

        boolean found = false;
        for(Role r : event.getGuild().getRoles()) {
            if(r.getName().equalsIgnoreCase("Muted")) {
                found = true;
            }
        }

        if(!found) {
            channel.sendMessage("Muted role not found... Creating one now!");
            event.getGuild().createRole().setPermissions(Permission.EMPTY_PERMISSIONS).setColor(Color.GRAY).setName(args[1]).setHoisted(true).queue();
        }else {
            StringBuilder sb = new StringBuilder();

            if(args.length == 0)
                sb.append("NaN");
            else {
                
                for(int i = 1; i < args.length; i++) {
                    sb.append(args[i]);
                }

            }
            

            event.getGuild().addRoleToMember(target, role).queue();
            channel.sendMessage(" " + target.getUser().getAsMention() + " has been muted by: " + member.getUser().getAsMention() + "\nReason: " + sb.toString()).queue();
        }

    }
}
