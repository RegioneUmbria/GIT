package it.webred.ct.support.audit;

import it.webred.ct.support.audit.annotation.AuditAnnotedFields;
import it.webred.ct.support.audit.annotation.AuditField;
import it.webred.ct.support.audit.annotation.AuditInherit;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

public class DumpField {

	protected Logger logger = Logger.getLogger("CTservice_log");

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private int maxProfondita = 3;
	private boolean inheritedAudit;
	private boolean dumpAllFields;
	
	private String paramName = "Oggetto";
	private String enteId;
	private String userId;
	private String sessionId;
	private HashMap<String,String> hChiavi;

	public String dumpFields(Object o, String livello) throws Exception {
		
		try {
			int profondita = 0;
			inheritedAudit = false;
			dumpAllFields = true;
			if(o != null){
				Class oClass = o.getClass();
				if(oClass.getAnnotation( AuditInherit.class ) != null){
					inheritedAudit = true;
				}
				if(oClass.getAnnotation( AuditAnnotedFields.class ) != null){
					dumpAllFields = false;
				}
			
				return dumpFields(paramName, o, profondita, livello);
			}
			
		} catch (Exception e) {
			logger.error("dumpFields", e);
			throw e;
		}
		
		return livello + "===" + paramName + ">>>null";
	}

	/*
	 * Metodo che crea una stringa descrivente l'oggetto in forma 1, 1.1, 1.1.1, 1.2, ecc...
	 * La prima parte si occupa dei tipi primitivi e conosciuti, la seconda richiama se stessa 
	 * ed aggiunge un livello di profondità in caso di oggetto.
	 * Usa delle annotazioni per capire se raggiungere i campi della superclasse o per limitare 
	 * i field descritti
	 */
	private String dumpFields(String descr, Object o, int profondita, String livello) {

		StringBuffer buffer = new StringBuffer();
		// NON LOGGO LE CHIAMATE AI METODI INTERNI
		if ("_".equals(descr.substring(0,1))) {
				buffer.append(">>>" +  descr + " AUDIT NON IMPLEMENTATO");
				return buffer.toString();
		}
		

		boolean todo = false;
		try {
			

			if (profondita >= maxProfondita) {
				return buffer.toString();
			}
			
			if(!descr.equals(paramName))
				buffer.append("|||");
			buffer.append(livello + "===" + descr);
			if (o == null)
				return ">>>null";
			Class oClass = o.getClass();
	
			if (oClass.isPrimitive() || oClass == java.lang.Long.class
					|| oClass == java.lang.String.class
					|| oClass == java.lang.Integer.class
					|| oClass == java.lang.Boolean.class
					|| oClass == java.lang.Short.class
					|| oClass == java.lang.Byte.class) {
				buffer.append(">>>");
				buffer.append(o);
				//salvo i campi ente, user, session, chiave
				if(descr.equals("ente") || descr.equals("enteId"))
					setEnteId((String) o);
				if(descr.equals("user") || descr.equals("userId"))
					setUserId((String) o);
				if(descr.equals("sessionId"))
					setSessionId((String) o);
				if(hChiavi != null && hChiavi.get(descr) != null){
					hChiavi.remove(descr);
					hChiavi.put(descr, (String) o);
				}
			} else if ("java.util.Date".equals(oClass.getName())
					|| (oClass.getSuperclass()!=null && "java.util.Date".equals(oClass.getSuperclass().getName()))
					) {
				buffer.append(">>>");
				buffer.append(sdf.format(o));
			} else if ("java.math.BigDecimal".equals(oClass.getName())) {
				buffer.append(">>>");
				buffer.append(((BigDecimal) o).toString());
			} else if (oClass.isEnum()) {
				buffer.append(">>>");
				buffer.append(o.toString());
			} else if (implementsInterface(o, Map.class)) {
				buffer.append(">>>" + oClass.getName());
				int contatoreLista = 1;
				Map map = (Map) o;
				boolean tempInheritedAudit = inheritedAudit;
				boolean tempDumpAllFields = dumpAllFields;
				for (Iterator iterator = map.keySet().iterator(); iterator
						.hasNext();) {
					Object type = map.get(iterator.next());
					if(type.getClass().getAnnotation( AuditInherit.class ) != null){
						inheritedAudit = true;
					}
					if(type.getClass().getAnnotation( AuditAnnotedFields.class ) != null){
						dumpAllFields = false;
					}
					buffer.append(dumpFields(type.getClass().getSimpleName(), type, profondita + 1, livello + "."
							+ contatoreLista));
					contatoreLista++;
				}
				inheritedAudit = tempInheritedAudit;
				dumpAllFields = tempDumpAllFields;
			} else if (implementsInterface(o, List.class)) {
				buffer.append(">>>" + oClass.getName());
				List itable = (List) o;
				int contatoreLista = 1;
				boolean tempInheritedAudit = inheritedAudit;
				boolean tempDumpAllFields = dumpAllFields;
				for (Iterator iterator = itable.iterator(); iterator.hasNext();) {
					Object type = iterator.next();
					if(type.getClass().getAnnotation( AuditInherit.class ) != null){
						inheritedAudit = true;
					}
					if(type.getClass().getAnnotation( AuditAnnotedFields.class ) != null){
						dumpAllFields = false;
					}
					buffer.append(dumpFields(type.getClass().getSimpleName(), type, profondita + 1, livello + "."
							+ contatoreLista));
					contatoreLista++;
				}
				inheritedAudit = tempInheritedAudit;
				dumpAllFields = tempDumpAllFields;
				int lenght = buffer.length();
				buffer.substring(0, lenght -3);
			} else if (oClass.isArray()) {
				buffer.append(">>>" + oClass.getName());
				int contatoreLista = 1;
				boolean tempInheritedAudit = inheritedAudit;
				boolean tempDumpAllFields = dumpAllFields;
				//l'array può essere di primitive 
				if (o.getClass().getComponentType().isPrimitive()) {
					buffer.append(o.toString());
				} else {
					Object[] obj = (Object[]) o;
					for (int i = 0; i < obj.length; i++) {
						if(obj[i].getClass().getAnnotation( AuditInherit.class ) != null){
							inheritedAudit = true;
						}
						if(obj[i].getClass().getAnnotation( AuditAnnotedFields.class ) != null){
							dumpAllFields = false;
						}
						buffer.append(dumpFields(obj[i].getClass().getSimpleName(), obj[i], profondita + 1, livello + "."
								+ contatoreLista));
						contatoreLista++;
					}
				}
				inheritedAudit = tempInheritedAudit;
				dumpAllFields = tempDumpAllFields;
				int lenght = buffer.length();
				buffer.substring(0, lenght -3);
				
			} else {
				buffer.append(">>>" + oClass.getName());
				int contatoreLista = 1;
				Vector<Field> fields = null;
				if(inheritedAudit)
					fields = getAllFields(oClass);
				else fields = toVector(oClass.getDeclaredFields());
				for (int i = 0; i < fields.size(); i++) {
					Field field = fields.get(i);
					if(dumpAllFields || field.getAnnotation(AuditField.class) != null){
						field.setAccessible(true);
						try {
							Object value = field.get(o);
							if (value != null && !"".equals(value) 
									&& !"serialVersionUID".equals(field.getName())
									) {
								if (value.getClass().isPrimitive()
										|| value.getClass() == java.lang.Long.class
										|| value.getClass() == java.lang.String.class
										|| value.getClass() == java.lang.Integer.class
										|| value.getClass() == java.lang.Boolean.class
										|| value.getClass() == java.lang.Short.class
										|| value.getClass() == java.lang.Byte.class) {
									buffer.append("|||" + livello + "." + contatoreLista + "==="+ field.getName() +">>>"+value);
									//salvo i campi ente, user, session, chiave
									if(field.getName().equals("ente") || field.getName().equals("enteId"))
										setEnteId((String) value);
									if(field.getName().equals("user") || field.getName().equals("userId"))
										setUserId((String) value);
									if(field.getName().equals("sessionId"))
										setSessionId((String) value);
									if(hChiavi != null && hChiavi.get(field.getName()) != null){
										hChiavi.remove(descr);
										hChiavi.put(field.getName(), (String) value);
									}
								} else if ("java.util.Date".equals(value.getClass().getName())
										|| (value.getClass().getSuperclass()!=null && "java.util.Date".equals(value.getClass().getSuperclass().getName())
											)
										) {
									buffer.append("|||" + livello + "." + contatoreLista + "==="+ field.getName() +">>>"+sdf.format(value));
								} else if ("java.math.BigDecimal".equals(value.getClass().getName())
										) {
									buffer.append("|||" + livello + "." + contatoreLista + "==="+ field.getName() +">>>"+((BigDecimal) value).toString());
								} else if (value.getClass().isEnum()) {
									buffer.append("|||" + livello + "." + contatoreLista + "==="+ field.getName() +">>>"+value.toString());
								} else {
									//nel caso che trovi la notazione @AuditField su un oggetto setto temporaneamente 
									//il dump su tutti i suoi field per poi ritornare al valore originale 
									boolean tempDumpAllFields = dumpAllFields;
									dumpAllFields = true;
									buffer.append(dumpFields(field.getName(), value, profondita + 1, livello + "."
											+ contatoreLista));
									dumpAllFields = tempDumpAllFields;
								}
							} else{
								contatoreLista--;
								//buffer.append("|||" + livello + "." + contatoreLista + "==="+ field.getName() +">>>null");
							}
						} catch (IllegalAccessException e) {
							buffer.append(e.getMessage());
						}
						contatoreLista++;
					}
				}
				
			}
	
			return buffer.toString();
		} catch (Exception e) {
			logger.error("Impossibile fare il dump dei fields ",e);
			return "Errore scrittura parametri :" + o!=null? o.toString(): "";
		}
	}

	public static Boolean implementsInterface(Object object, Class interf) {
		for (Class c : object.getClass().getInterfaces()) {
			if (c.equals(interf)) {
				return true;
			}
		}
		return false;
	}

	public Vector<Field> getAllFields(Class clazz) {
        return getAllFieldsRec(clazz, new Vector<Field>());
    }

    private Vector<Field> getAllFieldsRec(Class clazz, Vector<Field> vector) {
        Class superClazz = clazz.getSuperclass();
        if(superClazz != null){
            getAllFieldsRec(superClazz, vector);
        }
        vector.addAll(toVector(clazz.getDeclaredFields()));
        return vector;
    }
    
    private Vector<Field> toVector(Field[] array){
    	if(array.length > 0)
    		return new Vector(Arrays.asList(array));
    	else return new Vector();
    }

	public String getEnteId() {
		return enteId;
	}

	public void setEnteId(String enteId) {
		this.enteId = enteId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public HashMap<String, String> gethChiavi() {
		return hChiavi;
	}

	public void sethChiavi(HashMap<String, String> hChiavi) {
		this.hChiavi = hChiavi;
	}

	public int getMaxProfondita() {
		return maxProfondita;
	}

	public void setMaxProfondita(int maxProfondita) {
		this.maxProfondita = maxProfondita;
	}
	
}
