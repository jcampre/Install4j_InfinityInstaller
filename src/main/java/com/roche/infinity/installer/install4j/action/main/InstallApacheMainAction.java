package com.roche.infinity.installer.install4j.action.main;

import java.io.File;

import com.install4j.api.Util;
import com.install4j.api.context.Context;
import com.install4j.api.context.InstallerContext;
import com.roche.infinity.installer.install4j.action.AbstractRocheAction;
import com.roche.infinity.installer.install4j.action.CreateFolderAction;
import com.roche.infinity.installer.install4j.action.files.RocheZipFileAction;
import com.roche.infinity.installer.install4j.utils.FileUtils;
import com.install4j.runtime.beans.actions.files.AbstractExtractZipFileAction;
import com.install4j.runtime.beans.actions.files.AbstractZipFileAction;
import com.install4j.runtime.beans.actions.files.CreateZipFileAction;

/**
 * Main Apache install action
 * 
 * @author jarenas
 */
public class InstallApacheMainAction extends AbstractRocheAction {

	private boolean preaction = true;
	private String folder;

	private RocheZipFileAction zipAction;
	private CreateFolderAction folderAction;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public InstallApacheMainAction() {
		super();
		
	}

	@Override
	protected void reportFailure(Context context, Exception e) {
		// TODO Auto-generated method stub
		Util.showMessage("Aquí lanzariamos las acciones en caso de fallo");
	}

	@SuppressWarnings("finally")
	@Override
	protected boolean execute(Context context) throws Exception {
		// TODO Auto-generated method stub
		Util.showMessage(
				"Aquí lanzariamos la instal·lación personalizada del Apache via código java. Podemos llamar acciones de install4j o hacer un wrapper para independizarnos de la tecnologia");
		Util.showMessage("Ahora Creamos un directorio con una acción personalizada");
		
		
		try {
			folderAction = new CreateFolderAction();
			folderAction.setFolder("c:\\pepe");
			folderAction.install((InstallerContext) context);
			
//			FileUtils.createFolder("c:\\pepe");
			
//			zipAction = new RocheZipFileAction();
//			zipAction.init(context);
//			File zipFile = 
//			zipAction.setZipFile(zipFile);
//			
////			zipAction.install((InstallerContext) context);
//			File file = zipAction.getZipFile();
//			if (file  == null)
//				Util.showMessage("es null");
//			else 
//				Util.showMessage(file.toString());
		} catch (Exception e) {
			
			Util.showErrorMessage(e.getLocalizedMessage());
		
		} finally {

			return true;
		
		}
	}

	@Override
	protected boolean execute(Context context, String toScreen) throws Exception {
		// TODO Auto-generated method stub
		Util.showMessage(
				"Aquí lanzariamos la instal·lación personalizada del Apache via código java. Podemos llamar acciones de install4j o hacer un wrapper para independizarnos de la tecnologia");
		return false;
	}

	@Override
	protected boolean preaction(Context context) {
		// TODO Auto-generated method stub
		Util.showMessage("Aquí lanzariamos la PreAccion");
		return false;
	}

	@Override
	protected boolean postaction(Context context) {
		// TODO Auto-generated method stub
		Util.showMessage("Aquí lanzariamos la PostAccion");
		return false;
	}

}
