package me.c1tad31.chb.codingcommands.C;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.utils.FileSender;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.Color;
import java.io.File;
import java.time.Instant;

public class CCodeTemplate extends Command {

    public CCodeTemplate() {
        this.name = "c-template";
        this.help = "Provides a starting template for a C console app";
    }

    @Override
    protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();

        EmbedBuilder cTemplateEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getAsTag(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle("C Starter Template")
            .setDescription("```c\n#include <stdio.h>\n#include <stdlib.h>\n\nint main(int argc, const char[] *argv) {\n\tprintf(\"Hello World!\");\n\treturn 0;\n}```")
            .setColor(Color.black)
            .setTimestamp(Instant.now())
            .setFooter("Made by Citadel");
        event.reply(cTemplateEmbed.build());
        File file = FileSender.sendFile("C\\main.c");
        event.reply(file, "main.c");
    }
    
}
