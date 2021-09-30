package me.c1tad31.chb;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.c1tad31.chb.commands.HelpCommand;
import me.c1tad31.chb.modcommands.BanCommand;
import me.c1tad31.chb.modcommands.KickCommand;
import me.c1tad31.chb.modcommands.MuteCommand;
import me.c1tad31.chb.modcommands.UnmuteCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.io.*;

public class Bot {
    public static void main(String[] args) throws IOException, LoginException {
        File file = new File("/home/citadel/CodingHouseBot/src/main/java/me/c1tad31/chb/config/token.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String token;

        while ((token = bufferedReader.readLine()) != null) {

            JDA jda = JDABuilder.createDefault(token).build();
            CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
            commandClientBuilder.setPrefix("-");
            commandClientBuilder.setHelpWord("helpme");
            commandClientBuilder.setOwnerId("892899456574435348");

            commandClientBuilder.addCommands(new HelpCommand());
            commandClientBuilder.addCommands(new KickCommand());
            commandClientBuilder.addCommands(new BanCommand());
            commandClientBuilder.addCommand(new MuteCommand());
            commandClientBuilder.addCommand(new UnmuteCommand());

            CommandClient client = commandClientBuilder.build();
            jda.addEventListener(client);
        }
        bufferedReader.close();
    }
}
