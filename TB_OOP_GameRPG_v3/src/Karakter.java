
abstract class Karakter {
    protected String nama;
    protected int level;
    protected int health;
    protected int attackPower;
    protected String job;

    public Karakter(String nama, int level, String job) {
        this.nama = nama;
        this.level = level;
        this.job = job;
        this.health = 100;
        this.attackPower = 10;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void attackEnemy(String enemyName) {
        System.out.println(nama + " menyerang " + enemyName + " dengan kekuatan " + attackPower);
    }

    public void levelUp(){
        level++;
        health+= 20;
        attackPower+=5;
        System.out.println(nama+ " naik ke level "+ level + "!");
    }

    public void showCharacterStatus(){
        System.out.println("Nama: "+nama);
        System.out.println("Level: "+level);
        System.out.println("Job: " + job);
        System.out.println("Health: " +health);
        System.out.println("Attack Power: "+attackPower);
    }

    public abstract void specialAbility();
}
