package me.c1tad31.chb;

public class CodeMonkey {

    String username;
    long id;
    String warnReason;
    int numberOfOffenses;

    public CodeMonkey(String username, long id, String warnReason, int numberOfOffenses) {
        this.username = username;
        this.id = id;
        this.warnReason = warnReason;
        this.numberOfOffenses = numberOfOffenses;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getID() {
        return id;
    }

    public void setWarnReason(String warnReason) {
        this.warnReason = warnReason;
    }

    public String warnReason() {
        return warnReason;
    }

    public void setNumberOfOffenses(int numberOfOffenses) {
        this.numberOfOffenses = numberOfOffenses;
    }

    public int getNumberOfOffenses() {
        return numberOfOffenses;
    }

}
