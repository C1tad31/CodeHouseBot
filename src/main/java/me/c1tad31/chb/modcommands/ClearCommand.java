package me.c1tad31.chb.modcommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.requests.RestAction;

public class ClearCommand extends Command {

    public ClearCommand() {
        this.name = "clear";
        this.help = "Clear messages from the chat";
        this.aliases = new String[]{"c", "purge", "cls"};
        this.guildOnly = true;
        this.userPermissions = new Permission[]{Permission.MANAGE_CHANNEL, Permission.ADMINISTRATOR};
        this.botPermissions = new Permission[]{Permission.MANAGE_CHANNEL, Permission.ADMINISTRATOR};
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        if (args.length < 1 || args.length > 100) {
            event.getChannel().sendMessage("Amount must be between 1 and 100").complete().delete().queueAfter(10, TimeUnit.SECONDS);
        } else {
            clearMessages(event, Integer.parseInt(args[1]));
        }
    }

    private void clearMessages(CommandEvent event, int num) {
        List<Message> messages = event.getChannel().getHistory().retrievePast(num).complete();
        ((RestAction<List<Message>>) event.getChannel().purgeMessages(messages)).queue();
        event.getChannel().sendMessage(" " + num + " messages has been deleted!").queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
    }
}
