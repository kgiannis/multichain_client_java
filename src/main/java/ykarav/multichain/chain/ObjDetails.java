package ykarav.multichain.chain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This is the details object 
 * It may be included on the main object (ObjResp)
 * when we are getting the response from the API call
 * 
 * @author Karavasilis Ioannis
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	public ObjDetails() {}

	public ObjDetails(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Description [description=" + description + "]";
	}

}
