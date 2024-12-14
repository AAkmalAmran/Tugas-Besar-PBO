import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Player {
    private Connection con;
    private Statement stm;
    private int hp;
    private String weaponName;
    private String namePlayer;

    // Koneksi Database
    String url = "jdbc:mysql://localhost:3306/gamerpg";
    String user = "root";
    String pass = "";

    
        // Constructor untuk membuat objek Player
        public Player() {
            try {
                // Membuka koneksi ke database
                con = DriverManager.getConnection(url, user, pass);
                stm = con.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        // Fungsi untuk mengambil data hp berdasarkan id_player
        public void setHp(int idPlayer) {
            try {
                String query = "SELECT hp FROM player WHERE id_player = " + idPlayer;
                ResultSet rs = stm.executeQuery(query);
    
                if (rs.next()) {
                    this.hp = rs.getInt("hp"); // Set hp berdasarkan data dari database
                }
    
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        // Fungsi untuk mengambil nama weapon berdasarkan id_player
        public void setWeaponName(int idPlayer) {
            try {
                String query = "SELECT w.weapon_name " +
                        "FROM player p " +
                        "JOIN weapon w ON p.id_weapon = w.id_weapon " +
                        "WHERE p.id_player = " + idPlayer;
                ResultSet rs = stm.executeQuery(query);
    
                if (rs.next()) {
                    this.weaponName = rs.getString("weapon_name"); // Menyimpan nama weapon
                }
    
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        // Fungsi untuk mengambil nama player berdasarkan id_player
        public void setPlayerName(int idPlayer) {
            try {
                String query = "SELECT nama_player FROM player WHERE id_player = " + idPlayer;
                ResultSet rs = stm.executeQuery(query);
    
                if (rs.next()) {
                    this.namePlayer = rs.getString("nama_player"); // Set hp berdasarkan data dari database
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk nama player
    public String getPlayerName(){
        return this.namePlayer;
    }

    // Getter untuk nama weapon
    public String getWeaponName() {
        return this.weaponName;
    }

    // Getter untuk hp
    public int getHp() {
        return this.hp;
    }
}
