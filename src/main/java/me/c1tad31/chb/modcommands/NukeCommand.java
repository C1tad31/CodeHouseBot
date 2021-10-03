package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;

public class NukeCommand extends Command {

    public NukeCommand() {
        this.name = "nuke";
        this.help = "nuke all message in a channel and start fresh";
        this.userPermissions = new Permission[]{Permission.MANAGE_CHANNEL, Permission.ADMINISTRATOR};
        this.botPermissions = new Permission[]{Permission.MANAGE_CHANNEL, Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(CommandEvent event) {
        event.getTextChannel().createCopy().queue(channel->channel.sendMessage(":warning:Nuked channel:warning:\nhttps://tenor.com/view/explosion-space-earth-gif-14405202").queue());
        event.getTextChannel().delete().queue();
    }
    
}
