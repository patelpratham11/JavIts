
public class Boss {
    private String name;
    private double health;
    private float reward;

    public Boss(String name, double health, float reward){
        // read information
    }

    public String getName(){
        return this.name;
    }

    public float getReward(){
        return this.reward;
    }

    public double getHealth(){
        return this.health;
    }

    public void damage(double amtDamage){
        this.health -= amtDamage;
        this.write();
    }

    public boolean isFinished(){
        return this.health > 0 ? false : true;
    }

    private void write(){
        // 
    }
}
