package com.dyvoker.gitsearch.core;

/**
 * Interface for listener of search result
 */

public interface SearchListener {
    void onAllUpdated();
    void onPageLoad(GitRepositoryPage page);
}
