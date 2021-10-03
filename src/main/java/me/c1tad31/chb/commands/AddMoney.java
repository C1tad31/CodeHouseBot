package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class AddMoney extends Command {

    public AddMoney() {
        this.name = "add";
        this.help = "Adds Money to a specifed users account";
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {

    }
    
}
