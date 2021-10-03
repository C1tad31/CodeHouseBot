package me.c1tad31.chb.modcommands;

import java.awt.Color;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.Bot;
import me.c1tad31.chb.CodeMonkey;
import me.c1tad31.chb.utils.MessageEmbed;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.PermissionException;

public class WarnCommand extends Command{

    public WarnCommand() {
        this.name = "warn";
        this.help = "Warns a specified user in the server";
        this.aliases = new String[]{"w", "warn-user"};
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.botPermissions = new Permission[]{Permission.ADMINISTRATOR};
    }

    
    StringBuilder sb = new StringBuilder();

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split("\\s");
        args[0] = "";     

        Member warned = event.getMessage().getMentionedMembers().get(0);
        
        event.getMessage().delete().queue();

        String monkeyName = warned.getUser().getName();

        boolean found = false;
        for (CodeMonkey monkey : Bot.code_monkeys) {
            if(monkey.getUsername().equals(monkeyName)) {
                Bot.code_monkeys.get(Bot.code_monkeys.indexOf(monkey)).setNumberOfOffenses(Bot.code_monkeys.get(Bot.code_monkeys.indexOf(monkey)).getNumberOfOffenses() + 1);
                found = true;

                for(String s : args) {
                    sb.append(s + " ");
                }

                if(monkey.getNumberOfOffenses() + 1 > 3) {
                    try {
                        warned.kick().queue();
                        event.getChannel().sendMessage(warned.getUser().getName() + " Was Kicked.").queue();
                    } catch(PermissionException e) {
                        event.getChannel().sendMessage("I dont have the Perms to kick!").queue();
                        e.printStackTrace();
                    }
                }else {
                          
                    String warn = sb.toString();


                    warned.getUser().openPrivateChannel().queue((channel ->
                        MessageEmbed.createDMEmbed(event, channel, event.getMember(), "WARNING!", String.format("```%s```", warn), "Warning Count: " + monkey.getNumberOfOffenses(), Color.decode("#FFFFFF"))
                    ));

                    monkey.setNumberOfOffenses(monkey.getNumberOfOffenses() + 1);
    
                }
             

                break;
            }
        }



        if (!found) {
            CodeMonkey newMonkee = new CodeMonkey(monkeyName, warned.getIdLong(), "test warning", 1);
            Bot.code_monkeys.add(newMonkee);

            for(String s : args) {
                sb.append(s + " ");
            }
            
            String warn = sb.toString();

            warned.getUser().openPrivateChannel().queue((channel ->
                MessageEmbed.createDMEmbed(event, channel, event.getMember(), "WARNING!", String.format("```%s```", warn), "Warning Count: " + newMonkee.getNumberOfOffenses(), Color.decode("#FFFFFF"))
            ));

        }


        sb.setLength(0);
    }

}
