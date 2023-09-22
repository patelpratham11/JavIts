public class Reminder {
    private String reminder;
    private int difficulty;
    private boolean negative;
    private int streak;

    public Reminder(String reminder, int difficulty, boolean negative, int streak){
        this.reminder = reminder;
        this.difficulty = difficulty;
        this.negative = negative;
        this.streak = streak;
    }

    public String getReminder(){
        return this.reminder;
    }

    public int getDifficulty(){
        return this.difficulty;
    }

    public int getStreak(){
        return this.streak;
    }

    public boolean getNegative(){
        return this.negative;
    }

    public void increaseStreak(){
        this.streak += 1; 
    }

    public String toString(){
        return this.reminder+","+this.difficulty+","+this.negative+","+this.streak;
    }

    public String printString(){
        return this.reminder+"\t\t"+this.difficulty+"\t\t"+this.negative+"\t\t"+this.streak;
    }
}
