package com.android.vj.mvparchitecture.model;

import com.android.vj.mvparchitecture.model.network.Network;
import com.android.vj.mvparchitecture.model.network.NetworkCallback;

public abstract class BaseClient {
    private final Network network;

    protected BaseClient() {
        network = new Network(AppConstant.BASE_URL);
    }

    /**
     * Makes a get request appending default query string (api key) to url.
     *
     * @param url      The url to request (without api key query string param)
     * @param callback The callback that should be called when finished.
     */
    protected void makeGetRequest(String url, NetworkCallback callback) {
        network.makeRequest(appendDefaultQueryString(url), callback);
    }

    /**
     * Appends the default query string params that should be in every requests,
     * like api key and units.
     *
     * @param url The url that should be concatenated with default params.
     * @return The complete url with all query string params.
     */
    private String appendDefaultQueryString(String url) {
        return url;
    }
}
