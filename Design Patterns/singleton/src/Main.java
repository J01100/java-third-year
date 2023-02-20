public class Main {
    public static void main(String[] args) {
        UserSession session = UserSession.getInstance();
        session.setUserName("Juan");

        session.logout();

        UserSession session2 = UserSession.getInstance();
        session2.setUserName("Peter");

    }
}