package me.c1tad31.chb.CurrencySystem;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.Bot;
import me.c1tad31.chb.CodeMonkey;

public class XPSystem extends Command {

    protected int tickCount = 0;

    public XPSystem() {
        this.name = "xp";
        this.help = "Displays a users XP";
    }

    @Override
    protected void execute(CommandEvent event) {
        if(Bot.getMonkey(event.getAuthor().getName()) != null) {
            Bot.code_monkeys.get(Bot.getMonkeyLocation(event.getAuthor().getName())).messages = Bot.code_monkeys.get(Bot.getMonkeyLocation(event.getAuthor().getName())).messages + 1;
        }else {
            CodeMonkey monkey = new CodeMonkey(event.getAuthor().getName(), event.getAuthor().getIdLong());
            Bot.code_monkeys.add(monkey);
        }

        CodeMonkey monkey = Bot.getMonkey(event.getAuthor().getName());

        event.getChannel().sendMessage(monkey.xp + " xp | " + monkey.messages + " Messages").queue();

    }

}
