package me.c1tad31.chb.codingcommands.Python;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.Color;
import java.time.Instant;

public class PythonCodeTemplate extends Command {

    public PythonCodeTemplate() {
        this.name = "python-template";
        this.help = "Provides a starting template for a python console app";
    }

    @Override
    protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();

        EmbedBuilder pythonTemplateEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getAsTag(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle("Python Starter Template")
            .setDescription("```python\ndef main():\n\tprint(\"Hello World!\")\n\nif __name__ == \"__main__\":\n\tmain()```")
            .setColor(Color.black)
            .setTimestamp(Instant.now())
            .setFooter("Made by Citadel");
        channel.sendMessage(pythonTemplateEmbed.build()).queue();
    }
    
}
