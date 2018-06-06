package ykarav.multichain.chain;

/**
 * All necessary MultiChain variables
 * 
 * @author Karavasilis Ioannis
 *
 */
public final class Chain {

	private String ip;
	private int port;
	private String username;
	private String password;
	private String chainName;
	
	/**
	 * Initialize the chain object with 
	 * chain necessary data
	 */
	public static Chain initialize(String ip, int port, String username, String password, String chainName){
		return new Chain(ip, port, username, password, chainName);
	}
	
	public Chain(String ip, int port, String username, String password, String chainName) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
		this.chainName = chainName;
	}
	
	/**
	 * Get generated post URL
	 * @return string representation of the post URL
	 */
	public String getPostUrl(){
		return "http://" + this.ip + ":" + this.port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}
	
}
