package Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Main.KoneksiDatabase;

public class Monster extends SuperNPC {
    private KoneksiDatabase db = new KoneksiDatabase();

    private String nama_monster;
    private int attack;

    // Constructor untuk membuat objek Monster
    public Monster(int idMonster) {
        setMonsterName(idMonster);
        monsterHP(idMonster);
        monsterDMG(idMonster);
    }

    // Fungsi untuk mengambil nama monster berdasarkan id_monster
    public void setMonsterName(int idMonster) {
        try (Connection conn = db.getConnection()) {
            String query = "SELECT nama_monster FROM monster WHERE id_monster = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, idMonster);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        this.nama_monster = rs.getString("nama_monster");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Menentukan HP monster berdasarkan id_monster
    public void monsterHP(int idMonster) {
        switch (idMonster) {
            case 1: hp = 15; break;
            case 2: hp = 8; break;
            case 3: hp = 20; break;
            case 4: hp = 50; break;
            case 5: hp = 100; break;
            case 6: hp = 500; break;
            default: hp = 0; break;
        }
    }

    // Menentukan DMG monster berdasarkan id_monster
    public void monsterDMG(int idMonster) {
        switch (idMonster) {
            case 1: attack = 5; break;
            case 2: attack = 20; break;
            case 3: attack = 12; break;
            case 4: attack = 50; break;
            case 5: attack = 100; break;
            case 6: attack = 500; break;
            default: attack = 0; break;
        }
    }

    // Getter untuk nama monster
    public String getMonsterName() {
        return this.nama_monster;
    }

    // Getter untuk DMG monster
    public int getMonsterDMG() {
        return this.attack;
    }
}
