package com.dyvoker.gitsearch.core;

/**
 * Data Transfer Object for git repository
 */
public class GitRepository {
    public GitRepositoryOwner owner;
    public String full_name;
    public String description;

    public GitRepository(String avatarUrl, String fullName, String description) {
        GitRepositoryOwner newOwner = new GitRepositoryOwner();
        newOwner.avatar_url = avatarUrl;
        this.owner = newOwner;
        this.full_name = fullName;
        this.description = description;
    }
}
