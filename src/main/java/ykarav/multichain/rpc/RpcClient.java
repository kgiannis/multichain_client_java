package ykarav.multichain.rpc;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ykarav.multichain.chain.Chain;
import ykarav.multichain.config.HttpClientConfig;

/**
 * RPC Client
 * 
 * @author Karavasilis Ioannis
 *
 */
public class RpcClient {
	
	/* Logger */
	private Logger logger = Logger.getLogger(RpcClient.class.getName());

	/* Closeable HTTP Client  */
	private CloseableHttpClient httpClient;
	
	/* Application Parameters (ip, port, username, password, chainName) */
	private Chain chain;
	
	
	/**
	 * Private Constructor
	 * 
	 * @param chain the name of the chain
	 */
	private RpcClient(Chain chain){
		this.chain = chain;
		this.httpClient = new HttpClientConfig(chain).getHttpClient();
		logger.addHandler( new ConsoleHandler() );
	}
	
	
	/**
	 * Create RPC client
	 * 
	 * @param chain the name of the chain
	 * @return the RPC client
	 */
	public static RpcClient create(Chain chain){
		RpcClient rpc = new RpcClient( chain );
		return rpc;
	}

	/**
	 * Invoke RPC with data and get the result
	 * The result would either be the correct response
	 * or the error response including the error code/message
	 * 
	 * @param data the RPC data
	 * @return the result of the RPC call
	 */
	@SuppressWarnings("unchecked")
	public <T> T call(RpcData data) {
		
		JSONObject responseJSONObjectError = null;
		JSONObject responseJSONObject = this.invokeRPC(data);
		
		// If result is null then something were wrong
		if( responseJSONObject.get("result") == null ){
			
			// Log error code and message
			responseJSONObjectError = (JSONObject) responseJSONObject.get("error");
			logger.log(
					Level.SEVERE, 
					"Code: " + responseJSONObjectError.get("code").toString() + 
					"\nMessage: " + responseJSONObjectError.get("message").toString()
					);
			// Return object with error code/message
        	return (T) responseJSONObjectError;
        }
		
		// Return object with correct response
		return (T) responseJSONObject.get("result");
	}

	
	/**
	 * Invoke RPC with data and get JSONObject response
	 * 
	 * @param data the RPC data
	 * @return the result of the RPC call in JSONObject
	 */
	private JSONObject invokeRPC(RpcData data) {
		
		// Create JSON from MAP
		JSONObject responseJSONObject = 
				JsonUtil.createJson(
						data.getId(), 
						data.getMethod(), 
						data.getParams(), 
						data.getChainName());
	    
	    try {
	        
	    	StringEntity myEntity = new StringEntity(responseJSONObject.toString());
	    	
	    	HttpPost httpPost = new HttpPost( chain.getPostUrl() );
	        httpPost.setEntity(myEntity);

	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();

	        JSONParser parser = new JSONParser();
	        responseJSONObject = (JSONObject) parser.parse(EntityUtils.toString(httpEntity));
	        
	    } catch (IOException e) {
	    	logger.log(Level.SEVERE, "IOException occurred. " + e.getMessage());
	    } catch (org.json.simple.parser.ParseException e) {
	    	logger.log(Level.SEVERE, "ParseException occurred. " + e.getMessage());
		} finally {
			// Close client
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "An error occurred while trying to close http client. " + e.getMessage());
			}
		}

	    return responseJSONObject;
	}
	
}
