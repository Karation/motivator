package com.example.motivator.Model;

public class MiniSeriesDTO {
    private String progress;
    private int losses;
    private int target;
    private int wins;

    public MiniSeriesDTO() {
    }

    public MiniSeriesDTO(String progress, int losses, int target, int wins) {
        this.progress = progress;
        this.losses = losses;
        this.target = target;
        this.wins = wins;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
