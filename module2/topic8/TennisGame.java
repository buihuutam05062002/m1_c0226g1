package topic8;

public class TennisGame {

    private static final String[] SCORE_TEXT = {"Love", "Fifteen", "Thirty", "Forty"};

    private static String getEqualScore(int choice) {
        if (choice <= 3) {
            return SCORE_TEXT[choice] + "-All";
        }
        return "Dence";
    }

    private static String playerWinner(int Score1, int Score2, String player1, String player2) {
        int minusResult = Score1 - Score2;
        if (minusResult == 1) return "Adventure " + player1;
        else if (minusResult == -1) return "Adventure " + player2;
        else if (minusResult >= 2) return "Winner for " + player1;
        else return "winner for " + player2;

    }
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        if (m_score1 == m_score2) {
            return getEqualScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return playerWinner(m_score1, m_score2, player1Name, player2Name);
        } else {
            return SCORE_TEXT[m_score1] + " - " + SCORE_TEXT[m_score2];
        }
    }

    public static void main(String[] args) {
        System.out.println(getScore("tam","phung",9,11));
    }
}