package me.c1tad31.chb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import me.c1tad31.chb.CurrencySystem.XPSystem;
import me.c1tad31.chb.commands.HelpCommand;
import me.c1tad31.chb.commands.MoveVCCommand;
import me.c1tad31.chb.commands.SayCommand;
import me.c1tad31.chb.commands.SupportCommand;
import me.c1tad31.chb.events.BotReadyEvent;
import me.c1tad31.chb.events.MemberJoinEvent;
import me.c1tad31.chb.modcommands.BanCommand;
import me.c1tad31.chb.modcommands.ClearCommand;
import me.c1tad31.chb.modcommands.KickCommand;
import me.c1tad31.chb.modcommands.MuteCommand;
import me.c1tad31.chb.modcommands.NukeCommand;
import me.c1tad31.chb.modcommands.UnmuteCommand;
import me.c1tad31.chb.modcommands.WarnCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;


public class Bot {

    public static List<CodeMonkey> code_monkeys = new ArrayList<>();

    public static void main(String[] args) throws IOException, LoginException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Bot.class.getResourceAsStream("config/token.txt")));
        String token;

        while ((token = bufferedReader.readLine()) != null) {

           
            Cipher cipher = null;
            try {
                String key = "ABCDFEGHIJKLMNOP";
                Key aesKey = new SecretKeySpec(key.getBytes(), "AES");

                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, aesKey);

                byte[] decodeKey = Base64.getDecoder().decode(token);

                JDA jda = JDABuilder.createDefault(new String(cipher.doFinal(decodeKey))).build();
                CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
                commandClientBuilder.setPrefix("-");
                commandClientBuilder.setHelpWord("helpme");
                commandClientBuilder.setOwnerId("892899456574435348");
    
                commandClientBuilder.addCommands(new HelpCommand());
                commandClientBuilder.addCommands(new KickCommand());
                commandClientBuilder.addCommands(new BanCommand());
                commandClientBuilder.addCommand(new MuteCommand());
                commandClientBuilder.addCommand(new UnmuteCommand());
                commandClientBuilder.addCommand(new MoveVCCommand());
                commandClientBuilder.addCommand(new WarnCommand());
                commandClientBuilder.addCommand(new SayCommand());
                commandClientBuilder.addCommand(new SupportCommand());
                commandClientBuilder.addCommand(new ClearCommand());
                commandClientBuilder.addCommand(new NukeCommand());
                commandClientBuilder.addCommand(new XPSystem());
                    
    
                CommandClient client = commandClientBuilder.build();
                jda.addEventListener(client);
               // jda.addEventListener(new MessageEvent());
                jda.addEventListener(new BotReadyEvent());
                jda.addEventListener(new MemberJoinEvent());

                XPSystem system = new XPSystem();
                system.startTimer();

            } catch (Exception e) {
             
                e.printStackTrace();
            }

        }
        bufferedReader.close();
    }
}
