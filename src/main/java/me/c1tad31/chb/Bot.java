package me.c1tad31.chb;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import me.c1tad31.chb.commands.HelpCommand;
import me.c1tad31.chb.commands.MoveVCCommand;
import me.c1tad31.chb.events.BotReadyEvent;
import me.c1tad31.chb.events.MessageEvent;
import me.c1tad31.chb.modcommands.BanCommand;
import me.c1tad31.chb.modcommands.KickCommand;
import me.c1tad31.chb.modcommands.MuteCommand;
import me.c1tad31.chb.modcommands.UnmuteCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class Bot {
    public static void main(String[] args) throws IOException, LoginException {
        //File file = new File("C:/Users/Carter/Desktop/ticket.txt");
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Bot.class.getResourceAsStream("config/token.txt")));
        String token;

        while ((token = bufferedReader.readLine()) != null) {

           
            Cipher cipher = null;
            try {
                String key = "ABCDFEGHIJKLMNOP";
                Key aesKey = new SecretKeySpec(key.getBytes(), "AES");

                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                byte[] encrypted = cipher.doFinal(token.getBytes());
                
                StringBuilder sb = new StringBuilder();
                for(byte b : encrypted) {
                    sb.append((char)b);
                }
                String enc = sb.toString();
                
                byte[] bb = new byte[enc.length()];
                for(int i = 0; i < enc.length(); i++) {
                    bb[i] = (byte) enc.charAt(i);
                }

                cipher.init(Cipher.DECRYPT_MODE, aesKey);

                System.out.println();

                JDA jda = JDABuilder.createDefault(new String(cipher.doFinal(bb))).build();
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
    
    
                CommandClient client = commandClientBuilder.build();
                jda.addEventListener(client);
               // jda.addEventListener(new MessageEvent());
                jda.addEventListener(new BotReadyEvent());

            } catch (Exception e) {
             
                e.printStackTrace();
            }

        }
        bufferedReader.close();
    }
}
