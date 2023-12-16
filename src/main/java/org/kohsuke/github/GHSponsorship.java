package org.kohsuke.github;

import java.io.IOException;
import java.net.URL;

public class GHSponsorship extends GHObject {

    protected String html_url;

    private GHUser sponsorable;
    private GHUser maintainer;
    private GHUser sponsor;
    private String privacyLevel;
    private Tier tier;


    @Override
    public URL getHtmlUrl() {
        return GitHubClient.parseURL(html_url);
    }
}
