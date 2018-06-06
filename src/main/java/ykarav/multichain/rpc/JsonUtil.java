package ykarav.multichain.rpc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

/**
 * Utility class for JSON 
 * 
 * @author Karavasilis Ioannis
 *
 */
public class JsonUtil {

	/**
	 * Create JSON Object for the RPC call
	 * 
	 * @param id the unique id
	 * @param method the name of the method to call
	 * @param params the parameters - if any - for the method
	 * @param chainName the name of the chain 
	 * @return the JSON object
	 */
	public static JSONObject createJson(String id, String method, List<Object> params, String chainName) {
		
		// Create MAP that will be used as JSON
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("id", id);
        jsonMap.put("method", method);
        jsonMap.put("params", params);
	    jsonMap.put("chain_name", chainName);
	    
	    return new JSONObject(jsonMap);
	}
}
