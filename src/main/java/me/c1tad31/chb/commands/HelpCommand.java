package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.name = "help";
        this.help = "Displays this help menu";
        this.aliases = new String[]{"?", "commands"};
    }

    @Override
    protected void execute(CommandEvent event) {

    }
}
