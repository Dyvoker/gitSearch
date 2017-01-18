package com.dyvoker.gitsearch.core;

import java.util.ArrayList;
import java.util.List;

public class TestApi implements ApiInterface {

    public static final ApiInterface Instance = new TestApi();

    @Override
    public List<GitRepositoryInfo> getGitRepInfoList(String searchRequest, int from, int to) {
        ArrayList<GitRepositoryInfo> gitReps = new ArrayList<>();
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user1/Application-One", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user2/Project-with-long-long-long-looooooooooong-name", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user3/Application-One", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user4/Application-One", "This is a test application fot Android 4.1 with very very very very very very very very very very very very very very very very very very very very loooooooooooong description"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user5/Application-One", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user6/Application-One", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user7/Application-One", "This is a test application fot Android 4.1"));
        gitReps.add(new GitRepositoryInfo("https://avatars3.githubusercontent.com/u/8245958", "user8/Application-One", "This is a test application fot Android 4.1"));
        return gitReps;
    }
}
