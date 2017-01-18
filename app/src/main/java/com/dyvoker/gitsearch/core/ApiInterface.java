package com.dyvoker.gitsearch.core;

import java.util.ArrayList;

public interface ApiInterface {
    ArrayList<GitRepositoryInfo> getGitRepInfoList(String searchRequest, int from, int to);
}
