public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config("jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false", "root", ""));
        }
        return adsDao;
    }
}
