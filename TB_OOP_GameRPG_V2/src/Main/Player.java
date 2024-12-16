package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Support.SuperWeapon;

public class Player {
    private Connection con;
    private Statement stm;

    private String playerName;

    public int hp;
    public SuperWeapon currentWeapon;

    // Koneksi Database
    String url = "jdbc:mysql://localhost:3306/tubespbo";
    String user = "root";
    String pass = "";

    public Player() {
        try {
            // Membuka koneksi ke database
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fungsi untuk mengambil nama player berdasarkan nama_player
    public void setPlayerName(String playerName) {
        try {
            String query = "SELECT nama_player FROM player WHERE nama_player = '" + playerName + "'";
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.playerName = rs.getString("nama_player");
            } else {
                System.out.println("Player dengan nama '" + playerName + "' tidak ditemukan.");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk nama player
    public String getPlayerName() {
        return this.playerName;
    }

    // Menutup koneksi database
    public void closeConnection() {
        try {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
