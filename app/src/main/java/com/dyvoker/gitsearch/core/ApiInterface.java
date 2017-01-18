package com.dyvoker.gitsearch.core;

import java.util.List;

public interface ApiInterface {
    List<GitRepositoryInfo> getGitRepInfoList(String searchRequest, int from, int to);
}
