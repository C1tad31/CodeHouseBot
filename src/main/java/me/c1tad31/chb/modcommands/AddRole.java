package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.Color;
import java.util.List;

public class AddRole extends Command {
    
    public AddRole() {
        this.name = "addrole";
        this.help = "Adds a role to a specified user";
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
    }

	@Override
	protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        String[] args = event.getMessage().getContentRaw().split(" ");

        List<Role> role = event.getGuild().getRolesByName(args[1], true);

        for(Role r : role) {
            event.getGuild().addRoleToMember(member, r).queue();
        }
     
	}

}