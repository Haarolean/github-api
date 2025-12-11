package org.kohsuke.github;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Collections;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Represents the response part of a GitHub App webhook delivery.
 *
 * @see GHAppHookDelivery#getResponse()
 */
@SuppressFBWarnings(value = { "UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "UWF_UNWRITTEN_FIELD", "NP_UNWRITTEN_FIELD" },
        justification = "JSON API")
public class GHAppHookDeliveryResponse {

    private Map<String, String> headers;
    private String payload;

    /**
     * Create default GHAppHookDeliveryResponse instance.
     */
    public GHAppHookDeliveryResponse() {
    }

    /**
     * Gets the headers of the response.
     *
     * @return the headers as an unmodifiable map
     */
    public Map<String, String> getHeaders() {
        return headers != null ? Collections.unmodifiableMap(headers) : null;
    }

    /**
     * Gets the payload of the response.
     *
     * @return the payload
     */
    public String getPayload() {
        return payload;
    }
}
