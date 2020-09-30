public class Health {
    private int hp;
    public int getHealth() {
        return hp;
    }
    public void setHealth(int health) {
        this.hp = health;
    }
    public Health() {
        hp = 100;
    }
    public int healthChange(int health, int change){
		health += change;
		return health;
	}
    @Override
    public String toString(){
        return String.format("%d", hp);
    }
}
