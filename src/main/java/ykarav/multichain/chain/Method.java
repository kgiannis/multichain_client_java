package ykarav.multichain.chain;

/**
 * All MultiChain API methods 
 * as static variables
 * 
 * @author Karavasilis Ioannis
 *
 */
public final class Method {

	/** General utilities */
	public static final String GET_INFO = "getinfo";
	public static final String GET_RUNTIME_PARAMS = "getruntimeparams";
	public static final String HELP = "help";
	public static final String STOP = "stop";
	
	/** Managing wallet addresses */
	public static final String ADD_MULTISIG_ADDRESSES = "addmultisigaddress";
	public static final String GET_ADDRESSES = "getaddresses";
	public static final String GET_NEW_ADDRESS = "getnewaddress";
	public static final String IMPORT_ADDRESS = "importaddress";
	public static final String LIST_ADDRESSES = "listaddresses";
	
	/** Working with non-wallet addresses */ 
	public static final String CREATE_KEY_PAIRS = "createkeypairs";
	public static final String CREATE_MULTISIG = "createmultisig";
	public static final String VALIDATE_ADDRESSES = "validateaddress";
	
	/** Permissions management */
	public static final String GRANT = "grant";
	public static final String GRANT_FROM = "grantfrom";
	public static final String GRANT_WITH_DATA = "grantwithdata";
	public static final String GRANT_WITH_DATA_FROM = "grantwithdatafrom";
	public static final String LIST_PERMISSIONS = "listpermissions";
	public static final String REVOKE = "revoke";
	public static final String REVOKE_FROM = "revokefrom";
	
	/** Asset management */
	public static final String ISSUE = "issue";
	public static final String ISSUE_FROM = "issuefrom";
	public static final String ISSUE_MORE = "issuemore";
	public static final String ISSUE_MORE_FROM = "issuemorefrom";
	public static final String LIST_ASSETS = "listassets";
	
	/** Querying wallet balances and transactions */
	public static final String GET_ADDRESS_BALANCES = "getaddressbalances";
	public static final String GET_ADDRESS_TRANSACTION = "getaddresstransaction";
	public static final String GET_MULTI_BALANCES = "getmultibalances";
	public static final String GET_TOTAL_BALANCES = "gettotalbalances";
	public static final String GET_WALLET_TRANSACTION = "getwallettransaction";
	public static final String LIST_ADDRESS_TRANSACTIONS = "listaddresstransactions";
	public static final String LIST_WALLET_TRANSACTIONS = "listwallettransactions";
	
	/** Sending one-way payments */
	public static final String SEND = "send";
	public static final String SEND_ASSET = "sendasset";
	public static final String SEND_ASSET_FROM = "sendassetfrom";
	public static final String SEND_FROM = "sendfrom";
	public static final String SEND_WITH_DATA = "sendwithdata";
	public static final String SEND_WITH_DATA_FROM = "sendwithdatafrom";
	
	/** Atomic exchange transactions */
	public static final String APPEND_RAW_EXCHANGE = "appendrawexchange";
	public static final String COMPLETE_RAW_EXCHANGE = "completerawexchange";
	public static final String CREATE_RAW_EXCHANGE = "createrawexchange";
	public static final String DECODE_RAW_EXCHANGE = "decoderawexchange";
	public static final String DISABLE_RAW_TRANSACTION = "disablerawtransaction";
	public static final String PREPARE_LOCK_UNSPENT = "preparelockunspent";
	public static final String PREPARE_LOCK_UNSPENT_FROM = "preparelockunspentfrom";
	
	/** Stream management */ 
	public static final String CREATE = "create";
	public static final String CREATE_FROM = "createfrom";
	public static final String LIST_STREAMS = "liststreams";
	
	/** Publishing stream items */
	public static final String PUBLISH = "publish";
	public static final String PUBLISH_FROM = "publishfrom";
	
	/** Managing stream and asset subscriptions */
	public static final String SUBSCRIBE = "subscribe";
	public static final String UNSUBSCRIBE = "unsubscribe";
	
	/** Querying subscribed assets */
	public static final String GET_ASSET_TRANSACTION = "getassettransaction";
	public static final String LIST_ASSET_TRANSACTIONS = "listassettransactions";
	
	/** Querying subscribed streams */
	public static final String GET_STREAM_ITEM = "getstreamitem";
	public static final String GET_TX_OUT_DATA = "gettxoutdata";
	public static final String LIST_STREAM_BLOCK_ITEMS = "liststreamblockitems";
	public static final String LIST_STREAM_KEY_ITEMS = "liststreamkeyitems";
	public static final String LIST_STREAM_KEYS = "liststreamkeys";
	public static final String LIST_STREAM_ITEMS = "liststreamitems";
	public static final String LIST_STREAM_PUBLISHER_ITEMS = "liststreampublisheritems";
	public static final String LIST_STREAM_PUBLISHERS = "liststreampublishers";
	
	/** Managing wallet unspent outputs */
	public static final String COMBINE_UNSPENT = "combineunspent";
	public static final String LIST_LOCK_UNSPENT = "listlockunspent";
	public static final String LIST_UNSPENT = "listunspent";
	public static final String LOCK_UNSPENT = "lockunspent";
	
	/** Working with raw transactions */
	public static final String APPEND_RAW_CHANGE = "appendrawchange";
	public static final String APPEND_RAW_DATA = "appendrawdata";
	public static final String APPEND_RAW_TRANSACTION = "appendrawtransaction";
	public static final String CREATE_RAW_TRANSACTION = "createrawtransaction";
	public static final String CREATE_RAW_SEND_FROM = "createrawsendfrom";
	public static final String DECODE_RAW_TRANSACTION = "decoderawtransaction";
	public static final String SEND_RAW_TRANSACTION = "sendrawtransaction";
	public static final String SIGN_RAW_TRANSACTION = "signrawtransaction";
	
	/** Peer-to-peer connections */
	public static final String ADD_NODE = "addnode";
	public static final String GET_ADDED_NODE_INFO = "getaddednodeinfo";
	public static final String GET_NETWORK_INFO = "getnetworkinfo";
	public static final String GET_PEER_INFO = "getpeerinfo";
	public static final String PING = "ping";
	
	/** Messaging signing and verification */
	public static final String SIGN_MESSAGE = "signmessage";
	public static final String VERIFY_MESSAGE = "verifymessage";
	
	/** Querying the blockchain */
	public static final String GET_BLOCK = "getblock";
	public static final String GET_BLOCKCHAIN_INFO = "getblockchaininfo";
	public static final String GET_BLOCK_HASH = "getblockhash";
	public static final String GET_MEM_POOL_INFO = "getmempoolinfo";
	public static final String GET_RAW_MEM_POOL = "getrawmempool";
	public static final String GET_RAW_TRANSACTION = "getrawtransaction";
	public static final String GET_TX_OUT = "gettxout";
	public static final String LIST_BLOCKS = "listblocks";
	
	/** Advanced wallet control */
	public static final String BACKUP_WALLET = "backupwallet";
	public static final String DUMP_PRIV_KEY = "dumpprivkey";
	public static final String DUMP_WALLET = "dumpwallet";
	public static final String ENCRYPT_WALLET = "encryptwallet";
	public static final String GET_WALLET_INFO = "getwalletinfo";
	public static final String IMPORT_PRIV_KEY = "importprivkey";
	public static final String IMPORT_WALLET = "importwallet";
	public static final String WALLET_LOCK = "walletlock";
	public static final String WALLET_PASSPHRASE = "walletpassphrase";
	public static final String WALLET_PASSPHRASE_CHANGE = "walletpassphrasechange";
	
	/** Blockchain upgrading */
	public static final String APPROVE_FROM = "approvefrom";
	public static final String LIST_UPGRADES = "listupgrades";
	
	/** Advanced node control */
	public static final String CLEAR_MEM_POOL = "clearmempool";
	public static final String PAUSE = "pause";
	public static final String RESUME = "resume";
	public static final String SET_LAST_BLOCK = "setlastblock";
	
	
	
	
	public static final String ERROR = "error";
}
