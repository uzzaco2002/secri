package maemesoft.db;

// 수정일 : 2013.07.30 23:01 (배틀관련수정)

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import maemesoft.RandomHelper;
import maemesoft.config.MaemeConfig;

public class DBMoves {
	public static boolean hasSTAB(String pokemonName, String attackName) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DBHelper.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select CanLearn from Pixelmon where Name='" + pokemonName + "'");
			while (rs.next()) {
				String movesString = rs.getString("CanLearn");
				String[] splits = movesString.split(";");
				for (String s : splits) {
					if (s.equalsIgnoreCase(attackName)) {
						if (s.startsWith("(s)"))
							return true;
						else
							return false;
					}
				}
			}
		} catch (Exception e) {

		}
		return false;
	}
}