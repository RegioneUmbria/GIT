package it.webred.rulengine.brick.loadDwh.load.redditi.r2007.v1;

import it.webred.rulengine.brick.loadDwh.load.redditi.r2007.RedditiConcreteImportEnv;
import it.webred.rulengine.brick.loadDwh.load.redditi.r2007.RedditiEnv;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Env<T extends RedditiEnv> extends RedditiConcreteImportEnv<T> {

	public Env(T ei) {
		super(ei);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LinkedHashMap getTabelleAndChiavi() {
		LinkedHashMap<String, ArrayList<String>>  hm = new LinkedHashMap<String, ArrayList<String>>();
		hm.put(envImport.tableRE_A , null);
		
		return hm;
	}

	@Override
	public LinkedHashMap getTabelleAndTipiRecord() {
		LinkedHashMap<String, String> tr = new LinkedHashMap<String, String>();
		tr.put(envImport.tableRE_A , null);
		return tr;
	}

	@Override
	public ArrayList getTabelleFinaliDHW() {
		// TODO Auto-generated method stub
		return null;
	}

}
