import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {

    private Connection connection;
    private List<Ad> albums = new ArrayList<>();


    public MySQLAdsDao(Config config) {
//        Config config = new Config("jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false", "luis_ad", "codeup");
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()

            );
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Ad> all() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ads");
            while (rs.next()) {
                albums.add(
                        new Ad(
                                rs.getInt("id"),
                                rs.getInt("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return albums;
    }

    public Long insert(Ad ad){
        long userId = ad.getUserId();
        String description = ad.getDescription();
        String title = ad.getTitle();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(String.format("INSERT INTO ads (title, description, user_id) values ('%s', '%s', 1)", title, description));
        } catch(SQLException e){
            System.out.println(e);
        }
        return userId;
    }


}
