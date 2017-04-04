package bg.cloudvps.naskodaskalov.scorekeeperapp;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.w3c.dom.Text;
import static android.R.attr.start;
import static android.R.attr.y;
import static bg.cloudvps.naskodaskalov.scorekeeperapp.R.id.home;
import static bg.cloudvps.naskodaskalov.scorekeeperapp.R.id.nameTeamA;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int yellowCardsTeamA = 0;
    int yellowCardsTeamB = 0;
    int redCardsTeamA = 0;
    int redCardsTeamB = 0;
    int cornersTeamA = 0;
    int cornersTeamB = 0;

    public void initializePogressBar() {
        setContentView(R.layout.activity_main);
        final LinearLayout homeView = (LinearLayout) findViewById(R.id.home_layout);
        final ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressBar4);

        progressbar.setVisibility(View.VISIBLE);
        progressbar.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressbar.setVisibility(View.INVISIBLE);
                homeView.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializePogressBar();
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main);
        initializePogressBar();
    }

    public void goBack(View v) {
        setContentView(R.layout.activity_main);
        initializePogressBar();
    }
    public void showFootballLayout(View v) {
        EditText nameTeamA = (EditText) findViewById(R.id.nameTeamA);
        String nameOfTeamA = nameTeamA.getText().toString();

        EditText nameTeamB = (EditText) findViewById(R.id.nameTeamB);
        String nameOfTeamB = nameTeamB.getText().toString();

        scoreTeamA = 0;
        scoreTeamB = 0;
        yellowCardsTeamA = 0;
        yellowCardsTeamB = 0;
        redCardsTeamB = 0;
        redCardsTeamA = 0;
        cornersTeamA = 0;
        cornersTeamB = 0;

        setContentView(R.layout.football);

        displayGoalsForTeamA(scoreTeamA);
        displayGoalsForTeamB(scoreTeamB);
        displayYellowCardsForTeamA(yellowCardsTeamA);
        displayYellowCardsForTeamB(yellowCardsTeamB);
        displayRedCardsForTeamA(redCardsTeamA);
        displayRedCardsForTeamB(redCardsTeamB);
        displayCornersForTeamA(cornersTeamA);
        displayCornersForTeamB(cornersTeamB);

        TextView teamA = (TextView) findViewById(R.id.teamA_name);
        teamA.setText(nameOfTeamA);

        TextView teamB = (TextView) findViewById(R.id.teamB_name);
        teamB.setText(nameOfTeamB);

    }

    /*
   * Here are the functions for goals for both teams:
   */
    public void displayGoalsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayGoalsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addNewGoalTeamA(View v) {
        scoreTeamA++;
        displayGoalsForTeamA(scoreTeamA);
    }

    public void addNewGoalTeamB(View v) {
        scoreTeamB++;
        displayGoalsForTeamB(scoreTeamB);
    }

    /*
    * Here are the functions for yellow cards for both teams:
    */
    public void displayYellowCardsForTeamA(int yellowCards) {
        TextView yellowCardsView = (TextView) findViewById(R.id.team_a_yellow_cards);
        yellowCardsView.setText(String.valueOf(yellowCards));
    }

    public void addNewYellowCardTeamA(View v) {
        yellowCardsTeamA++;
        displayYellowCardsForTeamA(yellowCardsTeamA);
    }

    public void displayYellowCardsForTeamB(int yellowCards) {
        TextView yellowCardsView = (TextView) findViewById(R.id.team_b_yellow_cards);
        yellowCardsView.setText(String.valueOf(yellowCards));
    }

    public void addNewYellowCardTeamB(View v) {
        yellowCardsTeamB++;
        displayYellowCardsForTeamB(yellowCardsTeamB);
    }

    /*
    * Here are the functions for red cards for both teams:
    */
    public void displayRedCardsForTeamA(int redCrds) {
        TextView yellowCardsView = (TextView) findViewById(R.id.team_a_red_cards);
        yellowCardsView.setText(String.valueOf(redCrds));
    }

    public void addNewRedCardTeamA(View v) {
        redCardsTeamA++;
        displayRedCardsForTeamA(redCardsTeamA);
    }

    public void displayRedCardsForTeamB(int redCards) {
        TextView yellowCardsView = (TextView) findViewById(R.id.team_b_red_cards);
        yellowCardsView.setText(String.valueOf(redCards));
    }

    public void addNewRedCardTeamB(View v) {
        redCardsTeamB++;
        displayRedCardsForTeamB(redCardsTeamB);
    }


    /*
    * Here are the functions for corners for both teams:
    */
    public void displayCornersForTeamA(int corner) {
        TextView cornersView = (TextView) findViewById(R.id.corners_team_a);
        cornersView.setText(String.valueOf(corner));
    }

    public void addNewCornerTeamA(View v) {
        cornersTeamA++;
        displayCornersForTeamA(cornersTeamA);
    }

    public void displayCornersForTeamB(int corner) {
        TextView cornersView = (TextView) findViewById(R.id.corners_team_b);
        cornersView.setText(String.valueOf(corner));
    }

    public void addNewCornerTeamB(View v) {
        cornersTeamB++;
        displayCornersForTeamB(cornersTeamB);
    }

    /*
    * Reset button
     */

    public void finishGame(View v) {
        String teamWinner;
        TextView winner;
        if (scoreTeamA > scoreTeamB) {
            winner = (TextView) findViewById(R.id.teamA_name);
            teamWinner = winner.getText().toString();
        } else if (scoreTeamA < scoreTeamB) {
            winner = (TextView) findViewById(R.id.teamB_name);
            teamWinner = winner.getText().toString();
        } else {
            teamWinner = "No winner!";
        }

        TextView firstTeam = (TextView) findViewById(R.id.team_a_score);
        TextView secondTeam = (TextView) findViewById(R.id.team_b_score);

        setContentView(R.layout.finish_football_game);

        TextView matchWinner = (TextView) findViewById(R.id.winner_of_the_match);
        matchWinner.setText(teamWinner);

        TextView resultMatch = (TextView) findViewById(R.id.final_result);
        resultMatch.setText(firstTeam.getText().toString() + ':' + secondTeam.getText().toString());
    }
}
