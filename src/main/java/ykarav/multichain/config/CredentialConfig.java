package ykarav.multichain.config;

import org.apache.http.client.CredentialsProvider;

public interface CredentialConfig {

	public CredentialsProvider getBasicCredentialProvider();
	public CredentialsProvider configure(CredentialsProvider credentialsProvider);
}
