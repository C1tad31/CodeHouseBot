package me.c1tad31.chb.CurrencySystem;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.api.entities.Member;

public class XPSystem extends Command {

    HashMap<Member, Integer> playerXp = new HashMap<>();
    HashMap<Member, Integer> playerMessages = new HashMap<>();
    HashMap<Member, Integer> playerTimer = new HashMap<>();
    int counter = 0;

    public XPSystem() {
        this.name = "xp";
        this.help = "Displays a users XP";
    }

    @Override
    protected void execute(CommandEvent event) {
        if (canGetXp(event.getMember())) {
            if (event.getMember() == event.getMessage().getMember()){
                counter++;
                setPlayerMessages(event.getMember(),counter);
                randXp(event.getMember());
                setPlayerTime(event.getMember(), 3);
                event.getChannel().sendMessage("You have " + getPlayerXp(event.getMember()) + " xp " + "And " + getPlayerMessages(event.getMember()) + " Messages").queue();
            }

        } else {
            event.getChannel().sendMessage("You have " + getPlayerXp(event.getMember()) + " xp " + "And " + getPlayerMessages(event.getMember()) + " Messages").queue();
        }

    }

    private int getPlayerXp(Member member){
        return playerXp.get(member);
    }

    private int getPlayerMessages(Member member){
        return playerMessages.get(member);
    }

    private void setPlayerXp(Member member, int num){
        playerXp.put(member, num);
    }

    private void setPlayerMessages(Member member, int num){
        playerMessages.put(member, num);
    
    }
    private int getPlayerTime(Member member){
        return playerTimer.get(member);
    }

    private void setPlayerTime(Member member, int num){
        playerTimer.put(member,num);
    }

    private void randXp(Member member){
        Random r = new Random();
        if (!playerXp.containsKey(member)){
          setPlayerXp(member, 0);
        }
        setPlayerXp(member, getPlayerXp(member) + r.nextInt(25));
    }

    private boolean canGetXp(Member member){
        if(!playerTimer.containsKey(member)){
            return true;
        }
        return false;
    }

    public void startTimer(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (Member member : playerTimer.keySet()){

                    setPlayerTime(member,getPlayerTime(member) - 1);
                    if (getPlayerTime(member) == 0){
                        playerTimer.remove(member);
                    }
                }
            }
        };
        timer.schedule(task,1000,1000);
    }
}
