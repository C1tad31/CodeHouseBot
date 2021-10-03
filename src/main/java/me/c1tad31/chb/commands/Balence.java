package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Balence extends Command {

    public Balence() {
        this.name = "balence";
        this.help = "Displays the amount of money a user has";
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        // TODO Auto-generated method stub
        
    }
    
}
