package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Npc {
    private Connection con;
    private Statement stm;
    private String nameNPC;


    // Koneksi Database
    String url = "jdbc:mysql://localhost:3306/tubespbo";
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

    // Fungsi untuk mengambil nama NPC berdasarkan id_npc
    public void setNpcName(int idNPC) {
        try {
            String query = "SELECT nama_npc FROM npc WHERE id_npc = " + idNPC;
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()) {
                this.nameNPC = rs.getString("nama_npc");
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

}