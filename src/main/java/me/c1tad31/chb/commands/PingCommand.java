package me.c1tad31.chb.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PingCommand extends Command {

    public PingCommand() {
        this.name = "ping";
        this.help = "Displays Bot Ping Latency";
    }

    @Override
    protected void execute(CommandEvent event) {
        event.reply(String.format("Ping: %s", event.getJDA().getGatewayPing()));
    }
    
}
