package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.concurrent.TimeUnit;

public class KickCommand extends Command {

    public KickCommand() {
        this.name = "kick";
        this.help = "Kick a specified user from the server";
        this.aliases = new String[]{"k", "remove"};
        this.userPermissions = new Permission[]{Permission.KICK_MEMBERS};
        this.botPermissions = new Permission[]{Permission.KICK_MEMBERS};
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        Message message = event.getMessage();
        Member target = event.getMessage().getMentionedMembers().get(0);
        StringBuilder reason = new StringBuilder();

        message.delete().queue();

        if (target == null) {
            channel.sendTyping().queue();
            channel.sendMessage("Please Specify a member kick!").complete().delete().queueAfter(10, TimeUnit.SECONDS);
        }

        if (args.length < 3) {
            channel.sendTyping().queue();
            channel.sendMessage("Usage: .kick <@member> <reason>").complete().delete().queueAfter(10, TimeUnit.SECONDS);
        }

        target.kick(reason.append(args[2]).toString()).queue();
        channel.sendMessage(" " + target.getAsMention() + " has been kicked by: " + member.getAsMention() + "\nReason: " + reason).complete().delete().queueAfter(10, TimeUnit.SECONDS);
    }
}
