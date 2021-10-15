package me.c1tad31.chb.events;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] message = event.getMessage().getContentRaw().split(" ");
        
        // for (int i = 0; i < message.length; i++) {
        //     if (message[i].equalsIgnoreCase("fuck") || message[i].equalsIgnoreCase("damn")){
        //         String messageId = event.getChannel().getLatestMessageId();
        //         event.getChannel().deleteMessageById(messageId).queue();
        //         event.getChannel().sendMessage(event.getMember().getAsMention() + " Dont Use that Language!").queue();
        //     }
        // }
    
    }
    
}
