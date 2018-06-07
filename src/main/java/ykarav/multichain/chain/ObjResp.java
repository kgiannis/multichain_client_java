package ykarav.multichain.chain;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import ykarav.multichain.util.MultichainUtils;
import ykarav.multichain.util.GetInfo;
import ykarav.multichain.util.GetRuntimeParams;
import ykarav.multichain.util.ListAddresses;
import ykarav.multichain.util.ListStreamKeyItems;
import ykarav.multichain.util.ListStreams;

/**
 * This is the main object we are getting
 * as a response on every API call
 * (Except when we are getting HASH codes as String)
 * 
 * Here you have to include every property you expect 
 * to get on the response
 * 
 * Currently included properties from 
 * General and Streams API methods
 * 
 * Custom annotations are used here in order to tag
 * which properties corresponds on which API call
 * 
 * @author Karavasilis Ioannis
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjResp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("synchronized")
	@ListStreams
	@ListAddresses
	private Boolean synched;
	@ListStreams
	private String name;
	@ListStreams
	private String createtxid;
	@ListStreams
	private String streamref;
	@ListStreams
	private Boolean open;
	@ListStreams
	private ObjDetails objDetails;
	@ListStreams
	private Boolean subscribed;
	@ListStreams
	private String items;
	@ListStreams
	private String confirmed;
	@ListStreams
	private String keys;
	@ListStreams
	private String publishers;
	
	@GetInfo
	private String version;
	@GetInfo
	private String nodeversion;
	@GetInfo
	private String protocolversion;
	@GetInfo
	private String chainname;
	@GetInfo
	private String description;
	@GetInfo
	private String protocol;
	@GetInfo @GetRuntimeParams
	private String port;
	@GetInfo
	private String setupblocks;
	@GetInfo
	private String nodeaddress;
	@GetInfo
	private String burnaddress;
	@GetInfo
	private String incomingpaused;
	@GetInfo
	private String miningpaused;
	@GetInfo
	private String walletversion;
	@GetInfo
	private String balance;
	@GetInfo
	private String walletdbversion;
	@GetInfo @GetRuntimeParams
	private String reindex;
	@GetInfo
	private String blocks;
	@GetInfo
	private String timeoffset;
	@GetInfo
	private String connections;
	@GetInfo
	private String proxy;
	@GetInfo
	private String difficulty;
	@GetInfo
	private String testnet;
	@GetInfo
	private String keypoololdest;
	@GetInfo
	private String keypoolsize;
	@GetInfo
	private String paytxfee;
	@GetInfo
	private String relayfee;
	@GetInfo
	private String errors;
	
	@ListAddresses
	private String address;
	@ListAddresses
	private Boolean ismine;
	@ListAddresses
	private Boolean iswatchonly;
	@ListAddresses
	private Boolean isscript;
	@ListAddresses
	private String pubkey;
	@ListAddresses
	private Boolean iscompressed;
	@ListAddresses
	private String account;
	
	@GetRuntimeParams
	private Boolean rescan;
	@GetRuntimeParams
	private Boolean txindex;
	@GetRuntimeParams
	private Integer autocombineminconf;
	@GetRuntimeParams
	private Integer autocombinemininputs;
	@GetRuntimeParams
	private Integer autocombinemaxinputs;
	@GetRuntimeParams
	private Integer autocombinedelay;
	@GetRuntimeParams
	private Integer autocombinesuspend;
	@GetRuntimeParams
	private String autosubscribe;
	@GetRuntimeParams
	private String handshakelocal;
	@GetRuntimeParams
	private String bantx;
	@GetRuntimeParams
	private String lockblock;
	@GetRuntimeParams
	private Boolean hideknownopdrops;
	@GetRuntimeParams
	private Integer maxshowndata;
	@GetRuntimeParams
	private Boolean miningrequirespeers;
	@GetRuntimeParams
	private double mineemptyrounds;
	@GetRuntimeParams
	private double miningturnover;
	@GetRuntimeParams
	private Integer lockadminminerounds;
	@GetRuntimeParams
	private Boolean gen;
	@GetRuntimeParams
	private Integer genproclimit;
	
	@ListStreamKeyItems
	private String key;
	@ListStreamKeyItems
	private String data;
	@ListStreamKeyItems
	private Integer confirmations;
	@ListStreamKeyItems
	private Integer blocktime;
	@ListStreamKeyItems
	private String txid;
	@ListStreamKeyItems
	@JsonProperty("publishers")
	private List<String> publisherList;
	
	
	public Boolean isSynched() {
		return synched;
	}
	public void setSynched(Boolean synched) {
		this.synched = synched;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatetxid() {
		return createtxid;
	}
	public void setCreatetxid(String createtxid) {
		this.createtxid = createtxid;
	}
	public String getStreamref() {
		return streamref;
	}
	public void setStreamref(String streamref) {
		this.streamref = streamref;
	}
	public Boolean isOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public ObjDetails getObjDetails() {
		return objDetails;
	}
	public void setObjDetails(ObjDetails objDetails) {
		this.objDetails = objDetails;
	}
	public Boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNodeversion() {
		return nodeversion;
	}
	public void setNodeversion(String nodeversion) {
		this.nodeversion = nodeversion;
	}
	public String getProtocolversion() {
		return protocolversion;
	}
	public void setProtocolversion(String protocolversion) {
		this.protocolversion = protocolversion;
	}
	public String getChainname() {
		return chainname;
	}
	public void setChainname(String chainname) {
		this.chainname = chainname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getSetupblocks() {
		return setupblocks;
	}
	public void setSetupblocks(String setupblocks) {
		this.setupblocks = setupblocks;
	}
	public String getNodeaddress() {
		return nodeaddress;
	}
	public void setNodeaddress(String nodeaddress) {
		this.nodeaddress = nodeaddress;
	}
	public String getBurnaddress() {
		return burnaddress;
	}
	public void setBurnaddress(String burnaddress) {
		this.burnaddress = burnaddress;
	}
	public String getIncomingpaused() {
		return incomingpaused;
	}
	public void setIncomingpaused(String incomingpaused) {
		this.incomingpaused = incomingpaused;
	}
	public String getMiningpaused() {
		return miningpaused;
	}
	public void setMiningpaused(String miningpaused) {
		this.miningpaused = miningpaused;
	}
	public String getWalletversion() {
		return walletversion;
	}
	public void setWalletversion(String walletversion) {
		this.walletversion = walletversion;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getWalletdbversion() {
		return walletdbversion;
	}
	public void setWalletdbversion(String walletdbversion) {
		this.walletdbversion = walletdbversion;
	}
	public String getReindex() {
		return reindex;
	}
	public void setReindex(String reindex) {
		this.reindex = reindex;
	}
	public String getBlocks() {
		return blocks;
	}
	public void setBlocks(String blocks) {
		this.blocks = blocks;
	}
	public String getTimeoffset() {
		return timeoffset;
	}
	public void setTimeoffset(String timeoffset) {
		this.timeoffset = timeoffset;
	}
	public String getConnections() {
		return connections;
	}
	public void setConnections(String connections) {
		this.connections = connections;
	}
	public String getProxy() {
		return proxy;
	}
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getTestnet() {
		return testnet;
	}
	public void setTestnet(String testnet) {
		this.testnet = testnet;
	}
	public String getKeypoololdest() {
		return keypoololdest;
	}
	public void setKeypoololdest(String keypoololdest) {
		this.keypoololdest = keypoololdest;
	}
	public String getKeypoolsize() {
		return keypoolsize;
	}
	public void setKeypoolsize(String keypoolsize) {
		this.keypoolsize = keypoolsize;
	}
	public String getPaytxfee() {
		return paytxfee;
	}
	public void setPaytxfee(String paytxfee) {
		this.paytxfee = paytxfee;
	}
	public String getRelayfee() {
		return relayfee;
	}
	public void setRelayfee(String relayfee) {
		this.relayfee = relayfee;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean isIsmine() {
		return ismine;
	}
	public void setIsmine(Boolean ismine) {
		this.ismine = ismine;
	}
	public Boolean isIswatchonly() {
		return iswatchonly;
	}
	public void setIswatchonly(Boolean iswatchonly) {
		this.iswatchonly = iswatchonly;
	}
	public Boolean isIsscript() {
		return isscript;
	}
	public void setIsscript(Boolean isscript) {
		this.isscript = isscript;
	}
	public String getPubkey() {
		return pubkey;
	}
	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}
	public Boolean isIscompressed() {
		return iscompressed;
	}
	public void setIscompressed(Boolean iscompressed) {
		this.iscompressed = iscompressed;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Boolean isRescan() {
		return rescan;
	}
	public void setRescan(Boolean rescan) {
		this.rescan = rescan;
	}
	public Boolean isTxindex() {
		return txindex;
	}
	public void setTxindex(Boolean txindex) {
		this.txindex = txindex;
	}
	public Integer getAutocombineminconf() {
		return autocombineminconf;
	}
	public void setAutocombineminconf(Integer autocombineminconf) {
		this.autocombineminconf = autocombineminconf;
	}
	public Integer getAutocombinemininputs() {
		return autocombinemininputs;
	}
	public void setAutocombinemininputs(Integer autocombinemininputs) {
		this.autocombinemininputs = autocombinemininputs;
	}
	public Integer getAutocombinemaxinputs() {
		return autocombinemaxinputs;
	}
	public void setAutocombinemaxinputs(Integer autocombinemaxinputs) {
		this.autocombinemaxinputs = autocombinemaxinputs;
	}
	public Integer getAutocombinedelay() {
		return autocombinedelay;
	}
	public void setAutocombinedelay(Integer autocombinedelay) {
		this.autocombinedelay = autocombinedelay;
	}
	public Integer getAutocombinesuspend() {
		return autocombinesuspend;
	}
	public void setAutocombinesuspend(Integer autocombinesuspend) {
		this.autocombinesuspend = autocombinesuspend;
	}
	public String getAutosubscribe() {
		return autosubscribe;
	}
	public void setAutosubscribe(String autosubscribe) {
		this.autosubscribe = autosubscribe;
	}
	public String getHandshakelocal() {
		return handshakelocal;
	}
	public void setHandshakelocal(String handshakelocal) {
		this.handshakelocal = handshakelocal;
	}
	public String getBantx() {
		return bantx;
	}
	public void setBantx(String bantx) {
		this.bantx = bantx;
	}
	public String getLockblock() {
		return lockblock;
	}
	public void setLockblock(String lockblock) {
		this.lockblock = lockblock;
	}
	public Boolean isHideknownopdrops() {
		return hideknownopdrops;
	}
	public void setHideknownopdrops(Boolean hideknownopdrops) {
		this.hideknownopdrops = hideknownopdrops;
	}
	public Integer getMaxshowndata() {
		return maxshowndata;
	}
	public void setMaxshowndata(Integer maxshowndata) {
		this.maxshowndata = maxshowndata;
	}
	public Boolean isMiningrequirespeers() {
		return miningrequirespeers;
	}
	public void setMiningrequirespeers(Boolean miningrequirespeers) {
		this.miningrequirespeers = miningrequirespeers;
	}
	public Double getMineemptyrounds() {
		return mineemptyrounds;
	}
	public void setMineemptyrounds(Double mineemptyrounds) {
		this.mineemptyrounds = mineemptyrounds;
	}
	public Double getMiningturnover() {
		return miningturnover;
	}
	public void setMiningturnover(Double miningturnover) {
		this.miningturnover = miningturnover;
	}
	public Integer getLockadminminerounds() {
		return lockadminminerounds;
	}
	public void setLockadminminerounds(Integer lockadminminerounds) {
		this.lockadminminerounds = lockadminminerounds;
	}
	public Boolean isGen() {
		return gen;
	}
	public void setGen(Boolean gen) {
		this.gen = gen;
	}
	public Integer getGenproclimit() {
		return genproclimit;
	}
	public void setGenproclimit(Integer genproclimit) {
		this.genproclimit = genproclimit;
	}

	
	//---------- getinfo_toString  ----------//
	public void toString(Class<? extends Annotation> clazz){
		Map<String, Object> obj_noNulls = MultichainUtils.removeNullValues(this, clazz);
		obj_noNulls.entrySet().forEach(System.out::println);
	}
}
