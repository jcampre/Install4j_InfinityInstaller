package com.roche.infinity.action;

import java.io.File;

import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.install4j.api.context.UserCanceledException;
import com.roche.infinity.installer.install4j.utils.ZipUtils;

public class ZipAction extends AbstractRocheAction {

	ZipUtils appZip = null; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean install(InstallerContext arg0) throws UserCanceledException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected void reportFailure(Context context, Exception exception) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean execute(Context context) throws Exception {
		appZip.generateFileList(new File(sourceFolder));
        appZip.zipIt(appZip.getOutputZipFile());
        
		return true;
	}

	@Override
	protected boolean execute(Context context, String toScreen) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean preaction(Context context) {
		appZip = new ZipUtils();
		
		return true;
	}

	@Override
	protected boolean postaction(Context context) {
		// TODO Auto-generated method stub
		return false;
	}
}
