package me.c1tad31.chb;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.c1tad31.chb.codingcommands.C.CCodeTemplate;
import me.c1tad31.chb.codingcommands.Java.JavaCodeTemplate;
import me.c1tad31.chb.codingcommands.Python.PythonCodeTemplate;
import me.c1tad31.chb.commands.*;
import me.c1tad31.chb.events.BotReadyEvent;
import me.c1tad31.chb.events.MemberJoinEvent;
import me.c1tad31.chb.events.MessageEvent;
import me.c1tad31.chb.modcommands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Bot {

    public static List<CodeMonkey> code_monkeys = new ArrayList<>();

    public static CodeMonkey getMonkey(String name) {
        for(CodeMonkey monkey : code_monkeys) {
            if(monkey.getUsername().equals(name)) {
                return monkey;
            }
        }

        return null;
    }

    public static int getMonkeyLocation(String name) {
        for(CodeMonkey monkey : code_monkeys) {
            if(monkey.getUsername().equals(name)) {
                return code_monkeys.indexOf(monkey);
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {

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
                commandClientBuilder.addCommand(new CreateRole());
                commandClientBuilder.addCommand(new AddRole());
                commandClientBuilder.addCommand(new RemoveRole());
                commandClientBuilder.addCommand(new JavaCodeTemplate());
                commandClientBuilder.addCommand(new PythonCodeTemplate());
                commandClientBuilder.addCommand(new CCodeTemplate());
                commandClientBuilder.addCommand(new PingCommand());
                commandClientBuilder.addCommand(new MemeCommand());


                CommandClient client = commandClientBuilder.build();
                jda.addEventListener(client);
                jda.addEventListener(new BotReadyEvent());
                jda.addEventListener(new MemberJoinEvent());
                jda.addEventListener(new MessageEvent());

            } catch (Exception e) {

                e.printStackTrace();
            }

        }
        bufferedReader.close();



    }
}
