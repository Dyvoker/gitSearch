package com.dyvoker.gitsearch.core;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * Test Api
 */

public class TestGitApi implements GitApiInterface {
    @Override
    public Call<GitRepositoryPage> getPage(@Query("q") String query, @Query("page") int page) {
        GitRepository[] gitRepositories = new GitRepository[8];
        gitRepositories[0] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user1/Application-One", "This is a test application fot Android");
        gitRepositories[1] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user2/Project-with-long-long-long-looooooooooong-name", "This is a test application fot Android");
        gitRepositories[2] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user3/Application-One", "This is a test application fot Android");
        gitRepositories[3] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user4/Application-One", "This is a test application fot Android with very very very very very very very very very very very very very very very very very very very very loooooooooooong description");
        gitRepositories[4] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user5/Application-One", "This is a test application fot Android");
        gitRepositories[5] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user6/Application-One", "This is a test application fot Android");
        gitRepositories[6] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user7/Application-One", "This is a test application fot Android");
        gitRepositories[7] = new GitRepository("https://avatars3.githubusercontent.com/u/8245958", "user8/Application-One", "This is a test application fot Android");
        final GitRepositoryPage gitRepositoryPage = new GitRepositoryPage();
        gitRepositoryPage.items = gitRepositories;
        return new Call<GitRepositoryPage>() {

            @Override
            public Response<GitRepositoryPage> execute() throws IOException {
                return Response.success(gitRepositoryPage);
            }

            @Override
            public void enqueue(Callback<GitRepositoryPage> callback) {
                callback.onResponse(this, Response.success(gitRepositoryPage));
            }

            @Override
            public boolean isExecuted() {
                return true;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<GitRepositoryPage> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }
}
