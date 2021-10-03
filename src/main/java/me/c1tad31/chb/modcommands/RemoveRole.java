package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.awt.Color;
import java.util.List;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.Role;

public class RemoveRole extends Command {

    public RemoveRole() {
        this.name = "removerole";
        this.help = "Removes a role from a specified name";
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};

    }

	@Override
	protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        String[] args = event.getMessage().getContentRaw().split(" ");

        List<Role> role = event.getGuild().getRolesByName(args[1], true);

        for(Role r : role) {
            event.getGuild().removeRoleFromMember(member, r).queue();
        }
	}

}