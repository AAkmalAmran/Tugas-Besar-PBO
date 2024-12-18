public class Player extends Karakter {
    private int experience;

    public Player(String nama, int level, String job) {
        super(nama, level, job);
        this.experience = 0;
    }

    public void gainExperience(int experiencePoints) {
        experience += experiencePoints;
        System.out.println(nama + " mendapatkan " + experiencePoints + " poin pengalaman");
    }

    @Override
    public void showCharacterStatus() {
        super.showCharacterStatus();
        super.levelUp();
        System.out.println("Experience: " + experience);
    }

    @Override
    public void specialAbility() {
        if (job.equalsIgnoreCase("Hage")) {
            System.out.println(nama + " menggunakan kemampuan khusus: Fireball!");
            System.out.println("Musuh terkena serangan Fireball dan menerima 20 poin kerusakan tambahan");
        } else if (job.equalsIgnoreCase("Warior")) {
            System.out.println(nama + " mengguankan kemampuan khusus: Power Strike!");
            System.out.println("Seranganmu lebih kuat dan musuh menerima 15 poin kerusakan tambahan");
        }
    }

}
