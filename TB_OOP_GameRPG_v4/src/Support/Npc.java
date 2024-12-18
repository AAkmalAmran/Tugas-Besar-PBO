package Support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Main.KoneksiDatabase;

public class Npc extends SuperNPC{
    private String nameNPC;

    KoneksiDatabase db = new KoneksiDatabase();

    // Fungsi untuk mengambil nama NPC berdasarkan id_npc
    public void setNpcName(int idNPC) {
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT nama_npc FROM npc WHERE id_npc = ?")) {
            pstmt.setInt(1, idNPC);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    this.nameNPC = rs.getString("nama_npc");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getter untuk nama NPC
    public String getNpcName() {
        return this.nameNPC;
    }
}
