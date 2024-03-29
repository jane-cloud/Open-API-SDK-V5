package com.okex.open.api.client;

import com.okex.open.api.config.APIConfiguration;


public class APICredentials {
    /**
     * The user's secret key provided by OKEx.
     */
    private String apiKey;
    /**
     * The private key used to sign your request data.
     */
    private String secretKey;
    /**
     * The Passphrase will be provided by you to further secure your API access.
     */
    private String passphrase;

    private String xSimulatedTrading;



    public APICredentials(APIConfiguration config) {
        super();
        this.apiKey = config.getApiKey();
        this.secretKey = config.getSecretKey();
        this.passphrase = config.getPassphrase();
        this.xSimulatedTrading = config.getxSimulatedTrading();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getxSimulatedTrading() {
        return xSimulatedTrading;
    }

    public void setxSimulatedTrading(String xSimulatedTrading) {
        this.xSimulatedTrading = xSimulatedTrading;
    }
}
