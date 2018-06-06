# multichain_client_java
A Multichain client for JAVA. Tested on Multichain version 1.0.4 with protocol version 10010

## Getting Started
This client is provided with four examples so you can see it in action and test the different responses you get when you make an API call.

We are using only one object type **(ObjResp)** for every response we are expecting from the API call. 
Since each response carries its own properties we are expecting to have many properties inside this object in order to cover all the possible responses from different calls.
That concludes (in case we are getting Object and not String as response) with an object with many NULL values in its properties. 
Only the properties that corresponds to the API response are populated with values.
So, as an example, when we are calling API method **getinfo** we are expecting to have values for properties as _version_, _protocolversion_ and so on.

As you can see in **App.java** you have to follow the steps bellow:

Step 1.: Initialize the Chain properties
```
Chain chain0 = Chain.initialize("127.0.0.1", 7420, "multichainrpc", "AeU1Z3XtfNwu4BGJiDDciTGn1NgPaogFZ879JBRsVqgD", "chain0");
```

Method _initialize_ takes five arguments
```
Chain(ip, port, username, password, chainName)
```

***ip*** is the IP of the node, ***port*** is the PORT of the node, ***username*** and ***password*** can be found in file multichain.conf and ***chainName*** is the name you gave to the chain when you first created it.

Step 2.: Set chain object on Example.forChain() method
```
Example example = Example.forChain(chain0);
```

## Examples ##
Inside class Example you can see the four example calls. Each call is different so you can see how to use the API with and without parameters and also how to get the response from the API.

In case of an error (either because you forgot to pass the necessary parameters or passed wrong parameters or even got wrong type as a response) an error message is logged along with its code.

All error codes and messages can be found here:
https://www.multichain.com/developers/api-errors/

We first initialize the MultichainService object with:
```
this.chainService = MultichainService.setChain(chain);
```

MultichainService class is responsible for the interaction with the chain. Inside there we are initializing the RPC client
```
this.rpc = RpcClient.create(chain);
```

and also there you can find the methods to call the API: 
```
public String apiCall(List<Object> params, String method, String chainName)
```
and get responses:
```
public String getStringResponse(String jsonInString)
public ObjResp getObjectResponse(String jsonInString)
public List<ObjResp> getObjectListResponse(String jsonInString)
```

### Example 1 - No Parameters, Response as String ###
In this example we are passing no parameters and we are expecting the response as String. An API method to use here for demonstration is the **'help'** method. What we are doing here is the equivalent to:
```
{"method":"help","params":[],"id":1,"chain_name":"chain0"}
```
in RPC call.

First we are calling:
```
jsonInString = chainService.apiCall(params, Method.HELP, chain.getChainName());
```
Method _apiCall_ returns the RPC response by first preparing the data and then invoking the RPC.

_Preparing data:_
```
RpcData rpcPayload = RpcDataUtil.constructCall(params, method, chainName);
```
_Invoking RPC:_
```
jsonInString = mapper.writeValueAsString( rpc.call(rpcPayload) );
```
Here **rpc.call(rpcPayload)** invokes the RPC and get the response. 
If the response has any errors those errors are logged at this point.
If the response has no errors we are making the call to the chain and expect the result. 

The response is then extracted with:
```
chainService.getStringResponse(jsonInString)
```

### Example 2 - No Parameters, Response as Object of type ObjResp ###
This example is same as example 1 but in this case you are calling method _getObjectResponse_ and we are getting response as object of type ObjResp. An API method to demonstrate it is the **'getinfo'** method.

As you can see at App.java we are extracting the response:
```
ObjResp response_info = example.getObjectResponseNoParams();
```
Here the object **response_info** carries all the properties of the getinfo method.
So if you want to get the version of the chain you can get it with:
```
response_info.getVersion();
```
You can also see how you can print the result:
```
response_info.toString(GetInfo.class);
```
Method **_toString(GetInfo.class)_** maps to:
```
public void toString(Class<? extends Annotation> clazz)
```
inside ObjResp class. 
Since we have already tag all the properties inside ObjResp class with our custom annotations it is easy to get those properties by searching for the annotation class we are passing as parameter.
So **GetInfo.class** here will look only for those properties that have the **@GetInfo** annotation and will return them so we can print them.


### Example 3 - No Parameters, Response as List of objects of type ObjResp ###
Same as previous examples but this time we are calling method _getObjectListResponse_ and we are expecting to get a list of objects of type ObjResp. An API method to demonstrate it is the **'liststreams'** method. The response will be of type List<ObjResp>.

### Example 4 - With Parameters, Response as String ###
In this example we are passing an ArrayList with all the necessary parameters for the API call. An API method to demonstrate this functionality is the **'create'** method which creates a stream and returns a HASH code upon successful completion.  

First create the parameters you need for the API call and add them to the ArrayList
```
Object type = new String("stream");
Object name = new String("stream100");
Boolean open = true;
Collections.addAll(params, type,name,open);
```

Here the parameters:
- type: is the type of the create, in our case it is a "stream"
- name: is the name of the stream we want to create, in our case the name is "stream100"
- open: whether the stream is open or not to anyone with write permission.

Then we proceed the same way as Example 1.

# Next Steps #
So far the streams and the general info api method responses are available at the ObjResp. More properties have to be added in order to support all the possible responses from the api call.

You can find more info on the Multichain platform here:
https://www.multichain.com/

More on the Multichain API here:
https://www.multichain.com/developers/json-rpc-api/
