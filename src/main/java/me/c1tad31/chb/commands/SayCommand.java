package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class SayCommand extends Command {

    public SayCommand() {
        this.name = "say";
        this.help = "say something";
    }

    @Override
    protected void execute(CommandEvent event) {
        Message message = event.getMessage();
        TextChannel channel = event.getTextChannel();

        message.delete().queue();

        channel.sendMessage(event.getArgs()).queue();
    }

}