package com.dyvoker.gitsearch.core;

import java.util.ArrayList;

public class TestApi implements ApiInterface {

    public static final ApiInterface Instance = new TestApi();

    @Override
    public ArrayList<GitRepositoryInfo> getGitRepInfoList(String searchRequest, int from, int to) {
        ArrayList<GitRepositoryInfo> gitReps = new ArrayList<>();
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user1/Application-One", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user2/Project-with-long-long-long-looooooooooong-name", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user3/Application-One", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user4/Application-One", "This is a test application fot Android with very very very very very very very very very very very very very very very very very very very very loooooooooooong description"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user5/Application-One", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user6/Application-One", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user7/Application-One", "This is a test application fot Android"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user8/Application-One", "This is a test application fot Android"));
        return gitReps;
    }
}
