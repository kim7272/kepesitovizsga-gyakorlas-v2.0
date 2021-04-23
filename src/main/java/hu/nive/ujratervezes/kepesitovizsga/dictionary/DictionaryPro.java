package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DictionaryPro {

    private DataSource dataSource;

    public DictionaryPro(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String hunWord) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select angol from words where magyar = ?");
        ) {
            stmt.setString(1, hunWord);

            String result = translateToEnglish(stmt);
            return result;

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("No such word in dictionary.", sqle);
        }
    }

        public String translateToEnglish(PreparedStatement stmt){
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            if (rs.next()) {
                String name = rs.getString("angol");
                return name;
            }
            throw new IllegalArgumentException("No such word in dictionary.");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("No such word in dictionary.", sqle);
        }

    }


    public String getHungarianWord(String engWord) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select magyar from words where angol = ?");
        ) {
            stmt.setString(1, engWord);
            String result = translateToHungarian(stmt);
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("No such word in dictionary.", sqle);
        }
    }

    public String translateToHungarian(PreparedStatement stmt){
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            if (rs.next()) {
                String name = rs.getString("magyar");
                return name;
            }
            throw new IllegalArgumentException("No such word in dictionary.");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("No such word in dictionary.", sqle);
        }
    }
}
