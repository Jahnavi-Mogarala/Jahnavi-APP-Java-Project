package com.jpquizbot.model;

public class LeaderboardEntry {
    private String user;
    private String displayName;
    private String category;
    private int score;
    private int total;
    private String timestamp;

    public LeaderboardEntry() {}

    // getters & setters
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
