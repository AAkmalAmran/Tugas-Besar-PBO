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
            case 1:
                hp = 15;
                break;
            case 2:
                hp = 8;
                break;
            case 3:
                hp = 20;
                break;
            case 4:
                hp = 50;
                break;
            case 5:
                hp = 100;
                break;
            case 6:
                hp = 500;
                break;
            default:
                hp = 0;
                break;
        }
    }

    // Menentukan DMG monster berdasarkan id_monster
    
    public void monsterDMG(int idMonster) {
        attack = getWeaponDamage(idMonster);
    }

    public int getWeaponDamage(int idMonster) {
        String query = "SELECT w.damage " +
                "FROM monster m " +
                "JOIN weapon w ON m.id_weapon = w.id_weapon " +
                "WHERE m.id_monster = ?";

        int damage = 0; // Default nilai damage

        try (Connection conn = db.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Set parameter
            pstmt.setInt(1, idMonster);

            // Eksekusi query
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    damage = rs.getInt("damage"); // Ambil nilai damage
                } else {
                    System.out.println("No weapon found for player with ID: " + idMonster);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return damage;
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
