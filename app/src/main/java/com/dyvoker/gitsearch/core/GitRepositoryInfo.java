package com.dyvoker.gitsearch.core;

public class GitRepositoryInfo {
    public String userPic;
    public String fullName;
    public String repoDescription;

    public GitRepositoryInfo(String userPic, String fullName, String repoDescription) {
        this.userPic = userPic;
        this.fullName = fullName;
        this.repoDescription = repoDescription;
    }
}
