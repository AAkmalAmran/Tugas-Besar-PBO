package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Monster extends SuperMonster {
    private Connection con;
    private Statement stm;



    // Koneksi Database
    String url = "jdbc:mysql://localhost:3306/tubespbo";
    String user = "root";
    String pass = "";

    // Constructor untuk membuat objek Player
    public Monster(int idMonster) {
        try {
            // Membuka koneksi ke database
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            setMonsterName(idMonster);
            monsterHP(idMonster);
            monsterDMG(idMonster);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil nama monster berdasarkan id_monster
    public void setMonsterName(int idMonster) {
        try {
            String query = "SELECT nama_monster FROM monster WHERE id_monster = " + idMonster;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.nama_monster = rs.getString("nama_monster");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Membuat hp pada setiap monsternya
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

    // Membuat hp pada setiap monsternya
    public void monsterDMG(int idMonster) {
        switch (idMonster) {
            case 1:
                attack = 5;
                break;
            case 2:
                attack = 20;
                break;
            case 3:
                attack = 12;
                break;
            case 4:
                attack = 50;
                break;
            case 5:
                attack = 100;
                break;
            case 6:
                attack = 500;
                break;
            default:
                attack = 0;
                break;
        }
    }

    // Getter untuk nama NPC
    public String getMonsterName() {
        return this.nama_monster;
    }

    // Getter untuk HP monster
    public int getMonsterHP() {
        return this.hp;
    }

    // Getter untuk DMG monster
    public int getMonsterDMG() {
        return this.attack;
    }

    public void closeConnection() {
        try {
            if (stm != null)
                stm.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
