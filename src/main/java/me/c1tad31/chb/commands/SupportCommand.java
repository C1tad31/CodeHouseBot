package me.c1tad31.chb.commands;

import java.awt.Color;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.utils.MessageEmbed;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class SupportCommand extends Command {

    public SupportCommand() {
        this.name = "support";
        this.help = "support the developers of this bot financially so we can keep improving the bot and keep it running";
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        String paypalLink = "https://paypal.me/C1tad31";
        Member member = event.getMember();
        TextChannel channel = event.getTextChannel();

        MessageEmbed.createEmbed(event, channel, member, "Support the Developers!", "If you like the project and would like to see how far it can go please feel free to donate anything you can to assist us in development and hosting costs, as the lead developer i will be taking on the responibilty of hosting this bot and attempting to make sure it stays up but anything you are willing to donate will be more then appreicated and welcomed in support of making this bot better!\n\nPayPal: " + paypalLink, "Developed by: Citadel#1829 and Carter_Rogers#0052", Color.decode("#000000"));
    }
    
}
