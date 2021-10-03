package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class RemoveMoney extends Command {

    public RemoveMoney() {
        this.name = "remove";
        this.help = "Removes Money from a specifed users account";
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {

    }
    
}
