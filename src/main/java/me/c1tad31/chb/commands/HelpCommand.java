package me.c1tad31.chb.commands;

import java.util.List;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.name = "help";
        this.help = "Displays this help menu";
        this.aliases = new String[]{"?", "commands"};
    }

    @Override
    protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Message message = event.getMessage();

        Object text = event.getArgs();

        message.delete().queue();


        if (text instanceof String string) {
            channel.sendMessage(" " + string + " is a String").queue();
        }
    }
}
