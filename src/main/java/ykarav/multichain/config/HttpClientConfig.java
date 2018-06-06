package ykarav.multichain.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import ykarav.multichain.chain.Chain;

/**
 * Configuration class
 * Configure Credentials Provider
 * and HTTP Client
 * 
 * @author Karavasilis Ioannis
 *
 */
public class HttpClientConfig implements CredentialConfig, HttpConfig {
	
	private Chain chain;
	
	public HttpClientConfig(Chain chain){
		this.chain = chain;
	}

	/**
	 * Get new BasicCredentialsProvider
	 */
	public CredentialsProvider getBasicCredentialProvider() {
		return new BasicCredentialsProvider();
	}

	/**
	 * Configure Credentials Provider
	 * 
	 * @param credentialsProvider the credentials provider
	 */
	public CredentialsProvider configure(CredentialsProvider credentialsProvider) {
		credentialsProvider = getBasicCredentialProvider();
		credentialsProvider.setCredentials(
                new AuthScope(
                		chain.getIp(), 
                		chain.getPort()),
                new UsernamePasswordCredentials(
                		chain.getUsername(), 
                		chain.getPassword())
        );
		return credentialsProvider;
	}

	/**
	 * Get a CloseableHttpClient
	 * configured with credentials
	 */
	public CloseableHttpClient getHttpClient() {
		return HttpClientBuilder
				.create()
				.setConnectionManagerShared(true)
				.setDefaultCredentialsProvider( configure(getBasicCredentialProvider()) )
				.build();
	}

}
