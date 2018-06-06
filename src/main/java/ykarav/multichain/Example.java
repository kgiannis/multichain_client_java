package ykarav.multichain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ykarav.multichain.chain.Chain;
import ykarav.multichain.chain.Method;
import ykarav.multichain.chain.MultichainService;
import ykarav.multichain.chain.ObjResp;

/**
 * This is an example class in order to see
 * how you can use the client
 * 
 * There are four examples here:
 * Ex.1: call API method with no parameters and get response as a String
 * Ex.2: call API method with no parameters and get response as ObjResp
 * Ex.3: call API method with no parameters and get response as List<ObjResp>
 * Ex.4: call API method WITH parameters and get response as a String
 * 
 * @author Karavasilis Ioannis
 *
 */
public class Example {
	
	static final Logger logger = Logger.getLogger(Example.class.getName());
	
	String jsonInString;
    List<Object> params = null;
    
    private Chain chain;
    private MultichainService chainService;
    
	
    private Example(Chain chain){
    	this.chain = chain;
    	this.chainService = MultichainService.setChain(chain);
    }
    
    public static Example forChain(Chain chain){
    	return new Example(chain);
    }
    

    /**
     * Call <help> API method without any parameters
     * @return result as String
     * 
     * API Method: help
     * Method Parameters: null
     */
	public String getStringResponseNoParams() {
		logger.log(Level.INFO, "<<---------- Response as [STRING]  ---------->>");
        jsonInString = chainService.apiCall(params, Method.HELP, chain.getChainName());
        System.out.println("Response: " + chainService.getStringResponse(jsonInString) );
        return chainService.getStringResponse(jsonInString);
	}
	
	/**
	 * Call <getinfo> API method without any parameters
	 * @return result as Object of type ObjResp
	 * 
	 * API Method: getinfo
	 * Method Parameters: null
	 */
	public ObjResp getObjectResponseNoParams() {
		logger.log(Level.INFO, "<<---------- Response as [ObjResp]  ---------->>");
        jsonInString = chainService.apiCall(params, Method.GET_INFO, chain.getChainName());
        System.out.println("Response: " + chainService.getObjectResponse(jsonInString) );
        return chainService.getObjectResponse(jsonInString);
	}
	
	/**
	 * Call <liststreams> API method without any parameters
	 * @return result as List of Objects of type ObjResp
	 * 
	 * API Method: liststreams
	 * Method Parameters: null
	 */
	public List<ObjResp> getObjectsListResponseNoParams() {
		logger.log(Level.INFO, "<<---------- Response as [List<ObjResp>]  ---------->>");
        jsonInString = chainService.apiCall(params, Method.LIST_STREAMS, chain.getChainName());
        System.out.println("Response: " + chainService.getObjectListResponse(jsonInString) );
        return chainService.getObjectListResponse(jsonInString);
	}
	
	/**
	 * Call <create> API method without with parameters 
	 * for creating a stream with name 'stream100' which will
	 * be open so anyone with global send permissions can publish to the stream
	 * @return result as String (the result here will be a HASH code)
	 * 
	 * API Method: create
	 * Method Parameters:
	 * - stream: the type to create
	 * - stream100: the name of the stream
	 * - true: the stream will be open
	 */
	public String getStringResponseWithParams() {
		logger.log(Level.INFO, "<<---------- Response as [STRING with params]  ---------->>");
		params = new ArrayList<Object>();
		
		// Create necessary parameters
        Object type = new String("stream");
        Object name = new String("stream100");
        Boolean open = true;
        
        // Add them on 'params' list
        Collections.addAll(params, type,name,open);
        
        jsonInString = chainService.apiCall(params, Method.CREATE, chain.getChainName());
        return chainService.getStringResponse(jsonInString);
	}
}
