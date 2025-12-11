package org.kohsuke.github;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Collections;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Represents the request part of a GitHub App webhook delivery.
 *
 * @see GHAppHookDelivery#getRequest()
 */
@SuppressFBWarnings(value = { "UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "UWF_UNWRITTEN_FIELD", "NP_UNWRITTEN_FIELD" },
        justification = "JSON API")
public class GHAppHookDeliveryRequest {

    private Map<String, String> headers;
    private Object payload;

    /**
     * Create default GHAppHookDeliveryRequest instance.
     */
    public GHAppHookDeliveryRequest() {
    }

    /**
     * Gets the headers of the request.
     *
     * @return the headers as an unmodifiable map
     */
    public Map<String, String> getHeaders() {
        return headers != null ? Collections.unmodifiableMap(headers) : null;
    }

    /**
     * Gets the payload of the request. The payload can be a Map or a String depending on the content type.
     *
     * @return the payload
     */
    public Object getPayload() {
        return payload;
    }
}
