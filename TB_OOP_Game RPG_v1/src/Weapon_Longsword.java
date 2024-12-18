import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Weapon_Longsword extends SuperWeapon {

    private Connection con;
    private Statement stm;

    String url = "jdbc:mysql://localhost:3306/gamerpg";
    String user = "root";
    String pass = "";

    public Weapon_Longsword(int idW) {
        try {
            // Membuka koneksi ke database
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();

            String query = "SELECT weapon_name, damage FROM weapon WHERE id_weapon = " + idW;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                // Set nama dan damage weapon
                this.name = rs.getString("weapon_name");
                this.damage = rs.getInt("damage");
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
    public String getLongSword() {
        return this.name;
    }

    // Getter untuk damage weapon
    public int getLongSwordDmg() {
        return this.damage;
    }
}
