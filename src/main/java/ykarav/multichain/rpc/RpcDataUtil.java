package ykarav.multichain.rpc;

import java.util.List;
import java.util.UUID;

/**
 * Utility class for RPC payload
 * 
 * @author Karavasilis Ioannis
 *
 */
public class RpcDataUtil {

	/**
	 * Construct RPC call
	 * 
	 * @param params the params to pass to the call
	 * @param apiCommand the multichain api command to execute
	 * @return constructed RPC call as RpcData
	 */
	public static RpcData constructCall(List<Object> params, String apiCommand, String chainName) {
		return new RpcData.Builder()
				.id(UUID.randomUUID().toString())
				.apiCommand(apiCommand)
				.params(params)
				.chainName(chainName)
				.build();
	}
}
