package me.c1tad31.chb.modcommands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.Bot;
import me.c1tad31.chb.CodeMonkey;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;

public class WarningCommands extends Command {

    public WarningCommands() {
        this.name = "warnings";
        this.help = "Displays a number and reason that a user was warned";
        this.aliases = new String[]{"checkwarn", "warncheck"};
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.guildOnly = true;
        this.cooldown = 10;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split("\\s");
        args[0] = "";  

        String member = event.getMember().getUser().getName();
        long memberId = event.getMember().getUser().getIdLong();

        for (CodeMonkey codeMonkey : Bot.code_monkeys) {
            if (codeMonkey.getUsername().equals(member)) {
                // Bot.code_monkeys.get(Bot.code_monkeys.indexOf(member))
                // EmbedBuilder warningEmbed = new EmbedBuilder()
                //     .setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl))
                //     .setTitle("Warnings for: " + member.getUser().getName())
                //     .setDescription(String.format("```%s```", ));
            }
        }
        

    }
}
