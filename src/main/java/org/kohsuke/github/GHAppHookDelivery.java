package org.kohsuke.github;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.IOException;
import java.net.URL;

// TODO: Auto-generated Javadoc
/**
 * Represents a GitHub App webhook delivery.
 *
 * @see GHApp#listDeliveries()
 * @see GHApp#getDelivery(long)
 * @see <a href="https://docs.github.com/en/rest/apps/webhooks#list-deliveries-for-an-app-webhook">List deliveries for
 *      an app webhook</a>
 */
@SuppressFBWarnings(value = { "UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "UWF_UNWRITTEN_FIELD", "NP_UNWRITTEN_FIELD" },
        justification = "JSON API")
public class GHAppHookDelivery extends GHObject {

    private String action;

    private String deliveredAt;
    private double duration;
    private String event;
    private String guid;
    private String installationId;
    private boolean redelivery;
    private String repositoryId;
    private GHAppHookDeliveryRequest request;
    private GHAppHookDeliveryResponse response;
    private String status;
    private int statusCode;

    /**
     * Create default GHAppHookDelivery instance.
     */
    public GHAppHookDelivery() {
    }

    /**
     * Gets the action that triggered the delivery.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Gets the time when the webhook delivery was made.
     *
     * @return the delivered at timestamp
     */
    public String getDeliveredAt() {
        return deliveredAt;
    }

    /**
     * Gets the duration of the delivery in seconds.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets the event that triggered the delivery.
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Gets the unique identifier of the delivery.
     *
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Gets the app installation ID.
     *
     * @return the installation ID
     */
    public String getInstallationId() {
        return installationId;
    }

    /**
     * Gets the repository ID.
     *
     * @return the repository ID
     */
    public String getRepositoryId() {
        return repositoryId;
    }

    /**
     * Gets the full request that was sent with this delivery (only available in detailed delivery).
     *
     * @return the request, or null if not available
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHAppHookDeliveryRequest getRequest() {
        return request;
    }

    /**
     * Gets the full response for this delivery (only available in detailed delivery).
     *
     * @return the response, or null if not available
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHAppHookDeliveryResponse getResponse() {
        return response;
    }

    /**
     * Gets the status of the delivery.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the HTTP status code of the delivery response.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the URL.
     *
     * @return the URL
     */
    public URL getUrl() {
        return GitHubClient.parseURL("/app/hook/deliveries/" + getId());
    }

    /**
     * Whether this delivery is a redelivery.
     *
     * @return true if this is a redelivery
     */
    public boolean isRedelivery() {
        return redelivery;
    }

    /**
     * Redeliver this webhook delivery.
     *
     * @throws IOException
     *             if the redelivery fails
     * @see <a href="https://docs.github.com/en/rest/apps/webhooks#redeliver-a-delivery-for-an-app-webhook">Redeliver a
     *      delivery for an app webhook</a>
     */
    public void redeliver() throws IOException {
        root().createRequest()
                .method("POST")
                .withUrlPath("/app/hook/deliveries/" + getId() + "/attempts")
                .send();
    }

}
