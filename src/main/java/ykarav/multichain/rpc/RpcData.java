package ykarav.multichain.rpc;

import java.util.List;

/**
 * RpcData object
 * Those are the data we are passing
 * on RPC invoke
 * 
 * @author Karavasilis Ioannis
 *
 */
public class RpcData {

	private String id;
	private String method;
	private List<Object> params;
	private String chainName;
	
	// Default constructor
	public RpcData() {}
	
	
	//--- Setters & Getters ---//
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<Object> getParams() {
		return params;
	}

	public void setParams(List<Object> params) {
		this.params = params;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	
	
	//--- HashCode & Equals ---//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((chainName == null) ? 0 : chainName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RpcData other = (RpcData) obj;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (chainName == null) {
			if (other.chainName != null)
				return false;
		} else if (!chainName.equals(other.chainName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		return true;
	}



	/**
	 * Inner class for Builder 
	 * Builder Pattern
	 * 
	 * @author ykarav
	 *
	 */
	public static class Builder{
		private RpcData _rpcData = new RpcData();
		
		public Builder id(String _id) {
			_rpcData.id = _id;
			return this;
		}
		
		public Builder apiCommand(String _method) {
			_rpcData.method = _method;
			return this;
		}
		
		public Builder params(List<Object> _params) {
			_rpcData.params = _params;
			return this;
		}
		
		public Builder chainName(String _chainName) {
			_rpcData.chainName = _chainName;
			return this;
		}
		
		public RpcData build() {
			return _rpcData;
		}
	}
}
