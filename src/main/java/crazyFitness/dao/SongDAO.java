package crazyFitness.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.model.Song;
import io.github.cdimascio.dotenv.Dotenv;

public class SongDAO {

	

	public static Connection getConnection() throws SQLException {
		Connection connect = null;
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		try {

			connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail to connect to the database");
		}
		return connect;
	}

	public boolean CreateSong(Song song) throws DAOException {
		String insertQuery = "INSERT INTO song (song_id, song_name, song_image, song_url) VALUES(?,?,?,?)";
		String selectQuery = "SELECT song_id FROM song WHERE song_id = ?";
		try (Connection connect = getConnection();
				PreparedStatement selectPst = connect.prepareStatement(selectQuery);
				PreparedStatement insertPst = connect.prepareStatement(insertQuery)) {
			selectPst.setInt(1, song.getSong_id());
			ResultSet rs = selectPst.executeQuery();
			if (rs.next()) {
				rs.close();
				return false;
			}
			rs.close();

			insertPst.setInt(1, song.getSong_id());
			insertPst.setString(2, song.getSong_name());
			insertPst.setString(3, song.getSong_image());
			insertPst.setString(4, song.getSong_url());
			int rows = insertPst.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
