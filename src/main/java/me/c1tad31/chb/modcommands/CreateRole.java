package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.awt.Color;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class CreateRole extends Command {

    public CreateRole() {
        this.name = "createrole";
        this.help = "Create a role with a specified name";
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};

    }

	@Override
	protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        String[] args = event.getMessage().getContentRaw().split(" ");

        event.getGuild().createRole().setPermissions(Permission.ADMINISTRATOR).setColor(Color.GRAY).setName(args[1]).setHoisted(true).queue();

	}

}