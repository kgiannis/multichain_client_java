package ykarav.multichain.chain;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ykarav.multichain.rpc.RpcClient;
import ykarav.multichain.rpc.RpcData;
import ykarav.multichain.rpc.RpcDataUtil;

/**
 * Service class for MultiChain API
 * 
 * @author Karavasilis Ioannis
 *
 */
public class MultichainService {
	
	static final Logger logger = Logger.getLogger(MultichainService.class.getName());
	
	private RpcClient rpc;
	
	
	/**
	 * Private Constructor
	 * Initialize RPC client with chain
	 * 
	 * @param chain the chain we are working on
	 */
	private MultichainService (Chain chain){
		this.rpc = RpcClient.create(chain);
    }
	
	/**
	 * Set active chain we are working on
	 * 
	 * @param chain the chain we want to work with
	 * @return MultichainService
	 */
	public static MultichainService setChain(Chain chain){
		return new MultichainService(chain);
	}
	
	
	/**
	 * JSON as String of the RPC call
	 * Pass parameters, method name and chain name to create the RPC call
	 * Get JSON response as String
	 * 
	 * @param params the parameters to pass on the RPC call
	 * @param method the method to call
	 * @param chainName the name of the chain
	 * @return string representation of the JSON call response 
	 */
	public String apiCall(List<Object> params, String method, String chainName) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = Method.ERROR;
		
		try {
			RpcData rpcPayload = RpcDataUtil.constructCall(params, method, chainName);
			jsonInString = mapper.writeValueAsString( rpc.call(rpcPayload) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
	
	/**
	 * Get response from RPC call as String
	 * 
	 * @param jsonInString the JSON in String format
	 * @return the response as string
	 */
	public String getStringResponse(String jsonInString){
		ObjectMapper mapper = new ObjectMapper();
    	String response = new String();
    	try {
    		response = mapper.readValue(jsonInString, String.class);
			logger.log(Level.INFO, "Multichain API Successfully Responded");
		} catch (JsonParseException e1) {
			logger.log(Level.SEVERE, "JsonParseException while trying to get API response.");
		} catch (JsonMappingException e1) {
			logger.log(Level.SEVERE, "JsonMappingException while trying to get API response." );
		} catch (IOException e1) {
			logger.log(Level.SEVERE, "IOException while trying to get API response.");
		}
    	return response;
    }
	
	
	/**
	 * Get response from RPC call as Object
	 * 
	 * @param jsonInString the JSON in String format
	 * @return the response as object
	 */
    public ObjResp getObjectResponse(String jsonInString){
    	ObjectMapper mapper = new ObjectMapper();
    	ObjResp response = null;
    	try {
    		response = mapper.readValue(jsonInString, ObjResp.class);
    		logger.log(Level.INFO, "Multichain API Successfully Responded");
    	} catch (JsonParseException e1) {
			logger.log(Level.SEVERE, "JsonParseException while trying to get API response.");
		} catch (JsonMappingException e1) {
			logger.log(Level.SEVERE, "JsonMappingException while trying to get API response." );
		} catch (IOException e1) {
			logger.log(Level.SEVERE, "IOException while trying to get API response.");
		}
    	return response;
    }
    
    
    /**
	 * Get response from RPC call as List of Objects
	 * 
	 * @param jsonInString the JSON in String format
	 * @return the response as list of objects
	 */
    public List<ObjResp> getObjectListResponse(String jsonInString){
    	ObjectMapper mapper = new ObjectMapper();
    	List<ObjResp> response = null;
    	try {
    		response = mapper.readValue(jsonInString, new TypeReference<Collection<ObjResp>>() {});
    		logger.log(Level.INFO, "Multichain API Successfully Responded");
    	} catch (JsonParseException e1) {
			logger.log(Level.SEVERE, "JsonParseException while trying to get API response.");
		} catch (JsonMappingException e1) {
			logger.log(Level.SEVERE, "JsonMappingException while trying to get API response." );
		} catch (IOException e1) {
			logger.log(Level.SEVERE, "IOException while trying to get API response.");
		}
    	return response;
    }
}
