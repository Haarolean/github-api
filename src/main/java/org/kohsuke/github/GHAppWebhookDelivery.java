package org.kohsuke.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.kohsuke.github.internal.EnumUtils;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;

/**
 * Represents a webhook delivery for a GitHub App.
 *
 * @see <a href="https://docs.github.com/en/rest/apps/webhooks?apiVersion=2022-11-28#list-deliveries-for-an-app-webhook">
 *      List deliveries for an app webhook</a>
 */
public class GHAppWebhookDelivery extends GHObject {

    private String action;
    @JsonProperty("delivered_at")
    private String deliveredAt;
    private double duration;
    private String event;
    private String guid;
    @JsonProperty("installation_id")
    private Long installationId;
    private GHAppWebhookRequest request;
    @JsonProperty("repository_id")
    private Long repositoryId;
    private boolean redelivery;
    private GHAppWebhookResponse response;
    private String status;
    @JsonProperty("status_code")
    private int statusCode;

    /**
     * Redelivers this webhook delivery.
     *
     * @throws IOException
     *             if the request fails
     */
    public void redeliver() throws IOException {
        root().createRequest()
                .method("POST")
                .withUrlPath(String.format("/app/hook/deliveries/%d/attempts", getId()))
                .send();
    }

    /**
     * Gets the webhook action if available.
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Gets the time this webhook was delivered.
     *
     * @return the delivered time as {@link Instant}
     * @throws IOException
     *             if parsing fails
     */
    public Instant getDeliveredAt() throws IOException {
        return GitHubClient.parseInstant(deliveredAt);
    }

    /**
     * Gets the duration in seconds for this delivery.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets the event type.
     *
     * @return the event
     */
    public GHEvent getEvent() {
        return EnumUtils.getEnumOrDefault(GHEvent.class, event, GHEvent.UNKNOWN);
    }

    /**
     * Gets the webhook GUID.
     *
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Gets the installation id for this delivery.
     *
     * @return the installation id
     */
    public Long getInstallationId() {
        return installationId;
    }

    /**
     * Gets the request information for this delivery.
     *
     * @return the request info
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHAppWebhookRequest getRequest() {
        return request;
    }

    /**
     * Gets the repository id for this delivery.
     *
     * @return the repository id
     */
    public Long getRepositoryId() {
        return repositoryId;
    }

    /**
     * Whether this is a redelivery.
     *
     * @return true if redelivery
     */
    public boolean isRedelivery() {
        return redelivery;
    }

    /**
     * Gets the response information for this delivery.
     *
     * @return the response info
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHAppWebhookResponse getResponse() {
        return response;
    }

    /**
     * Gets the status text.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    GHAppWebhookDelivery wrapUp(GitHub root) {
        this.root = root;
        return this;
    }

    /**
     * Request data for a webhook delivery.
     */
    public static class GHAppWebhookRequest {

        private Map<String, String> headers;
        private Object payload;

        /**
         * Gets the headers used in the request.
         *
         * @return the headers
         */
        @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
        public Map<String, String> getHeaders() {
            return headers;
        }

        /**
         * Gets the payload delivered.
         *
         * @return the payload
         */
        public Object getPayload() {
            return payload;
        }
    }

    /**
     * Response data for a webhook delivery.
     */
    public static class GHAppWebhookResponse {

        private Map<String, String> headers;
        private Object payload;
        @JsonProperty("status_code")
        private Integer statusCode;
        private String status;

        /**
         * Gets response headers.
         *
         * @return the headers
         */
        @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
        public Map<String, String> getHeaders() {
            return headers;
        }

        /**
         * Gets response payload.
         *
         * @return the payload
         */
        public Object getPayload() {
            return payload;
        }

        /**
         * Gets response status text when available.
         *
         * @return the status
         */
        public String getStatus() {
            return status;
        }

        /**
         * Gets response status code when available.
         *
         * @return the status code
         */
        public Integer getStatusCode() {
            return statusCode;
        }
    }
}
