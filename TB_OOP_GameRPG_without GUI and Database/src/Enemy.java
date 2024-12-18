public class Enemy extends Karakter {
    private int enemyLevel;

    public Enemy(String nama, int level, int enemyLevel) {
        super(nama, enemyLevel, nama);
        this.enemyLevel = enemyLevel;
    }

    @Override
    public void attackEnemy(String enemyName) {
        super.attackEnemy(enemyName);
        System.out.println(nama + " menyerang " + enemyName + " dengan kekuatan " + (attackPower + enemyLevel));
    }

    @Override
    public void specialAbility() {
        System.out.println(nama+" mengguankan kemampuan khusus: Self-Destruct!");
        System.out.println(nama+ " menyerang dirinya sendiri dnegan kekuatan maksimum!");
        System.out.println(nama+ " mengorbankan diri dalam pertarungan!");

    }
}
