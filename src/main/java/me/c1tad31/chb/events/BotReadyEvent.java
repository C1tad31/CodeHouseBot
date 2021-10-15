package me.c1tad31.chb.events;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotReadyEvent extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Bot Connected as: " + event.getJDA().getSelfUser().getAsTag());
        do {
            try {event.getJDA().getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("Over Code House"));} catch (Exception e) {e.printStackTrace();}
            try {Thread.sleep(5000);} catch (InterruptedException e1) {e1.printStackTrace();}
            try {event.getJDA().getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("My Development :)"));} catch (Exception e) {e.printStackTrace();}
            try {Thread.sleep(5000);} catch (InterruptedException e1) {e1.printStackTrace();}
            try {event.getJDA().getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.playing("Made By: Citadel#1829 & Carter_Rogers#0052"));} catch (Exception e) {e.printStackTrace();}
            try {Thread.sleep(5000);} catch (InterruptedException e1) {e1.printStackTrace();}
            try {event.getJDA().getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.playing("https://whitelightapp.com/"));} catch (Exception e) {e.printStackTrace();}
            try {Thread.sleep(5000);} catch (InterruptedException e1) {e1.printStackTrace();}
        } while (true);
    }
}
