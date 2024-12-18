package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Support.SuperWeapon;

public class Player {
    private String playerName;
    private int idWeapon;
    public int hp;
    public SuperWeapon currentWeapon;

    private KoneksiDatabase db = new KoneksiDatabase();

    // Constructor
    public Player() {
        this.hp = 100; // Default HP
    }

    // Fungsi untuk mengambil atau membuat player berdasarkan nama
    public void setPlayerName(String playerName) {
        try (Connection conn = db.getConnection()) {
            // Cek apakah player sudah ada di database
            String query = "SELECT nama_player FROM player WHERE nama_player = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, playerName);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        this.playerName = rs.getString("nama_player");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk nama player
    public String getPlayerName() {
        return this.playerName;
    }

    // Fungsi untuk mengambil id_weapon berdasarkan nama player
    public void setIdWeapon(String playerName) {
        try (Connection conn = db.getConnection()) {
            String query = "SELECT id_weapon FROM player WHERE nama_player = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, playerName);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        this.idWeapon = rs.getInt("id_weapon");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk id_weapon
    public int getIdWeapon() {
        return this.idWeapon;
    }

    // Fungsi untuk menghapus karakter berdasarkan nama player
    public void deletePlayerByName(String playerName) {
        try (Connection conn = db.getConnection()) {
            String deleteQuery = "DELETE FROM player WHERE nama_player = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setString(1, playerName);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Player with name '" + playerName + "' has been deleted.");
                    if (playerName.equals(this.playerName)) {
                        this.playerName = null; // Reset nama player di instance
                    }
                } else {
                    System.out.println("Player with name '" + playerName + "' does not exist.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPlayer(String playerName) {
        try (Connection conn = db.getConnection()) {
            // Query untuk menambahkan player baru
            String insertQuery = "INSERT INTO player (nama_player, id_weapon) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, playerName); // Nama player
                pstmt.setInt(2, 1); // Default id_weapon, misalnya 1 (bisa diubah sesuai kebutuhan)
    
                int rowsInserted = pstmt.executeUpdate();
    
                if (rowsInserted > 0) {
                    System.out.println("Player '" + playerName + "' berhasil ditambahkan ke database.");
                    this.playerName = playerName; // Set nama player ke instance
                } else {
                    System.out.println("Gagal menambahkan player '" + playerName + "' ke database.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
