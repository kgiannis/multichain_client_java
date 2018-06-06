package ykarav.multichain.config;

import org.apache.http.impl.client.CloseableHttpClient;

public interface HttpConfig {

	public CloseableHttpClient getHttpClient();
}
