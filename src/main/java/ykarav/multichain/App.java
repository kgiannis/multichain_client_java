package ykarav.multichain;

import java.util.List;

import ykarav.multichain.chain.Chain;
import ykarav.multichain.chain.ObjResp;
import ykarav.multichain.util.GetInfo;
import ykarav.multichain.util.ListStreams;
import ykarav.multichain.util.MultichainUtils;

/**
 * MultiChain Client
 * 
 * @author Karavasilis Ioannis
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	/**
    	 * Initialize chain
    	 * Here we are passing:
    	 * node_ip, node_port, username, password, name_of_our_chain
    	 * username/password can be found at file: multichain.conf
    	 */
        Chain chain0 = Chain.initialize("127.0.0.1", 7420, "multichainrpc", "AeU1Z3XtfNwu4BGJiDDciTGn1NgPaogFZ879JBRsVqgD", "chain0");
    
        /**
         * Set chain on Example class so we can 
         * interact with the chain
         */
        Example example = Example.forChain(chain0);
        
        
        /**
         * Example -= 1 =-
         * API Method: <help>
         * Method Parameters: null
         * 
         * Call <help> method without any parameters and
         * get result as String
         */
        example.getStringResponseNoParams().toString();
        
        
        /**
         * Example -= 2 =-
         * API Method: <getinfo>
         * Method Parameters: null
         * 
         * Call <getinfo> method without any parameters and
         * get result as Object
         */
        ObjResp response_info = example.getObjectResponseNoParams();
        response_info.toString(GetInfo.class);
        
        /**
         * Example -= 3 =-
         * API Method: <liststreams>
         * Method Parameters: null
         * 
         * Call <liststreams> method without any parameters and
         * get result as Object
         */
        List<ObjResp> response_streams = example.getObjectsListResponseNoParams();
        MultichainUtils.printList(response_streams, ListStreams.class);
        
        /**
         * Example -= 4 =-
         * API Method: <create>
         * Method Parameters: type, name, open
         * 
         * Call <create> method without any parameters and
         * get result as Object
         */
        example.getStringResponseWithParams().toString();
        
    }
}
