import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Npc {
    private Connection con;
    private Statement stm;
    private int hp;
    private String weaponName;
    private String nameNPC;
    private String idNPC;

    // Koneksi Database
    String url = "jdbc:mysql://localhost:3306/gamerpg";
    String user = "root";
    String pass = "";

    // Constructor untuk membuat objek Player
    public Npc() {
        try {
            // Membuka koneksi ke database
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil data hp berdasarkan id_npc
    public void setNpcHp(int idNPC) {
        // this.idNPC = idNPC;
        try {
            String query = "SELECT hp FROM npc WHERE id_npc = " + idNPC;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.hp = rs.getInt("hp"); // Set hp berdasarkan data dari database
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengurangi HP NPC
    public void setNpcHp(int idNPC, int dmg) {
        try {
            String query = "SELECT hp FROM npc WHERE id_npc = " + idNPC;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.hp = rs.getInt("hp");

                // Mengurangi HP player berdasarkan damage
                this.hp -= dmg;

                // Cek apakah HP player tidak menjadi negatif
                if (this.hp < 0) {
                    this.hp = 0; // Jika HP negatif, set menjadi 0
                }

                // Update HP player ke database setelah dikurangi
                String updateQuery = "UPDATE npc SET hp = " + this.hp + " WHERE id_npc = " + idNPC;
                stm.executeUpdate(updateQuery);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil nama NPC berdasarkan id_npc
    public void setNpcName(int idNPC) {
        try {
            String query = "SELECT nama_npc FROM npc WHERE id_npc = " + idNPC;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.nameNPC = rs.getString("nama_npc"); // Set hp berdasarkan data dari database
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil nama weapon berdasarkan id_npc
    public void setWeaponName(Short idNPC) {
        try {
            String query = "SELECT w.weapon_name " +
                    "FROM npc n " +
                    "JOIN weapon w ON n.id_weapon = w.id_weapon " +
                    "WHERE n.id_npc = " + idNPC;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.weaponName = rs.getString("weapon_name"); // Menyimpan nama weapon
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk nama NPC
    public String getNpcName() {
        return this.nameNPC;
    }

    // Getter untuk hp NPC
    public int getNpcHp() {
        return this.hp;
    }

}