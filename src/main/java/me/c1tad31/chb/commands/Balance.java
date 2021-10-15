package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Balance extends Command {

    public Balance() {
        this.name = "balence";
        this.help = "Displays the amount of money a user has";
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        // TODO Auto-generated method stub
        
    }
    
}
