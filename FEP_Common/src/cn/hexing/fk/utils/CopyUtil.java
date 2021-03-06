/*
 * Created on 2004-7-8
 */
package cn.hexing.fk.utils;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;



/**
 * CopyUtil
 */
public class CopyUtil {
    
	/**
	 * Copy properties of orig to dest
	 * Exception the Entity and Collection Type
	 * @param dest
	 * @param orig
	 * @return the dest bean
	 */
	public static Object copyProperties(Object dest, Object orig) {
	    if (dest == null || orig == null) {
	        return dest;
	    }
	    
		PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);
		try {
			for (int i = 0; i < destDesc.length; i++) {
                if (destDesc[i].getWriteMethod() == null) {
                    continue;
                }
                
				Class<?> destType = destDesc[i].getPropertyType();
				Class<?> origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());
				if(destType != null && destType.equals(origType)
				        && !destType.equals(Class.class)) {
				    Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());
				    PropertyUtils.setProperty(dest, destDesc[i].getName(), value);
				}
			}
			
			return dest;
		}catch(Exception ex) {
			return dest;
		}
	}	
    
	/**
	 * Copy properties of orig to dest
	 * Exception the Entity and Collection Type
	 * @param dest
	 * @param orig
	 * @param ignores
	 * @return the dest bean
	 */
	public static Object copyProperties(Object dest, Object orig, String[] ignores) {
	    if (dest == null || orig == null) {
	        return dest;
	    }
	    
		PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);
		try {
			for (int i = 0; i < destDesc.length; i++) {
                if (destDesc[i].getWriteMethod() == null) {
                    continue;
                }
                
			    if (contains(ignores, destDesc[i].getName())) {
			        continue;
			    }
			    
				Class<?> destType = destDesc[i].getPropertyType();
				Class<?> origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());
				if(destType != null && destType.equals(origType)
				        && !destType.equals(Class.class)) {
					Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());
					PropertyUtils.setProperty(dest, destDesc[i].getName(), value);
				}
			}
			
			return dest;
		}catch(Exception ex) {
			return dest;
		}
	}
	
	static boolean contains(String[] ignores, String name) {
	    boolean ignored = false;
	    for (int j = 0; ignores != null && j < ignores.length; j++) {
	        if (ignores[j].equals(name)) {
	            ignored = true;
	            break;
	        }
	    }
	    
	    return ignored;
	}
}
