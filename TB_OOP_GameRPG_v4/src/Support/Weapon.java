package Support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Weapon extends SuperWeapon {

    private Connection con;
    private Statement stm;

    String url = "jdbc:mysql://localhost:3306/tubespbo";
    String user = "root";
    String pass = "";

    public Weapon(int idW) {
        try {
            // Membuka koneksi ke database
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();

            // Ambil data weapon sekaligus (name dan damage)
            String query = "SELECT id_weapon, nama_weapon, Damage FROM weapon WHERE id_weapon = " + idW;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                // Set nama dan damage weapon
                this.id = rs.getInt("id_weapon");
                this.name = rs.getString("nama_weapon");
                this.damage = rs.getInt("Damage");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null)
                    stm.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Getter untuk nama weapon
    public String getWeapon() {
        return this.name;
    }

    // Getter untuk damage weapon
    public int getWeaponDmg() {
        return this.damage;
    }
    // Getter untuk id weapon  
    public int getWeaponID() {
        return this.id;
    }
}
