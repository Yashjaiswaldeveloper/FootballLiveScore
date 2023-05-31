package com.livetv.footballscore.livescores.service;

import android.os.Handler;
import com.livetv.footballscore.livescores.model.Commentary;
import com.livetv.footballscore.livescores.model.CountryLeague;
import com.livetv.footballscore.livescores.model.FeedAppStart;
import com.livetv.footballscore.livescores.model.MatchDetails;
import com.livetv.footballscore.livescores.model.MatchSummary;
import com.livetv.footballscore.livescores.model.News;
import com.livetv.footballscore.livescores.model.Player;
import com.livetv.footballscore.livescores.model.PointTable;
import com.livetv.footballscore.livescores.model.Team;
import com.loopj.android.http.AsyncHttpClient;
import java.util.List;

public class NetworkService {
    private AsyncHttpClient httpClient = new AsyncHttpClient();

    public void fetchLiveNow(Handler handler) {
        this.httpClient.get("http://static.holoduke.nl/footapi/fixtures/feed_livenow.json", new DefaultAsyncHttpResponseHandler(handler, CountryLeague.class, List.class));
    }

    public void fetchPlayerCareer(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://static.holoduke.nl/footapi/players/" + str + ".json", new DefaultAsyncHttpResponseHandler(handler, Player.class));
    }

    public void fetchTeamDetails(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://static.holoduke.nl/footapi/team_gs/" + str + ".json", new DefaultAsyncHttpResponseHandler(handler, Team.class));
    }

    public void fetchMatchDetails(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://holoduke.nl/footapi/matches/" + str + ".json", new DefaultAsyncHttpResponseHandler(handler, MatchDetails.class));
    }

    public void fetchCommentry(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://holoduke.nl/footapi/commentaries/" + str + ".json", new DefaultAsyncHttpResponseHandler(handler, Commentary.class));
    }

    public void fetchLeagueSchedule(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://static.holoduke.nl/footapi/fixtures/" + str + "_small.json", new DefaultAsyncHttpResponseHandler(handler, MatchSummary.class, List.class));
    }

    public void fetchLeagueStandings(String str, Handler handler) {
        AsyncHttpClient asyncHttpClient = this.httpClient;
        asyncHttpClient.get("http://static.holoduke.nl/footapi/tables/" + str + ".json", new DefaultAsyncHttpResponseHandler(handler, PointTable.class));
    }

    public void fetchNewsList(Handler handler) {
        this.httpClient.get("http://static.holoduke.nl/footapi/news/US.json", new DefaultAsyncHttpResponseHandler(handler, News.class));
    }

    public void fetchFeedAppStart(Handler handler) {
        this.httpClient.get("http://static.holoduke.nl/footapi/fixtures/feed_appstart.json", new DefaultAsyncHttpResponseHandler(handler, FeedAppStart.class));
    }
}
