package ykarav.multichain.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ykarav.multichain.chain.ObjResp;

/**
 * Utility class
 * 
 * @author Karavasilis Ioannis
 *
 */
public class MultichainUtils {

	/**
	 * Since we use only one object type (ObjResp) for every response from API calls
	 * it is common to have many null values in every ObjResp object that we get.
	 * Every API call will carry information regarding its properties
	 * leaving the rest of the properties with null values.
	 * So we are using custom annotations in ObjResp in order to tag which properties 
	 * corresponds to which API call.
	 * 
	 * <RemoveNullValues> stripes off those null values and returns a Map. 
	 * The keys on the map are the names of the filtered properties of ObjResp and the 
	 * values are the value of each property 
	 * 
	 * @param obj the ObjResp type object which we will use to fill the map
	 * @param passedClazz the custom annotation class
	 * @return a map generated from passed Object obj 
	 * with only the properties and their respective values that are not null
	 */
	public static Map<String, Object> removeNullValues(Object obj, Class<? extends Annotation> passedClazz){
		Map<String, Object> result = new HashMap<>();

		// Find the Class that we passed
		Class<?> clazz = obj.getClass();
		
		// Get every field of the class
		// and check if it has the annotation
		for(Field field : clazz.getDeclaredFields()){
			
			// Set it accessible
			field.setAccessible(true);
			
			// If annotation is present
			if( field.isAnnotationPresent(passedClazz) ){
				
				try {
					// Put key/value in map
					result.put(field.getName(), field.get(obj));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Print a list of items of type ObjResp with only the properties
	 * corresponding to custom annotation
	 * 
	 * @param objs the list with the objects
	 * @param clazz the annotation class
	 */
	public static void printList(List<ObjResp> objs, Class<? extends Annotation> clazz){
		if( objs == null ){
			return;
		}
		objs.forEach(i -> i.toString(clazz));
	}
}
