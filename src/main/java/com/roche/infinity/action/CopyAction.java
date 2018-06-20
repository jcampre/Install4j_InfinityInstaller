package com.roche.infinity.action;

import java.io.File;

import com.install4j.api.context.Context;
import com.roche.infinity.installer.install4j.utils.Utils;

public class CopyAction extends AbstractRocheAction  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public CopyAction() {
		super();
	}
		
	@Override
	protected void reportFailure(Context context, Exception exception) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean execute(Context context) throws Exception {
		Utils.copyFolder(new File((String)context.getVariable("backupFolder")), new File ((String)context.getVariable("backupFolder")));
		return false;
	}

	@Override
	protected boolean execute(Context context, String toScreen) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean preaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}


}
