package me.c1tad31.chb.codingcommands.Java;

import java.awt.Color;
import java.io.File;
import java.time.Instant;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import me.c1tad31.chb.utils.FileSender;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public class JavaCodeTemplate extends Command {

    public JavaCodeTemplate() {
        this.name = "java-template";
        this.help = "Provides a starting template for a java console app";
    }

    @Override
    protected void execute(CommandEvent event) {
        TextChannel channel = event.getTextChannel();
        Member member = event.getMember();
        

        EmbedBuilder javaTemplateEmbed = new EmbedBuilder()
            .setAuthor(member.getUser().getAsTag(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl())
            .setTitle("Java Starter Template")
            .setDescription("```java\npackage your.domain.name.projectname\n\npublic class Main {\n\tpublic static void main(String[] args) {\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}```")
            .setColor(Color.black)
            .setTimestamp(Instant.now())
            .setFooter("Made by Citadel");
        event.reply(javaTemplateEmbed.build());
        File file = FileSender.sendFile("Java\\Main.java");
        event.reply(file, "Main.java");
    }
    
}
